package com.praxis.staffy.ui.proyect.viewProyect;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.proyect.ContainerProyect;
import com.praxis.staffy.ui.proyect.viewProyect.viewProyecyRecycletView.GestionarAdapter;
import java.util.ArrayList;


public class ViewListProyect extends BaseView implements MVPViewProyect.ViewAllProyect
{
    private ViewProyectPresenter viewProyectPresenter;

    ListView lista;

    private static ArrayList<String> por_iniciar=new ArrayList<>();
    private static ArrayList<String> iniciados=new ArrayList<>();
    private static ArrayList<String> finalizados=new ArrayList<>();


    private void resetList()
    {
        por_iniciar=new ArrayList<>();
        iniciados=new ArrayList<>();
        finalizados=new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView= inflater.inflate(R.layout.fragment_activity_proyect, container, false);
        viewProyectPresenter=new ViewProyectPresenter(this);
        viewProyectPresenter.onCreate();
        resetList();

        viewProyectPresenter.consultAllProyecy();
        showToolbar(rootView);
        MyAplication.setContext(activity);
        return rootView;

    }

    @Override
    public void listProyect()
    {
        /**Se busca la lista que correponda*/
        lista=(ListView) rootView.findViewById(R.id.por_iniciar);
        lista.setAdapter(new GestionarAdapter((ContainerProyect) activity, por_iniciar));

        lista=(ListView) rootView.findViewById(R.id.iniciados);
        lista.setAdapter(new GestionarAdapter((ContainerProyect) activity, iniciados));

        lista=(ListView) rootView.findViewById(R.id.finalizados);
        lista.setAdapter(new GestionarAdapter((ContainerProyect) activity, finalizados));
        backButton();

    }

    private void backButton()
    {
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                return false;
            }
        });
    }

    private void showToolbar(View view)
    {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_proyect));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }

  /*  public void getAllProject()
    {
        Call<ListAllProject> response=appiAllProject.servicesSelectAllProject.getAllProject();
        response.enqueue(new Callback<ListAllProject>() {
            @Override
            public void onResponse(Call<ListAllProject> call, Response<ListAllProject> response) {
                if(!response.isSuccessful())
                {
                    String error = "";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json"))
                    {
                    }
                    else {
                        error = response.message();
                    }
                    return;
                }else
                {
                    ListAllProject listAllProject=response.body();
                    for(int a=0;a<listAllProject.getProjectArrayList().size()
                            ;a++)
                    {
                        if(listAllProject.getProjectArrayList()
                                .get(a).getEstatusProyecto().equalsIgnoreCase("Por iniciar"))
                        {
                            addPorIniciar(listAllProject.getProjectArrayList().get(a).getNbProyecto());
                        }else if(listAllProject.getProjectArrayList()
                                .get(a).getEstatusProyecto().equalsIgnoreCase("Iniciado"))
                        {
                            addIniciado(listAllProject.getProjectArrayList().get(a).getNbProyecto());
                        }else if(listAllProject.getProjectArrayList()
                                .get(a).getEstatusProyecto().equalsIgnoreCase("Finalizado"))
                        {
                            addFinalizado(listAllProject.getProjectArrayList().get(a).getNbProyecto());
                        }else
                        {
                            showMessage("No pertenece a ninguna sección.");
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ListAllProject> call, Throwable t) {
            }
        });
    }

*/

    @Override
    public void showLoading() {
        showMessage("Cargando...");
    }

    @Override
    public void hiddenLoading() {
    }

    @Override
    public void showMessage(String msj) {
        showToastMsj(msj);
    }

    @Override
    public void addPorIniciar(String iniciar) {
        ViewListProyect.por_iniciar.add(iniciar);
    }

    @Override
    public void addIniciado(String iniciado) {
        ViewListProyect.iniciados.add(iniciado);
    }

    @Override
    public void addFinalizado(String finalizado) {
        ViewListProyect.finalizados.add(finalizado);
    }

    @Override
    public void onDestroy() {
        viewProyectPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        viewProyectPresenter.onDestroy();
        super.onDestroyView();
    }
}
