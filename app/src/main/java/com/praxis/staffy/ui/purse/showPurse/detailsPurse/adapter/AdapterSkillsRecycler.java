package com.praxis.staffy.ui.purse.showPurse.detailsPurse.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.DetailsPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.ViewPostulanPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.adapterRecyclerView.AdapteRecyclerPostulantResouse;

import java.util.ArrayList;

import butterknife.BindView;

public class AdapterSkillsRecycler extends RecyclerView.Adapter<AdapterSkillsRecycler.SkillsViewHolder> {
    private ArrayList<InfoRecursoPurse> infoRecursoPurses;
    private int resourse;
    private DetailsPurseView activity;

    public AdapterSkillsRecycler(ArrayList<InfoRecursoPurse> infoRecursoPurses, int resourse, DetailsPurseView activity) {
        this.infoRecursoPurses = infoRecursoPurses;
        this.resourse = resourse;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterSkillsRecycler.SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);
        return  new AdapterSkillsRecycler.SkillsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSkillsRecycler.SkillsViewHolder holder, int position) {
        InfoRecursoPurse infoRecursoPurse=infoRecursoPurses.get(position);
        //holder.btn_Skills.setText(infoRecursoPurse.getRecursoPerfil().get().getIdPerfil().toString());
    }

    @Override
    public int getItemCount() {
        return infoRecursoPurses.size();
    }

    public class SkillsViewHolder extends RecyclerView.ViewHolder {
        private Button btn_Skills;
        public SkillsViewHolder(View itemView) {
            super(itemView);
            btn_Skills = itemView.findViewById(R.id.btn_Skills);
        }
    }
}
