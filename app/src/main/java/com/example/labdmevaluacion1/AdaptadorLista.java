package com.example.labdmevaluacion1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorLista extends BaseAdapter {
    private List<ListaPlantilla> datasource;
    private Context cntx;
    private int IdLaoutPlantilla;

    public List<ListaPlantilla> GetData(){return this.datasource;}

    public AdaptadorLista(Context context, int IdPlantilla, List<ListaEstudiante> sources){
        this.cntx = context;
        this.IdLaoutPlantilla = IdPlantilla;

    }

    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public ListaPlantilla getItem(int i) {
        return this.datasource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.IdLaoutPlantilla,null);

            TextView lblNombre = convertView.findViewById(R.id.lblNombre);
            TextView lblCodigo = convertView.findViewById(R.id.lblCodigo);
            TextView lblMateria = convertView.findViewById(R.id.lblMateria);


            lblNombre.setText(this.datasource.get(i).getNombre());
            lblCodigo.setText(this.datasource.get(i).getCodigo());
            lblMateria.setText(this.datasource.get(i).getMateria());
        }


        return convertView;
    }
}
