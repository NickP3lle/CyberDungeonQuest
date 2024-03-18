# Level 3 - A well-known port

[This picture](net1.png) represents the network layout of the running containers. HOST represents the hosting machine (i.e., the machine running Docker).

Node1 is connected to the HOST node using the private network 192.168.168.0/24.

On each node, a network service is running. It is listening for connections on its own well-known port.

Try to identify the service and use the corresponding client for connecting to this service on node1 from the HOST node.

Remember that the root password is ccit.

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  Run `docker ps` to list the running containers.

2.  Run `docker network inspect <node1_id>` to look at the network details.

3.  We can see that the ip is `192.168.123.123`. Now we need to find the port.

4.  Let's run `ss -tuln` inside the container. We can see that the port is `22` which is a well-known port for `ssh`.

5.  Now we can connect to the service using `ssh root@192.168.123.123` and enter the password `ccit`.

6.  Flag: `CCIT{level2_2d01d80465de952d0788}`

</details>
