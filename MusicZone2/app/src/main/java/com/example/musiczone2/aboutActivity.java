package com.example.musiczone2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;


public class aboutActivity extends FragmentActivity {

    EditText et_source;
    Button bt_track;
    TextView et_destination;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        et_source =  findViewById(R.id.et_source);
        bt_track = findViewById(R.id.bt_track);

        bt_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get value from edit text
                String sSource = et_source.getText().toString().trim();

                String sDestination = "St francis institute of technology";

                //check condition
                if(sSource.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Starting Point", Toast.LENGTH_SHORT).show();
                }else{
                    //display track
                    DisplayTrack(sSource, sDestination);
                }
            }
        });

    }

    private void DisplayTrack(String sSource, String sDestination) {
        //if the device does not have a map installed,  then redirect it to play store
        try {
            //when google map is installed
            //initialize uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/"
                    + sDestination);
            //initialize intent with action view
            Intent intent =  new Intent(Intent.ACTION_VIEW,uri);
            //set package
            intent.setPackage("com.google.android.apps.maps");
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start activity
            startActivity(intent);

        }catch (ActivityNotFoundException e){
            //when google maps is not intalled
            //initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start activity
            startActivity(intent);

        }
    }


}