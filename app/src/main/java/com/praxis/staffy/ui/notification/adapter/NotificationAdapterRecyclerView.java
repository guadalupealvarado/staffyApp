package com.praxis.staffy.ui.notification.adapter;

import android.app.Activity;
import android.content.Intent;
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
import com.praxis.staffy.utils.TimeLapsedNotification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NotificationAdapterRecyclerView extends
        RecyclerView.Adapter<NotificationAdapterRecyclerView.NotificationViewHolder> {

    private ArrayList<Notification> listNotification;
    private int resource;
    private Activity activity;

    public NotificationAdapterRecyclerView(ArrayList<Notification> listNotification, int resource, Activity activity) {
        this.listNotification = listNotification;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        Notification notification = listNotification.get(position);
        holder.textCardName.setText(" " + notification.getNombre());
        holder.textCardDescripcion.setText(notification.getDescripcion());

        //Se crea una instancia de la clase TimeLapsedNotification para obtener el tiempo de cada notificacion
        TimeLapsedNotification timeLapsedNotification = new TimeLapsedNotification();
        String notificationDate = notification.getFh().substring(0, 10) + " " + notification.getFh().substring(11, 16);
        try {
            holder.textTimeCardNotification.setText(timeLapsedNotification.getNotificationDate(notificationDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //notification.getFh().substring(11,19)
        //

    }

    @Override
    public int getItemCount() {
        return listNotification.size();
    }

    int number;


    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        //private ImageView picture;
        private TextView textCardName;
        private TextView textTimeCardNotification;
        private TextView textCardDescripcion;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            //picture=itemView.findViewById(R.id.imageViewCard);
            textCardName = itemView.findViewById(R.id.textCardName);
            textTimeCardNotification = itemView.findViewById(R.id.textTimeCardNotification);
            textCardDescripcion = itemView.findViewById(R.id.textCardDescripcion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    number = getAdapterPosition();
                    int pos = getAdapterPosition();
                }
            });
        }
    }

    //Metodo encargado de calcular el tiempo transcurrido en las notifcaciones

}//Fin class NotificationAdapterRecyclerView
