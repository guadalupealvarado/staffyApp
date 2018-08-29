package com.praxis.staffy.ui.retro.adapterRetro;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.praxis.staffy.R;

import com.praxis.staffy.model.pojo.retro;

import java.util.ArrayList;

/**
 * Created by b.najera on 15/08/2018.
 */

public class AdapterRetro extends
        RecyclerView.Adapter<AdapterRetro.ResourceViewHolder>
{
private ArrayList<retro> retros;
private int resourse;
private Activity activity;

    public AdapterRetro(ArrayList<retro> retros,
                        int resourse, Activity activity) {
        this.retros = retros;
        this.resourse = resourse;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterRetro.ResourceViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    //se realiza la inflasion del recyclerview
        View view= LayoutInflater.from(parent.getContext())
                .inflate(resourse,parent,false);
      return new ResourceViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull AdapterRetro
            .ResourceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return retros.size();
    }

    public class ResourceViewHolder extends RecyclerView.ViewHolder {
        private TextView  txt_1_card_Retro;
        private TextView  txt_2_card_Retro;
        private TextView  txt_3_card_Retro;
        private TextView  txt_4_card_Retro;
        private TextView  txt_5_card_Retro;
        private TextView  txt_6_card_Retro;



        public ResourceViewHolder(View itemView) {
            super(itemView);

           txt_1_card_Retro=itemView.findViewById(R.id.txt_1_card_Retro);
           txt_2_card_Retro=itemView.findViewById(R.id.txt_2_card_Retro);
           txt_3_card_Retro=itemView.findViewById(R.id.txt_3_card_Retro);
           txt_4_card_Retro=itemView.findViewById(R.id.txt_4_card_Retro);
           txt_5_card_Retro=itemView.findViewById(R.id.txt_5_card_Retro);



        }
    }
}
