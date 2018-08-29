package com.praxis.staffy.ui.notification.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.notification.NotificationDAO;
import com.praxis.staffy.model.pojo.Notification;

import java.util.ArrayList;

public class NotificationAdapterRecyclerView extends
        RecyclerView.Adapter<NotificationAdapterRecyclerView.NotificationViewHolder> {

    private ArrayList<Notification> listNotification;
    private  int resource;
    private Activity activity;

    public NotificationAdapterRecyclerView(ArrayList<Notification> listNotification, int resource, Activity activity) {
        this.listNotification = listNotification;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        Notification notification=listNotification.get(position);
        holder.textCardName.setText(""+notification.getNombre());
        holder.textCardDescripcion.setText(notification.getDescripcion());
        holder.textTimeCardNotification.setText(notification.getFh().substring(0,10));

    }

    @Override
    public int getItemCount() {
        return listNotification.size();
    }

    int number;


    public  class NotificationViewHolder extends RecyclerView.ViewHolder{
        //private ImageView picture;
        private TextView textCardName;
        private TextView textTimeCardNotification;
        private TextView textCardDescripcion;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            //picture=itemView.findViewById(R.id.imageViewCard);
            textCardName=itemView.findViewById(R.id.textCardName);
            textTimeCardNotification=itemView.findViewById(R.id.textTimeCardNotification);
            textCardDescripcion=itemView.findViewById(R.id.textCardDescripcion);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                    number=getAdapterPosition();
                    int pos = getAdapterPosition();
                }
            });
        }
    }
}
