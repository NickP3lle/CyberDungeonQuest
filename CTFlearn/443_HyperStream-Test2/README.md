# HyperStream Test #2

I love the smell of bacon in the morning! ABAAAABABAABBABBAABBAABAAAAAABAAAAAAAABAABBABABBAAAAABBABBABABBAABAABABABBAABBABBAABB

`🔐 Cryptography`

Link: [CTFlearn](https://ctflearn.com/challenge/443)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1. We could try to replace the letters with 0s and 1s and convert them to ASCII characters.

2. The results are not very promising. Looking on the internet, we find that the Baconian cipher is a method of steganography created by Francis Bacon. The Baconian cipher is a method of encoding a message in which each letter is replaced by two groups of letters, each of which is a jumble of five of the six letters 'A' and 'B'.

3. We can use a dictionary to map the Baconian cipher to the ASCII characters.

4. The flag is `ILOUEBACONDONTYOU`

All the code can be found in [solve.py](./solve.py)

</details>
