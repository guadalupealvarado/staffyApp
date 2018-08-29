package com.praxis.staffy.ui.client.newClient.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Address;

import java.util.ArrayList;

public class AdapterNewClients extends RecyclerView.Adapter<AdapterNewClients
        .Adapter_new_clientsViewHolder>{
    private ArrayList<Address> listDirection;
    private AdapterNewClients adapter;
    private int resourse;

    public AdapterNewClients(ArrayList<Address> listDirection,
                             int resourse, FragmentActivity activity)
    {
        this.listDirection=listDirection;
        this.resourse=resourse;
    }


    @NonNull
    @Override
    public Adapter_new_clientsViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se realiza la inflacion del recicler
        View view= LayoutInflater.from(parent.getContext())
                .inflate(resourse,parent,false);

        return new Adapter_new_clientsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_new_clientsViewHolder holder,
                                 int position) {

        Address clienteAddress =listDirection.get(position);

//aca se ya ma los holeder para mstrar los datos de una forma mas ordenada.
        holder.txtcalle.setText(clienteAddress.getCalle());



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Adapter_new_clientsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnumberDirection;
        private TextView txtcalle;
        private EditText txcalle;
        private TextView txtnumero;
        private EditText txnumero;
        private TextView txtcolonia;
        private EditText txcolonia;
        private TextView txtcp;
        private EditText txcp;
        private TextView txtdelegacionmunicipio;
        private EditText txdelegacionmunicipio;
        private TextView txtestado;
        private EditText txestado;
        private TextView txtreferencia;
        private EditText txreferencia;



        public Adapter_new_clientsViewHolder(View itemView) {
            super(itemView);

            txtnumberDirection=itemView.findViewById(R.id.txtnumberDirection);
            txtcalle=itemView.findViewById(R.id.txtcalle);
            txnumero=itemView.findViewById(R.id.txnumero);
            txcolonia=itemView.findViewById(R.id.txcolonia);
            txcp=itemView.findViewById(R.id.txcp);
            txdelegacionmunicipio=itemView.findViewById(R.id.txdelegacionmunicipio);
            txestado=itemView.findViewById(R.id.txestado);
            txreferencia=itemView.findViewById(R.id.txreferencia);



        }
    }
}
