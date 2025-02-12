# Gnirts

`📱 Mobile` `⏮️ Reverse Engineering`

File: [gnirts](gnirts.apk)

## Solution

<details>
    <summary>Click to view the solution</summary>

1. First, we need to extract the APK file. We can do this by changing the extension of the file to `.zip` and decompile simply by extracting the contents.

2. Let's follow the code in FlagChecker class.

    - the flag has to start with `FLAG{` and end with `}`.
    - the length of the "core" of the flag has to be 26 characters (31 - 5 from the subscring function).
    - foo() returns "-" and the flag is split into 4 parts.
    - the first part has to be lowercase.
    - the third part has to be uppercase.
    - the fourth part has to be alphanumeric.
    - the fourth part has to contain exactly "11xXx1111" where 1 is any number, x is any lowercase letter and X is any uppercase letter.

3. Next, we need to solve some functions. The first one is:

    ```java
    me(ctx, dh(gs(ctx.getString(R.string.ct1), ctx.getString(R.string.k1)), ps[0]), ctx.getString(R.string.t1))
    ```

    `R.string.ct1` means we need to find the file `strings.xml` and look for the string with the id `ct1`. The same goes for `R.string.k1` and `R.string.t1`.

    We have `xwe`, `53P` and `82f5c1c9be89c68344d5c6bcf404c804` respectively.

    To simplify the execution of the function we can write java script with all the strings already substituted and then brute force the flag.

4. The solution code can be found [here](solution/Solve.java). Execute the following commands to start the program:

    ```bash
    javac Solve.java
    java Solve
    ```

5. The flag is `FLAG{sic-parvis-MAGNA-28jAn1596}`.

</details>
