package com.praxis.staffy.ui.proyect.viewProyect.viewProyecyRecycletView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentProyect;
import com.praxis.staffy.ui.proyect.ContainerProyect;

import java.util.ArrayList;

import static com.praxis.staffy.ui.MyAplication.getContext;

public class GestionarAdapter extends BaseAdapter {

    public static String ID_PROYECT_SELECTED;
    final CharSequence[] items = {"Consultar  información", "Modificar  información "};
    public static ManagerFragmentProyect states;


    ArrayList<String> resultado;
    Context contexto;
    private static LayoutInflater inflater = null;

    public GestionarAdapter(ContainerProyect mainActivity, ArrayList<String> progNombreLista) {
        resultado = progNombreLista;
        contexto = mainActivity;
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return resultado.size();
    }

    @Override
    public Object getItem(int posicion) {
        return posicion;
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    public class Holder {
        TextView tv;
    }


    @Override
    public View getView(final int posicion, final View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View fila;
        fila = inflater.inflate(R.layout.lista_proyectos, null);
        holder.tv = (TextView) fila.findViewById(R.id.textView);
        final String nb=resultado.get(posicion);
        holder.tv.setText(nb);
        fila.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openInfoProyect(nb);
            }
        });
        return fila;
    }

    private void openInfoProyect(String nameproyect) {
        Bundle bundle=new Bundle();
        bundle.putString(GestionarAdapter.ID_PROYECT_SELECTED,nameproyect);
        changeFragment(ManagerFragmentProyect.INFOPROYECT.setBundle(bundle));
    }

    private void changeFragment(ManagerFragmentProyect states) {
        this.states = ManagerFragmentProyect.setState(states);
        this.states.execute((ContainerProyect) getContext());
    }

}

