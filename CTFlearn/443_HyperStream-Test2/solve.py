cipher_text = "ABAAAABABAABBABBAABBAABAAAAAABAAAAAAAABAABBABABBAAAAABBABBABABBAABAABABABBAABBABBAABB"

cipher_text = cipher_text.lower()

encoding_dict = {
    'aaaaa': 'A',
    'aaaab': 'B',
    'aaaba': 'C',
    'aaabb': 'D',
    'aabaa': 'E',
    'aabab': 'F',
    'aabba': 'G',
    'aabbb': 'H',
    'abaaa': 'I', # I/J
    'abaab': 'K',
    'ababa': 'L',
    'ababb': 'M',
    'abbaa': 'N',
    'abbab': 'O',
    'abbba': 'P',
    'abbbb': 'Q',
    'baaaa': 'R',
    'baaab': 'S',
    'baaba': 'T',
    'baabb': 'U', # U/V
    'babaa': 'W',
    'babab': 'X',
    'babba': 'Y',
    'babbb': 'Z'
}

decoded_text = ""

for i in range(0, len(cipher_text), 5):
    decoded_text += encoding_dict[cipher_text[i:i+5]]

print(decoded_text)