# Level 4 - 3-way handshake

The ip command is one of the Linux tools for administering the network configuration.

In particular, you can assing an address to an interface using the following syntax:

`ip addr add [ipaddress/netmask] dev [devicename]` (for removing an existing address `ip addr del [ipaddress/netmask] dev [devicename]`)

For example, you can add to `eth0` the address `192.168.100.100` from the `192.168.100.0/24` network using:

`ip addr add 192.168.100.100/24 dev eth0`

Use this command for configuring the connection between node1 and node2 according to [this updated network layout](net2.png).

After you complete the above task, execute a 3-way handshake from node1 to node2 using the custom script level4 on node1.

Link: [CyberChallenge](https://cyberchallenge.it)

## Solution:

<details>
	<summary>Click here to see the solution</summary>

1.  We need to configure the network interfaces of `node1` and `node2` according to the picture network layout. We can do this by running the following commands respectively on `node1` and `node2`:

	```bash
	ip addr add 10.0.0.1/24 dev eth1

	ip addr add 10.0.0.2/24 dev eth0
	```

2.  Now we can simply run `level4` on `node1` to execute the 3-way handshake.

3.  Flag: `CCIT{level4_[ephemeralport]_[destinationport]_[clientstartsequencenumber]}` which is `CCIT{level4_2799_22_2254}`

</details>