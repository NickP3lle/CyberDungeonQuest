cipher = "cvpbPGS{arkg_gvzr_V'yy_gel_2_ebhaqf_bs_ebg13_Ncualgvd}"
key = 13


def rot13(cipher):
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


print(rot13(cipher))
