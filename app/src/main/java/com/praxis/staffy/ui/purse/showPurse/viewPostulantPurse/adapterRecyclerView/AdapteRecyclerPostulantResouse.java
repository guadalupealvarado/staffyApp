package com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.adapterRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.ViewPostulanPurseView;

import java.util.ArrayList;

public class AdapteRecyclerPostulantResouse  extends
        RecyclerView.Adapter<AdapteRecyclerPostulantResouse.ResourceViewHolder> {
    private ArrayList<InfoRecursoPurse> infoRecursoPurses;
    private int resourse;
    private ViewPostulanPurseView activity;
    private int getID;

    public AdapteRecyclerPostulantResouse
            (ArrayList<InfoRecursoPurse> infoRecursoPurses, int resourse, ViewPostulanPurseView activity) {
        this.infoRecursoPurses = infoRecursoPurses;
        this.resourse = resourse;
        this.activity = activity;
    }

    private void gotDetailsResource(int id_posicion,int card_position)
    {
        activity.goDetilsResource(id_posicion,card_position);
    }


    @NonNull
    @Override
    public AdapteRecyclerPostulantResouse.ResourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);
        return  new AdapteRecyclerPostulantResouse.ResourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteRecyclerPostulantResouse.ResourceViewHolder holder, int position) {
        InfoRecursoPurse infoRecursoPurse=infoRecursoPurses.get(position);
        holder.txtViewNameResourse.setText(infoRecursoPurse.getNombre()+" "+infoRecursoPurse.getApPaterno());
        getID = infoRecursoPurses.get(position).getId();
        if(infoRecursoPurse.getRecursoPerfil()!=null)
        {
            if(infoRecursoPurse.getRecursoPerfil().get(0)!=null)
                holder.txtPerfilCardView.setText(infoRecursoPurse.getRecursoPerfil().get(0).getRango()+" "+infoRecursoPurse.getRecursoPerfil().get(0).getPerfil());
        }else
            holder.txtPerfilCardView.setText("consultor "+infoRecursoPurse.getId());
    }

    @Override
    public int getItemCount() {
        return infoRecursoPurses.size();
    }

    public class ResourceViewHolder extends RecyclerView.ViewHolder
    {

        private TextView txtViewNameResourse;
        private TextView txtPerfilCardView;
        private ImageView imgEditPurse;
        public ResourceViewHolder(View itemView)
        {
            super(itemView);
            txtViewNameResourse=itemView.findViewById(R.id.txtViewNameResourse);
            txtPerfilCardView=itemView.findViewById(R.id.txtPerfilCardView);
            imgEditPurse=itemView.findViewById(R.id.imgEditPurse);
            imgEditPurse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotDetailsResource(infoRecursoPurses.get(getAdapterPosition()).getId(),getAdapterPosition());
                }
            });
        }
    }
}
