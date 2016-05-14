package com.filipkesteli.audiomanagertutorial;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mode, ring, vibrate, silent;
    private AudioManager myAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        vibrate = (Button) findViewById(R.id.button3);
        mode = (Button) findViewById(R.id.button2);
        silent = (Button) findViewById(R.id.button);
        silent = (Button) findViewById(R.id.button4);
        myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    private void setupListeners() {
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this, "Now is Vibrate Mode", Toast.LENGTH_SHORT).show();
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this, "Now in Ringing Mode", Toast.LENGTH_LONG).show();
            }
        });
        
        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this, "Now in Silent Mode", Toast.LENGTH_LONG).show();
            }
        });

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mod = myAudioManager.getRingerMode();

                if (mod == myAudioManager.RINGER_MODE_VIBRATE) {
                    Toast.makeText(MainActivity.this, "Now in Vibrate Mode", Toast.LENGTH_LONG).show();
                } else if (mod == myAudioManager.RINGER_MODE_NORMAL) {
                    Toast.makeText(MainActivity.this, "Now in Normal Mode", Toast.LENGTH_SHORT).show();
                } else if (mod == myAudioManager.RINGER_MODE_SILENT) {
                    Toast.makeText(MainActivity.this, "Now in Silent Mode", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
