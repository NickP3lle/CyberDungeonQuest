# Nice Netcat

There is a nice program that you can talk to, but it doesn't speak English... or does it? `nc mercury.picoctf.net 35652`

Link: [picoCTF](https://play.picoctf.org/practice/challenge/156?page=1&search=)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  Running the command will display a sequence of numbers. Lets's copy them in a file and see if we can find a pattern.

2.  The numbers are in the range of 0 to 255. This is the range of ASCII characters. Let's convert the numbers to ASCII characters.

3.  The flag is `picoCTF{g00d_k1tty!_n1c3_k1tty!_9b3b7392}`.

All the code can be found in [solve.py](./solve.py)

</details>
