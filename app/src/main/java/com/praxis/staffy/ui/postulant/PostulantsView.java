package com.praxis.staffy.ui.postulant;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.postulacion;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.postulant.postulantsReclyclerView.AdapterViewPostular;
import com.praxis.staffy.utils.CheckMailFormat;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostulantsView extends BaseView {

    @Nullable
    @BindView(R.id.id_recyclerview_fracmentlistpostulant)
    RecyclerView id_recyclerview_fracmentlistpostul;

    @Nullable
    @BindView(R.id.et_send_mail_to_postulant)
    protected TextView et_send_mail_to_postulant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_contenedor_listpostulant, container, false);
        ButterKnife.bind(this,rootView);
        setHasOptionsMenu(true);
        showMsj("Cargando...");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        id_recyclerview_fracmentlistpostul.setLayoutManager(linearLayoutManager);
        AdapterViewPostular postulant =  new AdapterViewPostular(arraypostulant(),
                R.layout.card_view_postulant, getActivity());
        id_recyclerview_fracmentlistpostul.setAdapter(postulant);
        showToolbar(rootView);
        return rootView;
    }

    // es un estrin para llenar el cardview
    private ArrayList<postulacion> arraypostulant(){
        ArrayList<postulacion> retrolistpostulant = new ArrayList<>();
        retrolistpostulant.add(new postulacion("Miguel Betancurt Cravioto","1","2","3"));
        retrolistpostulant.add(new postulacion("Miguel Betancurt Cravioto", "1", "2", "Senior en java, php"));
        retrolistpostulant.add(new postulacion("Miguel Betancurt Cravioto", "1", "2", "En filtro"));
        retrolistpostulant.add(new postulacion("Miguel Betancurt Cravioto", "1", "2", "01"));
        return retrolistpostulant;
    }

    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_listpostulant);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Postular");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }


    //icono superior de busqueda para la pantalla postular

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.toolbart_client, menu);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_ico:
                // Not implemented here
                return false;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_send_list_postulant)
    public void sendMail()
    {
       if(CheckMailFormat.checkMailFormat(et_send_mail_to_postulant.getText().toString()))
       {
           showMsj("bien");
       }else
       {
           showMsj("el formato del correo no es correto.");
       }
    }

    public  void showMsj(String msj)
    {
        showToastMsj(msj);
    }
}