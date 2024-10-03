from curses.ascii import isupper
from textwrap import wrap


# Part 1
f = open("challenge.txt")
output = ""
for x in f:
    for y in list(x):
        if y.isupper():
            output += y

print(output)

# Part 2
output = output.replace('ZERO', '0')
output = output.replace('ONE', '1')

print(output)

# Part 3
list = wrap(output, 8)

print(list)

# Part 4
for n in list:
    print(chr(int(n, 2)), end="")
print()
