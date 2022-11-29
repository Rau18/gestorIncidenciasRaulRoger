package com.example.gestorincidencies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnCrear(View view) {
        Intent paginaCrear = new Intent(this, mainCrear.class);
        startActivity(paginaCrear);
        finish();
    }
    public void btnVisualizar(View view){
        Intent visualizar = new Intent(this, mainVisualizar.class);
        startActivity(visualizar);
        finish();
    }
}

