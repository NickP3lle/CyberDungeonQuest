# FileHasher

`📱 Mobile`

You will need to write an app (with package name "com.example.maliciousapp") that exports a functionality to compute the SHA256 hash of a given file. You will need to define an activity with an intent filter for the "com.mobiotsec.intent.action.HASHFILE" action. The system will start your activity and ask you for hashing a file. The file path is specified in the Uri part of the intent you receive (which you can access with Intent.getData()). You need to put the calculated hash in a result intent (under the "hash" key, see below) and in hexadecimal format. To help you debug problems, the system will add in the log what the content of the file was, what it was expecting as the result hash, and what it found from your reply. If the expected hash and the one from your app match, the flag will be printed in the logs.

**_For this challenge inspecting the apk provided is not permitted._**

Example on how to pass the hash back:

```java
// calculate hash
String hash = calcHash(filePath);

// return the hash in a "result" intent
Intent resultIntent = new Intent();
resultIntent.putExtra("hash", hash);
setResult(Activity.RESULT_OK, resultIntent);
finish()
```

Useful documentation for solving this challenge:

-   [Activity](https://developer.android.com/reference/android/app/Activity)
-   [Explicit and implicit intents](https://developer.android.com/guide/components/intents-filters)
-   [MessageDigest](https://developer.android.com/reference/java/security/MessageDigest)

## Note

Android Studio is the recommended IDE for this challenge, along with the Android SDK API 33 (Tiramisu) and the Android Emulator.
Either Java or Kotlin can be used to solve this challenge. The provided solutions will be in Java.

To run the program use

```bash
python3 filehasher_checker.py <victim_app_path> <malicious_app_path>
```

## Solution

<details>
	<summary>Click here to see the solution</summary>

1.  Create a new project in Android Studio with the package name "com.example.maliciousapp".

2.  Create a new activity called "HashFileActivity". Make sure to export the activity and add an intent filter for the "com.mobiotsec.intent.action.HASHFILE" action. Also, add the necessary permissions to read the file.

```xml
<activity
    android:name=".HashFileActivity"
    android:exported="true" >
    <intent-filter>
        <action android:name="com.mobiotsec.intent.action.HASHFILE" />
        <category android:name="android.intent.category.DEFAULT" />
        <data android:mimeType="text/plain"/>
    </intent-filter>
</activity>
```

3.  Implement the logic to retrieve the intent data (file path), calculate the SHA256 hash of the file, and return the hash in the result intent.

4.  Once the apk is ready, install it on the device and run the app once. Nothing will happen here, probably the app will crash because there is no UI. Then run the [victim app](victim.apk) and, if everything is correct, the flag will be printed in the logs. You can also build and export the apk and run everything using the python script:

```bash
python3 filehasher_checker.py victim.apk solution/app-debug.apk

```

Flag: `FLAG{piger_ipse_sibi_obstat}`

The activity solution can be found [HashFileActivity.java](solution/HashFileActivity.java).

</details>
