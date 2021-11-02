package com.example.musiczone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    EditText email2, password2, confirmpassword2;
    Button registerbutton;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email2 = (EditText) findViewById(R.id.email2);
        password2 = (EditText) findViewById(R.id.password2);
        confirmpassword2 = (EditText) findViewById(R.id.confirmpassword2);
        registerbutton = (Button) findViewById(R.id.registerbutton);
        DB = new DBHelper(this);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email2.getText().toString();
                String password = password2.getText().toString();
                String confirmpassword = confirmpassword2.getText().toString();

                if(email.equals("")||password.equals("")||confirmpassword.equals(""))
                    Toast.makeText(signupActivity.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(confirmpassword)) {
                        Boolean checkemail = DB.checkemail(email);
                        if (checkemail == false) {
                            Boolean insert = DB.insertData(email, password);
                            if (insert == true) {
                                Toast.makeText(signupActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), chooseActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(signupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(signupActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(signupActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}