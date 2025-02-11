package com.example.justlisten;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.util.Log;

//import FlagReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MOBIOTSEC";

    private FlagReceiver flagReceiver = new FlagReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("victim.app.FLAG_ANNOUNCEMENT");

        registerReceiver(flagReceiver, filter);
    }
}