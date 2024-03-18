# ciphertext = "104e137f425954137f74107f525511457f5468134d7f146c4c"


def xor(a, b):
    return bytes([x ^ y for x, y in zip(a, b)])


ciphertext = input("Enter ciphertect to xor: ")

for i in range(256):
    key = bytes([i]) * len(ciphertext)
    plaintext = xor(bytes.fromhex(ciphertext), key)
    print(plaintext)
    # if b"flag" in plaintext:
    # 	print(plaintext)
    # 	break
