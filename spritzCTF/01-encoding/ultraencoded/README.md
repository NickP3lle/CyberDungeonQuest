# Ultra Encoded

Fady didn't understand well the difference between encryption and encoding,
so instead of encrypting some secret message to pass to his friend, he
encoded it!

The flag should be in the format: ALEXCTF

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  We read the file and we can see that it contains only ZEROs and ONEs.

2.  We can convert them to binary.

3.  We can try to group them in groups of 8.

4.  Now the binary is in groups of 8. Let's try to convert them to ASCII.

5.  The format seems to be base64. Let's try to decode it.

6.  Now we can see something similar to the morse code. Let's try to decode it with a dictionary.

7.  The flag is `ALEXCTFTH15O1SO5UP3RO5ECR3TOTXT`

All the code can be found in [solution.py](./solution.py)

</details>
