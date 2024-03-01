# GET aHEAD

Find the flag being held on this server to get ahead of the competition.

`http://mercury.picoctf.net:53554/`

Link: [picoCTF](https://play.picoctf.org/practice/challenge/132?page=1&search=)

# Solution

<details>
	<summary>Click here to see the solution</summary>

1.  There are buttons on the page that allow us to change color of the background: Red or Blue. Inspecting the page, we can see that the buttons are sending http requests to the server usign method GET for red and POST for blue.

2.  Using some tools like wget or curl, we can send the same requests trying to pass some parameters to get the flag. We can notice that any parameter we pass the background turns red with get and blue with post. Maybe we can try to pass something else.

3.  Using the method HEAD we get the flag. `curl -I http://mercury.picoctf.net:53554/index.php` gives us the flag: `picoCTF{r3j3ct_th3_du4l1ty_2e5ba39f}`

All the code can be found in [solve.py](./solve.py)

</details>
