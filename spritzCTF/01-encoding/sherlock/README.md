# Sherlock

Sherlock has a mystery in front of him. Help him find the flag.

## Solution:

<details>
	<summary>Click here to see the solution</summary>

-   If we read the file `challenge.txt` we can see there are some letters that are uppercase in a weird way. Let's try to get all of them.

-   We can now see that these letters make two words: ONE or ZERO. Let's try to convert them to binary.

-   We can try to group them in groups of 8.

-   Now the binary is in groups of 8. Let's try to convert them to ASCII.

-   We can see that the flag is `BITSCTF{h1d3_1n_pl41n_5173}`.

All the code can be found in [solution.py](./solution.py)

</details>
