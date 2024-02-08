# Part 1
file = open('file.txt', 'r').read()

print(file)

list = file.replace(" ", "").split('\n')

list.pop()

print(list)

output = ""

# Part 2
for i in range(len(list)):
    list[i] = chr(int(list[i], 10))
    output += list[i]

print(output)
