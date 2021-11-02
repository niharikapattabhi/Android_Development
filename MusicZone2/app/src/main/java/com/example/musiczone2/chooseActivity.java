package com.example.musiczone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseActivity extends AppCompatActivity {

    private Button playMusic, aboutusbtn, userprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        //to go to about us
        aboutusbtn = (Button) findViewById(R.id.aboutusbtn);
        aboutusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_aboutActivity();
            }
        });

        //to go to music player
        playMusic = (Button) findViewById(R.id.playMusic);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmusic_MainActivity();
            }
        });

        //to go to user profile
        userprofile = (Button) findViewById(R.id.userprofile);
        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_profileActivity();
            }
        });


    }

    private void openmusic_MainActivity() {
        Intent intent = new Intent(this, music_MainActivity.class);
        startActivity(intent);
    }

    private void open_aboutActivity() {
        Intent intent = new Intent(this, aboutActivity.class);
        startActivity(intent);
    }

    private void open_profileActivity() {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }


}


