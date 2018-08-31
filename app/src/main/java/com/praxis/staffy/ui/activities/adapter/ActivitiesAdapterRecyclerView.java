package com.praxis.staffy.ui.activities.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.ActivityP;
import com.praxis.staffy.model.pojo.Notification;
import com.praxis.staffy.ui.notification.adapter.NotificationAdapterRecyclerView;

import java.util.ArrayList;

public class ActivitiesAdapterRecyclerView extends RecyclerView.Adapter<ActivitiesAdapterRecyclerView.ActivitiesViewHolder> {

    private ArrayList<ActivityP> listActivities;
    private int resource;
    private Activity activity;

    public ActivitiesAdapterRecyclerView(ArrayList<ActivityP> listActivities, int resource, Activity activity){
        this.listActivities = listActivities;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ActivitiesAdapterRecyclerView.ActivitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        ActivityP activityP = listActivities.get(position);
        holder.textCardDescripcion.setText(activityP.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listActivities.size();
    }

    public class ActivitiesViewHolder extends RecyclerView.ViewHolder {
        private TextView textCardDescripcion;

        public ActivitiesViewHolder(View itemView) {

            super(itemView);
            textCardDescripcion = itemView.findViewById(R.id.textCardDescripcion);
        }
    }
}
