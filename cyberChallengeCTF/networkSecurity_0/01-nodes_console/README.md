# Level 1 - Nodes Console

After you have executed the docker compose with make up, list the running containers and execute an interactive shell (i.e., /bin/bash) on node1 for getting the flag.

Notice that you require this command for accessing unconfigured nodes and solving the next challenges.

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  Run `docker ps` to list the running containers.

2.  Run `docker exec -it <node1_id> /bin/bash` to execute an interactive shell on node1.

3.  The flag will be `CCIT{level1_954e84dadc40a36201ab}`.

</details>
