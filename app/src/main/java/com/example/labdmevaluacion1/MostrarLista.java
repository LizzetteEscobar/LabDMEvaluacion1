package com.example.labdmevaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import static com.example.labdmevaluacion1.AgregarEstudiante.valores;
public class MostrarLista extends AppCompatActivity {

    private ListView valoresLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        valoresLista = findViewById(R.id.listValores);
        this.valoresLista.setAdapter(new AdaptadorLista(this,R.layout.activity_lista_estudiante, valores));
    }
}
