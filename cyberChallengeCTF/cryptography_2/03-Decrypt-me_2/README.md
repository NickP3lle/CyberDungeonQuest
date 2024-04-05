# Decrypt-me 2

decrypt me, again!

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1. Now we are dealing with much bigger numbers, so we can't use factordb.com to find the factors.

2. If we ipotize that the message is in the format `CCIT{...}`, we can use the flag as the plaintext, encrypt it and compare the result with the given ciphertext. All this must be done character by character.

3. Flag: `CCIT{d3crypt_0r_3ncrypt_m3?}`

All the code can be found in [solve.py](solution/solve.py).

</details>
