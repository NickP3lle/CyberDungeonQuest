# Generate by AI WhiteRabbitNeo 13B locally
# Yet to be tested

# This script is a basic framework and assumes that you have already found a way to interact with the vulnerable service. The `send_block_get_encrypted`
# function is used to send a block of data and receive its encrypted equivalent, which can be used for testing ECB vulnerabilities.

# Here is a high-level overview of the steps involved in an ECB Oracle attack:

# 1. Find a vulnerability that allows us to send blocks of data and observe their encrypted equivalents.
# 2. Determine the block size of the cipher used by the service.
# 3. Encrypt a unique string (e.g., "AES-128-ECB\x00") with the target key and find out if there are any differences in the encryption between identical input blocks.
# 4. Use this difference to leak information about the first block of plaintext from the original message.
# 5. Repeat the process for subsequent blocks, constructing the full original message.

from pwn import *
import itertools

# Establish a connection to the vulnerable service (replace 'target_ip' and 'port')
target_ip = '127.0.0.1'  # Replace with the IP address of the target service
port = 9999             # Replace with the port number of the target service
conn = remote(target_ip, port)


# Function to send a block and receive its encrypted version
def send_block_get_encrypted(block):
    conn.sendlineafter('Input: ', block)  # Send the input block
    return conn.recvline().strip()        # Receive the encrypted output block


# Determine the block size by sending and comparing blocks of different lengths
def determine_block_size():
    for length in range(1, 20):
        block = b'A' * length
        encrypted_block = send_block_get_encrypted(block)

        if 'Input too long!' not in encrypted_block:
            return length

    raise Exception("Could not determine the block size.")


# Find out if there are any differences in the encryption for identical blocks
def test_ecb_oracle():
    block = b'AES-128-ECB\x00'
    encrypted_block = send_block_get_encrypted(block)

    # Check if the block is different every time it is sent, indicating an ECB oracle
    return any(send_block_get_encrypted(block) != encrypted_block for _ in range(10))


# Perform the ECB Oracle attack to leak the first byte of the key
def ecb_oracle_attack():
    block_size = determine_block_size()  # Find the block size

    if test_ecb_oracle():
        print("The service is vulnerable to an ECB oracle attack.")

        # Prepare a dictionary of possible key bytes and their corresponding encrypted blocks
        key_byte_dict = {}
        for byte in range(256):
            # Generate a block with the byte at each position
            key = byte.to_bytes(block_size, 'big')
            key_encrypted = send_block_get_encrypted(key)

            if byte not in key_byte_dict:
                key_byte_dict[byte] = []

            key_byte_dict[byte].append((key, key_encrypted))

        # Find the original block and its encryption based on the first byte of the key
        for first_byte in itertools.product(range(256), repeat=block_size):
            first_block = bytes(first_byte)

            for i, byte in enumerate(first_byte):
                encrypted_key = send_block_get_encrypted(
                    bytes([byte]) * block_size)

                # If the encryption doesn't match, skip this key
                if not key_byte_dict[byte][0][1] == encrypted_key:
                    continue

            for i in range(block_size):
                key_byte_dict.pop(first_block[i], None)

            if not key_byte_dict:
                return first_block  # If the dictionary is empty, we've found the original block

    else:
        print("The service does not appear to be vulnerable to an ECB oracle attack.")


# Perform the attack
leaked_key = ecb_oracle_attack()
if leaked_key:
    print(f"Leaked key: {leaked_key}")
else:
    print("Unable to leak the key.")
