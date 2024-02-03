file = open('enc', 'r').read()

print(file)

# flag = 'flag{ciaooo}'

# flag = ''.join([chr((ord(flag[i]) << 8) + ord(flag[i + 1]))
#                 for i in range(0, len(flag), 2)])

flag = ''.join([chr((ord(file[i]) >> 8) & 0xFF) +
               chr(ord(file[i]) & 0xFF) for i in range(len(file))])


print(flag)
