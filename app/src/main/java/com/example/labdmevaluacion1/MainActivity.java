package com.example.labdmevaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import java.security.AccessController;

public class MainActivity extends AppCompatActivity {

    Button btnNuevoEstudiante;
    Button btnListaEstudiante;
    public static String msjEstudiante="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNuevoEstudiante = findViewById(R.id.btnNuevoEstudiante);
        btnListaEstudiante = findViewById(R.id.btnListaEstudiante);

        btnNuevoEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AgregarEstudiante.class);
                startActivityForResult(i,0);
            }
        });

        btnListaEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaEstudiante.class);
                startActivityForResult(i,0);
            }
        });
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {
        super.onActivityResult(RequestCode, ResultCode, datos);
        if (ResultCode == RESULT_OK){
            Toast.makeText(this,datos.getStringExtra(msjEstudiante),Toast.LENGTH_SHORT).show();
        }
    }
}
