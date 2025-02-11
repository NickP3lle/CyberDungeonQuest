package com.example.justlisten;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FlagReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("victim.app.FLAG_ANNOUNCEMENT")) {
            String flag = intent.getStringExtra("flag");
            Log.d("MOBIOTSEC", "Flag: " + flag);
        }
    }
}
