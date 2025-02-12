# Going Serious Native

`📱 Mobile` `⏮️ Reverse Engineering`

File: [goingseriousnative.apk](goingseriousnative.apk)

## Solution

<details>
<summary>Click to see the solution</summary>

1. Decompile the apk with jadx.

2. Open the MainActivity.java file and look at the code. The flag is checked in the `checkFlag` function. This is a native function, so we need to look at the native c++ code.

3. In the `/lib/x86_64/` folder we can find the `libgoingseriousnative.so` file. Open it with a program like IDA to check the disassembled content.

4. The entry point of the program is the Main Activity function. In particular the `preprocessing` function is called here. We are going to analize this function.

5. A string is tokenized with `strtok` function and the space character as delimiter. From the tokens are extracted integers values and, if these values are five in total, a `validate` function is now called.

6. The `validate` cicles through the 5 elements of the array created in the previous function and adds them to a variable. If the sum of the elements is equal to 100 the program returns 0, which is what the java code is expecting. There are multiple pins that we can use to get the correct sum. For instance, `100 0 0 0 0` or `20 20 20 20 20`.

7. The flag is printed: `FLAG{omnia_prius_experiri_quam_armis_sapientem_decet}`.

</details>
