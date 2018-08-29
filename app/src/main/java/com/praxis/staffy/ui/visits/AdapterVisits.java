package com.praxis.staffy.ui.visits;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Visits;


import java.util.ArrayList;

public class AdapterVisits extends RecyclerView.Adapter<AdapterVisits.VisitsViewHolder>{
    private ArrayList<Visits> lisvisits;
    private int resource;
    private Activity activity;

    public AdapterVisits(ArrayList<Visits> lisvisits, int resource, Activity activity) {
        this.lisvisits = lisvisits;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VisitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,
                false);

        return new VisitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitsViewHolder holder, int position) {
        Visits visits= lisvisits.get(position);
        holder.txtNameVisits.setText(visits.getName());
        holder.txtDate.setText(visits.getDate());
    }

    @Override
    public int getItemCount() {
        return lisvisits.size();
    }

    public class VisitsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameVisits;
        private TextView txtDateVisits;
        private TextView txtDate;

        public VisitsViewHolder(View itemView) {
            super(itemView);

            txtNameVisits=itemView.findViewById(R.id.txtNameVisits);
            txtDateVisits=itemView.findViewById(R.id.txtFechaVisits);
            txtDate=itemView.findViewById(R.id.txtDate);
        }
    }
}
