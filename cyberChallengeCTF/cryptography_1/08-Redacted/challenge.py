#!/usr/bin/env python2.7

from Crypto.Cipher import AES
import binascii
import sys

KEY = "yn9RB3Lr43xJK2██".encode()
IV = "████████████████".encode()
msg = "AES with CBC is very unbreakable".encode()

aes = AES.new(KEY, AES.MODE_CBC, IV)
print(binascii.hexlify(AES.encrypt(msg)).decode())

# output:
# c5██████████████████████████d49e78c670cb67a9e5773d696dc96b78c4e0
