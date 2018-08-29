package com.praxis.staffy.ui.postulate.postulateRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.ui.postulate.PostulanteView;
import java.util.ArrayList;

public class AdapterViewPostulados  extends
        RecyclerView.Adapter<AdapterViewPostulados.ResourceViewHolder>{

    private ArrayList<InfoRecursoPurse> infoRecursoPurses;
    private int resourse;
    private PostulanteView activity;

    public AdapterViewPostulados(ArrayList<InfoRecursoPurse> infoRecursoPurses, int resourse, PostulanteView activity) {
        this.infoRecursoPurses = infoRecursoPurses;
        this.resourse = resourse;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ResourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);
        return  new ResourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceViewHolder holder, int position) {
        InfoRecursoPurse infoRecursoPurse=infoRecursoPurses.get(position);
        holder.tv_name_resource_card_view.setText(infoRecursoPurse.getNombre()+" "+infoRecursoPurse.getApPaterno());
        if(infoRecursoPurse.getRecursoPerfil()!=null)
        {
            if(infoRecursoPurse.getRecursoPerfil().get(0)!=null)
                holder.tv_profile_card_view.setText(infoRecursoPurse.getRecursoPerfil().get(0).getRango()+" "+infoRecursoPurse.getRecursoPerfil().get(0).getPerfil());
        }else
            holder.tv_profile_card_view.setText("consultor "+infoRecursoPurse.getId());

    }

    @Override
    public int getItemCount() {
        return infoRecursoPurses.size();
    }

    public class ResourceViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_name_resource_card_view;
        private TextView tv_profile_card_view;
        private TextView tv_state_card_view;

        public ResourceViewHolder(View itemView) {
            super(itemView);
            tv_name_resource_card_view=itemView.findViewById(R.id.tv_name_resource_card_view);
            tv_profile_card_view=itemView.findViewById(R.id.tv_profile_card_view);
            tv_state_card_view=itemView.findViewById(R.id.tv_state_card_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.goToViewResourcePostulant();
                }
            });
        }
    }
}