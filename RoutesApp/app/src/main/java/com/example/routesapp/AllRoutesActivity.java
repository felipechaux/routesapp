package com.example.routesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AllRoutesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_routes);
    }


    public void ToDetailed (View view)
    {



            Intent next = new Intent(this, DetailedRoutesActivity.class);
            startActivity(next);




    }
}