package com.example.routesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
    }

    public void Return (View view)
    {



            //Toast.makeText(this, "Validando información", Toast.LENGTH_SHORT).show();


            Intent next = new Intent(this, PhotoBasicActivity.class);
            startActivity(next);
        }




}