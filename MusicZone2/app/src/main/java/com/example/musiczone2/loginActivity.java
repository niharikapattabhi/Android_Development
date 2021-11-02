package com.example.musiczone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText email1, password1;
    Button loginbutton1;
    DBHelper DB;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email1 = (EditText) findViewById(R.id.email1);
        password1 = (EditText) findViewById(R.id.password1);
        loginbutton1 = (Button) findViewById(R.id.loginbutton1);
        DB = new DBHelper(this);

        sp = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        loginbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email1.getText().toString();
                String password = password1.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("email", email);
                editor.commit();

                if(email.equals("")||password.equals(""))
                    Toast.makeText(loginActivity.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkemailpassword = DB.checkemailpassword(email, password);
                    if(checkemailpassword==true){
                        Toast.makeText(loginActivity.this, "Successful login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), chooseActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}