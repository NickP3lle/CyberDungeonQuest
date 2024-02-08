# Information

Files can always be changed in a secret way. Can you find the flag?

Link: [picoCTF](https://play.picoctf.org/practice/challenge/186?page=1&search=)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  We are given an image so let's start by looking at it.

2.  Nothing right? Let's see if the `file` command gives us something. Running `file Cat\ from\ picoCTF.jpg` doesn't give us anything useful.

3.  Let's then try to use the `cat` command as the file name suggests. Running `cat Cat\ from\ picoCTF.jpg` gives us a lot of gibberish. But there is something at the top that is human readable. To make things easier we can change the extension of the file to .txt and open it in a text editor.

4.  We can see that there is a lot of metadata at the top of the file. There is an id and a resource attribute that seem to be encoded, maybe base64? Let's try to decode them with `echo "W5M0MpCehiHzreSzNTczkc9d" | base64 -d` and see what we get.

5.  Id gives us something gibberish but resource gives us the flag: `picoCTF{the_m3tadata_1s_modified}`

</details>
