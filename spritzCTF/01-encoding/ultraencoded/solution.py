import base64
from dataclasses import replace
from textwrap import wrap

# Part 1
with open('zero_one', 'r') as file:
    input = file.read()

print(input)

# Part 2
input = input.replace("ZERO", "0")
input = input.replace("ONE", "1")
input = input.replace(" ", "")

print(input)

# Part 3
list = wrap(input, 8)
print(list)

# Part 4
result = ""

for n in list:
    result += chr(int(n, 2))

print(result)

# Part 5
decoded = base64.b64decode(result).decode('ascii')
print(decoded)

# Part 6
morse_code_dict = {
    '.-': 'A',
    '-...': 'B',
    '-.-.': 'C',
    '-..': 'D',
    '.': 'E',
    '..-.': 'F',
    '--.': 'G',
    '....': 'H',
    '..': 'I',
    '.---': 'J',
    '-.-': 'K',
    '.-..': 'L',
    '--': 'M',
    '-.': 'N',
    '---': 'O',
    '.--.': 'P',
    '--.-': 'Q',
    '.-.': 'R',
    '...': 'S',
    '-': 'T',
    '..-': 'U',
    '...-': 'V',
    '.--': 'W',
    '-..-': 'X',
    '-.--': 'Y',
    '--..': 'Z',
    '-----': '0',
    '.----': '1',
    '..---': '2',
    '...--': '3',
    '....-': '4',
    '.....': '5',
    '-....': '6',
    '--...': '7',
    '---..': '8',
    '----.': '9',
    '.-.-.-': '.',
    '--..--': ',',
    '---...': ':',
    '-.-.-.': ';',
    '..--..': '?',
    '-...-': '=',
    '-....-': '-',
    '..--.-': '_',
    '.----.': "'",
    '-..-.': '/',
    '-.--.': '(',
    '-.--.-': ')',
    '.-...': '&',
    '---.': '!',
    '-.-.--': '!',
    '...-.-': '+',
    '.-.-.': '@'
}

decoded_list = decoded.split(' ')

result = ""

for n in decoded_list:
    result += morse_code_dict[n]

print(result)
