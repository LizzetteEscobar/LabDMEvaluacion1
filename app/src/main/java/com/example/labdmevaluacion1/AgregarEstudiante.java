package com.example.labdmevaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import static com.example.labdmevaluacion1.MainActivity.msjEstudiante;
import com.example.labdmevaluacion1.ListaEstudiante;
import com.example.labdmevaluacion1.AdaptadorLista;
import com.example.labdmevaluacion1.ListaPlantilla;

public class AgregarEstudiante extends AppCompatActivity {

    Button btnGuardar;
    EditText txtNombre, txtCodigo, txtMateria, txtPrimerParcial, txtSegundoParcial, txtTercerParcial;
    public static List<ListaEstudiante> valores=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_estudiante);

        btnGuardar = findViewById(R.id.btnGuardar);
        txtNombre = findViewById(R.id.txtNombre);
        txtCodigo = findViewById(R.id.txtMateria);
        txtMateria = findViewById(R.id.txtMateria);
        txtPrimerParcial = findViewById(R.id.txtPrimerParcial);
        txtSegundoParcial = findViewById(R.id.txtSegundoParcial);
        txtTercerParcial = findViewById(R.id.txtTercerParcial);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.length()>0 && txtCodigo.length()>0 && txtMateria.length()>0 && txtPrimerParcial.length()>0 && txtSegundoParcial.length()>0 && txtTercerParcial.length()>0){
                    Intent i = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(i,0);
                }else{
                    ToastValidador();
                }
            }
        });
    }
    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {
        super.onActivityResult(RequestCode, ResultCode, datos);
        if (ResultCode == RESULT_OK){
            ListaEstudiante nuevo= new ListaEstudiante();
            /*nuevo.setNombre(txtNombre.getText().toString());
            nuevo.setCodigo(txtCodigo.getText().toString());
            nuevo.setMateria(txtMateria.getText().toString());
            nuevo.setPrimerParcial(txtPrimerParcial.getText().toString());
            nuevo.setSegundoParcial(txtSegundoParcial.getText().toString());
            nuevo.setTercerParcial(txtTercerParcial.getText().toString());*/
            this.valores.add(nuevo);
            Intent enviar = new Intent();
            enviar.putExtra(msjEstudiante,"Encuestado Ingresado con exito");
            setResult(RESULT_OK, enviar);
            finish();
        }
    }
    public void ToastValidador(){
        Toast.makeText(this,"Hay campos vacios",Toast.LENGTH_SHORT).show();
    }
}
