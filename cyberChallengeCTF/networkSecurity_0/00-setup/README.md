# Level 0 - Setup

Install docker and docker-compose, see:

    https://docs.docker.com/engine/install/
    https://docs.docker.com/compose/install/

After this, you can execute the exercise scenario with make up.

Once the scenario has started, print the logs of the running containers for finding the flag.

You can stop the scenario with make down and clean the host configuration with make clean.

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  Run `make up` inside the folder.

2.  Run `docker ps` to list the running containers.

3.  Run `docker logs <container_id>` for each container and compose the flag.

4.  Flag`CCIT{level0_p4rt1_p4rt2_p4rt3_end}`.

</details>
