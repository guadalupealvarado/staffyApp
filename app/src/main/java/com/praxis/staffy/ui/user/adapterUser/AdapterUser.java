package com.praxis.staffy.ui.user.adapterUser;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.User;

import java.util.ArrayList;

/**
 * Created by b.najera on 16/08/2018.
 */
public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ResourceViewHolder>
{
    private ArrayList<User> user;
    private int resourse;
    private Activity activity;

    public AdapterUser(ArrayList<User> user,
                        int resourse, Activity activity) {
        this.user = user;
        this.resourse = resourse;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterUser.ResourceViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //se realiza la inflasion del recyclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);
        return new AdapterUser.ResourceViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull AdapterUser
            .ResourceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ResourceViewHolder extends RecyclerView.ViewHolder {
        private TextView  tx_nombre_fracment_user;
        private TextView  tx_text_fracment_user;




        public ResourceViewHolder(View itemView) {
            super(itemView);

            tx_nombre_fracment_user=itemView.findViewById(R.id.tx_nombre_fracment_user);
            tx_text_fracment_user=itemView.findViewById(R.id.tx_text_fracment_user);



        }
    }
}
