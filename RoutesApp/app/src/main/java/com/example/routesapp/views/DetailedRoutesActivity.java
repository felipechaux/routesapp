package com.example.routesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.routesapp.R;

public class DetailedRoutesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_routes);
    }


    public void To_Ph_Basic (View view)
    {
        Intent next = new Intent(this, PhotoBasicActivity.class);
        startActivity(next);
    }
}