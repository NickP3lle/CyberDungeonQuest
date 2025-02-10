# Just Ask

`📱 Mobile`

There is an app installed on the system. The app has four activities. Each of them has one part of the flag. If you ask them nicely, they will all kindly reply with their part of the flag. They will reply with an Intent, the part of the flag is somehow contained there. Check the app's manifest for the specs. Good luck ;-)

A python script is also available to run the program and check the solution.

**_For this challenge inspecting the apk provided is not permitted._**

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.victimapp">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.VictimApp">
        <activity android:name=".MainActivity" android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".PartOne" android:exported="true"/>
        <activity android:name=".PartTwo" android:exported="true">
            <intent-filter>
                <action android:name="com.example.victimapp.intent.action.JUSTASK"/>
                <category android:name="android.intent.category.DEFAULT"/>
            </intent-filter>
        </activity>
        <activity android:name=".PartThree" android:exported="true"/>
        <activity android:name=".PartFour" android:exported="true">
            <intent-filter>
                <action android:name="com.example.victimapp.intent.action.JUSTASKBUTNOTSOSIMPLE"/>
                <category android:name="android.intent.category.DEFAULT"/>
            </intent-filter>
        </activity>
    </application>
</manifest>
```

## Solution

<details>
  <summary>Click to expand</summary>
  
1. The [victim app](victim.apk) has five activities, each of them has one part of the flag. One of them is the main activity or launcher activity. The others are the most interesting.

2. The first activity is _PartOne_. It is exported and doesn't have an intent filter, which means that it can only be started explicitly. Once started it will return an intent with the first part of the flag.

```java
Intent intent = new Intent();
intent.setComponent(new ComponentName("com.example.victimapp", "com.example.victimapp.PartOne"));
```

3. The second activity is _PartTwo_. It is exported and has an intent filter. It can be started implicitly. Once started it will return an intent with the second part of the flag.

```java
Intent intent2 = new Intent("com.example.victimapp.intent.action.JUSTASK");
```

4. The third activity is _PartThree_. It is exported and doesn't have an intent filter, which means that it can only be started explicitly. Once started it will return an intent with the third part of the flag. The difference here is that it has more than one key-value pair in the intent.

5. The fourth activity is _PartFour_. It is exported and has an intent filter. It can be started implicitly. Once started it will return an intent with a bundle containing other nested bundles. Inside this bundles there is the fourth part of the flag.

Flag: `FLAG{Gutta_cavat_lapidem_non_vi_sed_saepe_cadendo}`

The activity solution can be found [HashFileActivity.java](solution/MainActivity.java).

</details>
