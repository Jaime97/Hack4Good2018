package com.dls.h4g;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton sendButton;
    private EditText phraseEditText;
    private Button resetButton;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        sendButton = findViewById(R.id.sendButton);
        resetButton = findViewById(R.id.resetButton);
        phraseEditText = findViewById(R.id.phraseEditText);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest(phraseEditText.getText().toString());
                phraseEditText.setText("");
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
            }
        });
    }

    public void makeRequest(String text) {
        if (text != null) {
            count++;
            switch (count) {
                case 1:
                    playSound("in_the_morning.mp3");
                    break;
                case 2:
                    playSound("some_coffe_would_be_nice.mp3");
                    break;
            }
        }
    }

    private void playSound(String fileName) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor afd = getAssets().openFd(fileName);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
}
