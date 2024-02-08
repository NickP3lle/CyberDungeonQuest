file = open('enc', 'r').read()

print(file)

flag = ''.join([chr((ord(file[i]) >> 8) & 0xFF) +
               chr(ord(file[i]) & 0xFF) for i in range(len(file))])

print(flag)
