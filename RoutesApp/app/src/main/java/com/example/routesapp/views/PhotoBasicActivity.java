package com.example.routesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.routesapp.R;

public class PhotoBasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_basic);
    }


    public void To_Photo (View view)
    {



        Intent next = new Intent(this, PhotoActivity.class);
        startActivity(next);




    }


}