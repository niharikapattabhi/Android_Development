package com.example.musiczone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //home to login activity
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openloginActivity();
            }
        });

        //home to signup activity
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignupActiviy();
            }
        });
    }

    public void openloginActivity (){
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }
    public void opensignupActiviy(){
        Intent intent = new Intent(this, signupActivity.class);
        startActivity(intent);
    }
}