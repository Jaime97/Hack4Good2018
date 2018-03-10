package com.dls.h4g;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton sendButton;
    private EditText phraseEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        sendButton = findViewById(R.id.sendButton);
        phraseEditText = findViewById(R.id.phraseEditText);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest(phraseEditText.getText().toString());
            }
        });
    }

    public void makeRequest(String text) {

    }

}
