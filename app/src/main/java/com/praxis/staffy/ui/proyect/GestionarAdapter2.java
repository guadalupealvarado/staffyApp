package com.praxis.staffy.ui.proyect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.praxis.staffy.R;

public class GestionarAdapter2 extends BaseAdapter {
    String[] resultado;
    Context contexto;
    private static LayoutInflater inflater= null;
    public GestionarAdapter2 (Context mainActivity, String[]progNombreLista) {
        resultado = progNombreLista;
        contexto = mainActivity;
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount(){
        return resultado.length;
    }
    @Override
    public  Object getItem(int posicion) {
        return posicion;
    }
    @Override
    public  long  getItemId(int posicion) {
        return posicion;
    }
    public class Holder
    {
        TextView tv;
    }
    @Override
    public View getView(final int posicion, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View fila;
        fila = inflater.inflate(R.layout.list_proyect, null);
        holder.tv=(TextView) fila.findViewById(R.id.textView);
        holder.tv.setText(resultado[posicion]);
        fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(contexto, "Seleccionaste "+resultado[posicion],
                        Toast.LENGTH_LONG).show();
            }
        });
        return fila;
    }
}