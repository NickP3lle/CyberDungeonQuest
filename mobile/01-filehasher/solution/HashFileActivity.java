package com.example.maliciousapp;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;

import java.io.InputStream;
import java.security.MessageDigest;

public class HashFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        if (intent != null && intent.getAction() != null && intent.getAction().equals("com.mobiotsec.intent.action.HASHFILE")) {
            Uri fileUri = intent.getData();

            if (fileUri != null) {
                String hash = calculateFileHash(fileUri);
                if (hash != null) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hash", hash);
                    setResult(Activity.RESULT_OK, resultIntent);
                } else {
                    setResult(Activity.RESULT_CANCELED);
                }
            } else {
                setResult(Activity.RESULT_CANCELED);
            }
        } else {
            setResult(Activity.RESULT_CANCELED);
        }

        finish();
    }

    private String calculateFileHash(Uri fileUri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(fileUri);
            if (inputStream == null) return null;

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }

            inputStream.close();

            byte[] hashBytes = digest.digest();
            return bytesToHex(hashBytes);
        } catch (Exception e) {
            return null;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}