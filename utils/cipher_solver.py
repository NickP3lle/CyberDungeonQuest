# cipher = "cvpbPGS{arkg_gvzr_V'yy_gel_2_ebhaqf_bs_ebg13_Ncualgvd}"
# key = 13


def solveCipher(cipher):
    plain = ""
    for c in cipher:
        if c.isalpha():
            if c.isupper():
                plain += chr((ord(c) - ord('A') + key) % 26 + ord('A'))
            else:
                plain += chr((ord(c) - ord('a') + key) % 26 + ord('a'))
        else:
            plain += c
    return plain


cipher = input("Enter the cipher text: ")

key = int(input("Enter the key. If you don't know the key, enter 0: "))

if key != 0:
    print(solveCipher(cipher))
else:
    for i in range(26):
        key = i
        print(f"Key: {key}\t\tPlain Text: {solveCipher(cipher)}")
