package com.praxis.staffy.ui.client.newClient.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Client;
import com.praxis.staffy.ui.client.consultClients.ConsultClienteView;

import java.util.ArrayList;

public class ClienteAdapterRecyclerView extends RecyclerView.Adapter<ClienteAdapterRecyclerView.ClienteViewHolder> {


    private ArrayList<Client>listCliente;
    private  int resource;
    private Activity activity;
    private ClienteAdapterRecyclerView adapter;

    private ConsultClienteView consultClienteView;
    public ClienteAdapterRecyclerView(ArrayList<Client> listCliente, int resource, Activity activity,ConsultClienteView consultClienteView) {
        this.listCliente = listCliente;
        this.resource = resource;
        this.activity = activity;
        this.consultClienteView = consultClienteView;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        Client cliente =listCliente.get(position);
        holder.textName.setText(cliente.getNombreCliente());
        holder.textContador.setText(String.valueOf(cliente.getIdCliente()));
    }

    @Override
    public int getItemCount() {
        return listCliente.size();
    }


    public void setFilter(ArrayList<Client> newList){
        listCliente= new ArrayList<>();
        listCliente.addAll(newList);
        notifyDataSetChanged();
    }

    public void setNumbrer(int number)
    { consultClienteView.goEditClient(number); }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textContador;
        public ClienteViewHolder(View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.txt_1_card_Retro);
            textContador=itemView.findViewById(R.id.tx_perfil_fracment_postulant);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                   // int pos = getAdapterPosition();
                    setNumbrer(Integer.parseInt(textContador.getText().toString()));
                }
            });
        }
    }
}
