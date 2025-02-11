# Just Listen

`📱 Mobile`

The flag is announced on the system with a broadcast intent with action victim.app.FLAG_ANNOUNCEMENT

A python script is also available to run the program and check the solution.

**_For this challenge inspecting the apk provided is not permitted._**

Useful documentation for solving this challenge:

-   [Broadcast Receivers](https://developer.android.com/guide/components/broadcasts)

## Solution

<details>
	<summary>Click to view the solution</summary>

1.  The flag is announced on the system with a broadcast intent with action `victim.app.FLAG_ANNOUNCEMENT`.

2.  We can build a broadcast receiver to listen for the flag announcement.

Flag: `FLAG{carpe_diem}`

The solution can be founf in [MainActivity.java](solution/MainActivity.java) and [FlagReceiver.java](solution/FlagReceiver.java)

</details>
