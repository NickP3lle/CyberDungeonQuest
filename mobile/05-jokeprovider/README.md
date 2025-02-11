# Joke Provider

`📱 Mobile`

This task will let you play with Content Providers.

The target app exposes a Content Provider. Find all jokes and concatenate them. That's the flag.

Some partial info on the target app:

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
        ....
        <provider
            android:name=".MyProvider"
            android:authorities="com.example.victimapp.MyProvider"
            android:enabled="true"
            android:exported="true">
        </provider>
    </application>
</manifest>
```

```java
String CREATE_TABLE = " CREATE TABLE joke" + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + " author TEXT NOT NULL, " + " joke TEXT NOT NULL);";
```

```java
static final String PROVIDER_NAME = "com.example.victimapp.MyProvider";
static final String TABLE_NAME = "joke";
static final String URL = "content://" + PROVIDER_NAME + "/" + TABLE_NAME;
static final int uriCode = 1;

static final UriMatcher uriMatcher;
static{
    uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    uriMatcher.addURI(PROVIDER_NAME, TABLE_NAME, uriCode);
}
```

Useful documentation for solving this challenge:

-   [Content providers](https://developer.android.com/guide/topics/providers/content-provider-basics)

-   [Package visibility](https://developer.android.com/training/package-visibility/declaring#provider-authority)

## Solution

<details>
	<summary>Click to view the solution</summary>

1. We can clearly see that the target app has a Content Provider enabled and exported. This means that we can access it from another app.

2. The websites provided are useful to understand how to interact with a Content Provider... but only querying the Content Provider is not enough.

3. In order to obtain the communication with the Content Provider, we need to add a few lines to the `AndroidManifest.xml` file of our app.

```xml
<queries>
	<provider android:authorities="com.example.victimapp.MyProvider" />
</queries>
```

4. Now we can query the Content Provider, get the jokes and compose the flag.

Flag: `FLAG{Homo_faber_fortunae_suae}`

Solution: [MainActivity.java](solution/MainActivity.java)

</details>
