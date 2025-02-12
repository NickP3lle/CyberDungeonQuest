# Going Native

`📱 Mobile` `⏮️ Reverse Engineering`

File: [goingnative.apk](goingnative.apk)

## Solution

<details>
    <summary> Click to view the solution </summary>

1. The java code suggests that the flag should be in the format FLAG{\*} and with an internal length of 15 characters. A native function is then called to check this internal part.

2. To understand what this function does we can decompile the apk and open the `/lib/x86*64/libgoingnative.so` file with a program like ida to check the assembly.

3. There are two main function. One is the entry point, the other one checks the flag. It is first split in different part with a delim parameter that has value "dw", in ascii "\_".

4. The split parts of the flag are cicled and compared with some values: status, 1234 and quo.

5. These are the parts of the flag `status_1234_quo` that corresponds to exactly 15 chars

Flag: `FLAG{status_1234_quo}`

</details>
