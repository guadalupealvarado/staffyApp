package com.praxis.staffy.ui.postulant.postulantsReclyclerView;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.postulacion;

import java.util.ArrayList;

public class AdapterViewPostular extends RecyclerView.Adapter<AdapterViewPostular.ResourceViewHolder>{

    private ArrayList<postulacion> postulant;
    private int resourse;
    private Activity activity;

    public AdapterViewPostular(ArrayList<postulacion> arraypostulant,
                               int resourse, Activity activity) {
            this.activity=activity;
            this.resourse=resourse;
            this.postulant=postulant;

    }


    @NonNull
    @Override
    public AdapterViewPostular.ResourceViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(resourse,parent,false);
        return new ResourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewPostular
            .ResourceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7 ;
    }


    public class ResourceViewHolder extends RecyclerView.ViewHolder
    {

    private TextView tx_nombre_fracment_postulant;
    private Switch  switch_fracment_postulant;
    private TextView tx_perfil_fracment_postulant;
    private TextView tx_estatus_fracment_postulant;
    private ProgressBar horizontal_progress_bar_fracment_postulant;


        public ResourceViewHolder(View itemView) {
            super(itemView);

            tx_nombre_fracment_postulant=itemView.findViewById(R.id.tx_nombre_fracment_postulant);
            switch_fracment_postulant=itemView.findViewById(R.id.switch_fracment_postulant);
            tx_perfil_fracment_postulant=itemView.findViewById(R.id.tx_perfil_fracment_postulant);
            tx_estatus_fracment_postulant=itemView.findViewById(R.id.tx_estatus_fracment_postulant);
            horizontal_progress_bar_fracment_postulant=itemView.findViewById(R.id.horizontal_progress_bar_fracment_postulant);


        }
    }
}
