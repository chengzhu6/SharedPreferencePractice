package com.thoughtworks.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SPActivity extends AppCompatActivity {
    private static final String DEFAULT_VALUE = "";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p_activty);
        sharedPreferences = getApplicationContext()
                .getSharedPreferences(String.valueOf(R.string.preferences_file_key), Context.MODE_PRIVATE);
        final EditText editText = findViewById(R.id.edit_text);
        setOldValue(editText);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = editText.getText().toString();
                saveInputValue(inputValue);
            }
        });
    }

    private void setOldValue(EditText editText) {
        String oldValue = sharedPreferences.getString(String.valueOf(R.string.edit_text), DEFAULT_VALUE);
        editText.getText().append(oldValue);
    }

    private void saveInputValue(String inputValue) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(String.valueOf(R.string.edit_text), inputValue);
        edit.apply();
    }
}