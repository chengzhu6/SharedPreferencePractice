package com.thoughtworks.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go_to_sp_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createSPActivity();
            }
        });
    }

    private void createSPActivity() {
        Intent intent = new Intent(this, SPActivity.class);
        startActivity(intent);
    }
}