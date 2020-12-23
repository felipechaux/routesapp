package com.example.routesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
    }


    public void Regresar (View view){
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }




    public void Consultar (View view) {
        Toast.makeText(this, "Consultando Rutas...", Toast.LENGTH_SHORT).show();


        Intent next = new Intent(this, AllRoutesActivity.class);
        startActivity(next);
    }
}