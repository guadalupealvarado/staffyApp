package com.praxis.staffy.ui.toAssign;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.perfil_requerido;


import java.util.ArrayList;

public class AdapterExpert extends RecyclerView.Adapter<AdapterExpert.ExpertViewHolder> {
    private ArrayList<perfil_requerido> perfilRequeridos;
    private int resource;
    private Activity activity;
    Spinner spinner;
    protected ArrayAdapter<CharSequence> adapter;

    public AdapterExpert(ArrayList<perfil_requerido> perfilRequeridos, int resource, Activity activity) {
        this.perfilRequeridos = perfilRequeridos;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ExpertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,
                false);

        spinner =(Spinner)view.findViewById(R.id.spinnertipo);
        adapter= ArrayAdapter.createFromResource(view.getContext(),R.array.perfil_s3tring,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return new ExpertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpertViewHolder holder, int position) {
        perfil_requerido perfil_requerido= perfilRequeridos.get(position);
        holder.name.setText(perfil_requerido.getProgrem());

    }

    @Override
    public int getItemCount() {
        return perfilRequeridos.size();
    }

    public class ExpertViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private Spinner spinner;
        private CheckBox check;
        public ExpertViewHolder(View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.name);
            spinner=itemView.findViewById(R.id.spinnertipo);
            check=itemView.findViewById(R.id.check);

        }
    }
}
