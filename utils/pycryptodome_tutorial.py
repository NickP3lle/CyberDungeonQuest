from Crypto.Cipher import DES, AES, ChaCha20
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes

# Cipher = DES
# Mode = CBC
# Padding scheme = x923
# plaintext = 'La lunghezza di questa frase non è divisibile per 8'

plaintext = 'La lunghezza di questa frase non è divisibile per 8'

keyHex = 'a6aae64c549ff1e7'
key = bytes.fromhex(keyHex)

iv = get_random_bytes(8)

cipher = DES.new(key, DES.MODE_CBC, iv)
ciphertext = cipher.encrypt(
    pad(plaintext.encode('utf-8'), DES.block_size, style='x923'))

print(f'key.hex() = \'{key.hex()}\'')
print(f'iv.hex() = \'{iv.hex()}\'')
print(f'ciphertext = \'{ciphertext.hex()}\'')
print('\n')


# Cipher = AES256
# Mode of operation = CFB
# plaintext = 'Mi chiedo cosa significhi il numero nel nome di questo algoritmo.'
# Padding scheme = pkcs7 (block size = 16)
# Segment size = 24

key = get_random_bytes(32)
iv = get_random_bytes(16)
plaintext = 'Mi chiedo cosa significhi il numero nel nome di questo algoritmo.'

cipher = AES.new(key, AES.MODE_CFB, iv, segment_size=24)

padded_plaintext = pad(plaintext.encode(
    'utf-8'), AES.block_size, style='pkcs7')
ciphertext = cipher.encrypt(padded_plaintext)

print(f'key.hex() = \'{key.hex()}\'')
print(f'iv.hex() = \'{iv.hex()}\'')
print(f'ciphertext = \'{ciphertext.hex()}\'')
print('\n')


# Cipher = ChaCha20
# key.hex() = '01fb8cf52fa96d691f4413d0c153bf44148f1351e6fe96b32fcb429ff44af39d'
# ciphertext.hex() = '516a5107c0b1d73f4e623e00cb0d4807c8dbfbfa5785b8d5bece1246'
# Nonce = cipher.nonce.hex() = 'de4f13312aaa0e37'

key = bytes.fromhex(
    '01fb8cf52fa96d691f4413d0c153bf44148f1351e6fe96b32fcb429ff44af39d')
nonce = bytes.fromhex('de4f13312aaa0e37')

ciphertext = bytes.fromhex(
    '516a5107c0b1d73f4e623e00cb0d4807c8dbfbfa5785b8d5bece1246')

cipher = ChaCha20.new(key=key, nonce=nonce)
plaintext = cipher.decrypt(ciphertext)

print(f'key.hex() = \'{key.hex()}\'')
print(f'cipher.nonce.hex() = \'{cipher.nonce.hex()}\'')
print(f'ciphertext.hex() = \'{ciphertext.hex()}\'')
print(f'plaintext = \'{plaintext.decode("ASCII")}\'')
