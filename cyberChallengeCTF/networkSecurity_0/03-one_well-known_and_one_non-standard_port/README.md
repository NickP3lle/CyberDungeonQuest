# Level 3 - One well-known and one non-standard port

After you have solved the level2, two new services are listening for connections on node1.

They use the same application protocol. You can identify it referring to the well-known port.

Use the corresponding client for connecting to the two services on node1 from the HOST node.

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  Make sure you have solved level2 and you have the `node1` container running.

2.  Run `ss -tuln` inside the container. We can see that there are two new ports: `80` and `8080`. Port `80` is a well-known port for `http` and port `8000` is a non-standard port.

3.  Now we can connect to the service using `curl 192.168.123.123:80` and `curl 192.168.123.123:8000`.

4.  Both services will return a part of the flag coded in base64 as images. We can use an online tool to decode the base64 and get the flag.

6.  Flag: `CCIT{level3_4br4cafl4gg4}`

</details>