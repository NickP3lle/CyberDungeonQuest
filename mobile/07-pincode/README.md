# Pincode

`📱 Mobile` `⏮️ Reverse Engineering`

File: [pincode](pincode.apk)

## Solution

<details>
	<summary>Click to view the solution</summary>

1. First, we need to extract the APK file. We can do this by changing the extension of the file to `.zip` and decompile simply by extracting the contents.

2. We can see that the APK file contains some `classes.dex` files. We can open them using `jadx-gui` and see the source code.

3. The app is using a hash function to hash the pincode and compare it with the hash of the correct pincode. We can brute force the pincode by hashing all the possible pincode values and comparing them with the hash.

4. For efficiency I have used a C++ program to generate the hash of all the possible pincode values and compare them with the hash. It can be found in the [solution](solution/solve.cpp) folder.

To compile the program you need to have `openssl` installed.

```bash
clang++ -std=c++17 -pthread -I/opt/homebrew/opt/openssl@3/include -L/opt/homebrew/opt/openssl@3/lib solve.cpp -lcrypto
```

Pincode: `703958`
Flag: `FLAG{in_vino_veritas}`

</details>
