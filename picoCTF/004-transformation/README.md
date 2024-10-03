# Transformation

I wonder what this really is... [enc](./enc)

`''.join([chr((ord(flag[i]) << 8) + ord(flag[i + 1])) for i in range(0, len(flag), 2)])`

Link: [picoCTF](https://play.picoctf.org/practice/challenge/104?page=1&search=)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  The given code is a simple python code that takes a string and converts it into a new string by taking two characters at a time and converting them into a single character. We can try to use it to convert the given string back to the original string... ok maybe not.

2.  We can try to reverse the process. The reverse of the given code is is in the solve.py file.

3.  Running the code gives us the flag: `picoCTF{16_bits_inst34d_of_8_0ddcd97a}`

All the code can be found in [solve.py](./solve.py)

</details>
