# Level 5 - A route to the flag

The ip command allows adding static routes.

In particular, you can update the routing table of a node and add a static route to a remote network using the following syntax:

`ip route add [remotenet_ipaddress/netmask] via [nexthop_ipaddress]`

Notice that the nexthop_ipaddress is the IP address of the node to which the packet should be forwarded for reaching the remote network.

Add a route to node2 so that it can reach the address `192.168.123.123`. Test your configuration executing the custom script level5.

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  `[nexthop_ipaddress]` for `node2` is `10.0.0.2`. So simply enter the command `ip route add 192.168.123.0/24 via 10.0.0.2` in it.

2.  Flag: `CCIT{level5_p1ngpungp4m11111}`

</details>