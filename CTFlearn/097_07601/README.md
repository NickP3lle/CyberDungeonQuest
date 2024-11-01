# 07601

I think I lost my flag in there. Hopefully, it won't get attacked...

`🔎 Forensics`

Link: [CTFlearn](https://ctflearn.com/challenge/97)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1. Using the `strings` command we can see a fake flag `ABCTF{fooled_ya_dustin}`. We can also see that there could be some hidden files in the image.

2. We can use the `binwalk` command to extract the hidden files. The command is `binwalk -e AGT.png`.

3. We can use `strings` on the hidden files to find the flag `ABCTF{Du$t1nS_D0jo}`.

</details>
