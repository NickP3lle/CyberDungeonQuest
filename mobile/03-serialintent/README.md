# Serial Intent

`📱 Mobile`

Start the SerialActivity, it will give you back the flag. Kinda.

Check out the source code of the AndroidManifest file, the SerialActivity and the FlagContainer classes of the victim app.

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
        <activity android:name=".SerialActivity" android:exported="true"/>
    </application>
</manifest>
```

```java
package com.example.victimapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SerialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MOBIOTSEC", "shuffling");
        FlagShuffler fs = new FlagShuffler();
        FlagContainer fc = fs.shuffleFlag(MainActivity.flag);


        Log.e("MOBIOTSEC", "sending back intent");
        Intent resultIntent = new Intent();
        resultIntent.putExtra("flag", fc);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
```

```java
package com.example.victimapp;

import android.util.Base64;
import android.util.Log;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class FlagContainer implements Serializable {
    private String[] parts;
    private ArrayList<Integer> perm;

    public FlagContainer(String[] parts, ArrayList<Integer> perm) {
        this.parts = parts;
        this.perm = perm;
    }

    private String getFlag() {
        int n = parts.length;
        int i;
        String b64 = new String();
        for (i=0; i<n; i++) {
            b64 += parts[perm.get(i)];
        }

        byte[] flagBytes = Base64.decode(b64, Base64.DEFAULT);
        String flag = new String(flagBytes, Charset.defaultCharset());

        return flag;
    }
}
```

Useful documentation for solving this challenge:

-   [Explicit and implicit intents](https://developer.android.com/guide/components/intents-filters)

-   [Retrieving a result from an activity](https://developer.android.com/training/basics/intents/result)

-   [The Serializable interface](https://developer.android.com/reference/java/io/Serializable)

-   [Java reflection](https://www.oracle.com/technical-resources/articles/java/javareflection.html)

## Solution

<details>
	<summary>Click to view the solution</summary>

1. The `SerialActivity` can be started by creating an explicit intent. The `SerialActivity` will shuffle the flag and send it back to the calling activity.

2. By using the `startActivityForResult` method, the calling activity can receive the FlagContainer object from the `SerialActivity`. This is a serialized object that contains the shuffled flag and cannot be directly cast to a `FlagContainer` object.

3. The idea is to replicate package and class structure of the `FlagContainer` class in the malicious app. This way, the serialized object can be cast to the replicated class and the flag can be extracted. Remember to change the method `getFlag` to public in the replicated class.

4. As all the first tries, this will fail due to the `serialVersionUID` mismatch. Such an error will be shown:

```java
Caused by: java.io.InvalidClassException: com.example.victimapp.FlagContainer; local class incompatible: stream classdesc serialVersionUID = 1777556209636587368
```

5. The `serialVersionUID` is a unique identifier for the class. By setting the `serialVersionUID` of the replicated class to the same value as the original class, the error can be avoided and the flag can be extracted:

```java
private static final long serialVersionUID = 1777556209636587368L;
```

6. The flag is now extracted and can be printed to the console.

Flag: `FLAG{memento_audere_semper}`

</details>
