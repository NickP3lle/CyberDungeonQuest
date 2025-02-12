# Babyrev

`📱 Mobile` `⏮️ Reverse Engineering`

File: [babyrev](babyrev.apk)

## Solution

<details>
	<summary>Click to view the solution</summary>

1. First, we need to extract the APK file. We can do this by changing the extension of the file to `.zip` and decompile simply by extracting the contents.

2. We can see that the APK file contains some `.dex` files. We can use `jadx-gui` to look at these files.

3. We can find the package `com.mobiotsec.babyrev` in the `class3.dex` file. The `checkFlag` function guides us to the flag. We have the following informations:

    - The flag is a string.
    - The flag is 27 characters long.
    - The flag is in the format `FLAG{}`.
    - The firt characters of the flag are `scientia`.

FLAG: `FLAG{ScIeNtIa_pOtEnTiA_EsT}`

</details>
