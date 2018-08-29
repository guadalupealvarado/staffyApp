package com.praxis.staffy.ui.proyect.detailsProyect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.Proyect.ProyectDAO;
import com.praxis.staffy.model.pojo.Project;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainRequiActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentProyect;
import com.praxis.staffy.ui.proyect.ContainerProyect;
import com.praxis.staffy.ui.proyect.viewProyect.viewProyecyRecycletView.GestionarAdapter;
import com.praxis.staffy.utils.MonthConverterToString;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsProyectView extends BaseView {
    public static ManagerFragmentProyect states;

    @BindView(R.id.idtxtDetailsNameClient)
    TextView idtxtDetailsNameClient;

    @BindView(R.id.tv_year_init_info_proyect)
    TextView tv_year_init_info_proyect;

    @BindView(R.id.tv_year_end_info_proyect)
    TextView tv_year_end_info_proyect;

    @BindView(R.id.tv_mouth_init_proyect_info)
    TextView tv_mouth_init_proyect_info;

    @BindView(R.id.tv_day_init_proyect_info)
    TextView tv_day_init_proyect_info;

    @BindView(R.id.tv_day_end_proyect_info)
    TextView tv_day_end_proyect_info;

    @BindView(R.id.tv_mouth_end_proyect_info)
    TextView tv_mouth_end_proyect_info;

    @BindView(R.id.tv_observaciones_info_proyect)
    TextView tv_observaciones_info_proyect;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_info__proyect, container, false);
        showToolbar(rootView);
        ButterKnife.bind(this,rootView);
        Bundle bundle=getArguments();


        idtxtDetailsNameClient.setText(bundle.getString(GestionarAdapter.ID_PROYECT_SELECTED));
        Project project=ProyectDAO.getInstance().getProyect(bundle.getString(GestionarAdapter.ID_PROYECT_SELECTED));
        tv_year_init_info_proyect.setText(project.getFhInicio().substring(0,4));
        Log.e("init",project.getFhInicio());
        Log.e("end",project.getFhFin());
        tv_year_end_info_proyect.setText(project.getFhFin().substring(0,4));

        tv_mouth_init_proyect_info.setText(MonthConverterToString.getInstance().getMonth(Integer.valueOf(project.getFhInicio().substring(5,7))));
        tv_day_init_proyect_info.setText(project.getFhInicio().substring(8,10));

        tv_day_end_proyect_info.setText(project.getFhFin().substring(8,10));
        tv_mouth_end_proyect_info.setText(MonthConverterToString.getInstance().getMonth(Integer.valueOf(project.getFhFin().substring(5,7))));

        tv_observaciones_info_proyect.setText(project.getDescripcion());

        setHasOptionsMenu(true);
        Button show_requi =  rootView.findViewById(R.id.show_requi);
        show_requi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goShowRequi();
            }
        });
        backButton();
        return rootView;
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
            actionBar.setTitle(getString(R.string.detail_proyect));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    main();
                }
            });
        }

    }

    private void changeFragment(ManagerFragmentProyect states) {
        this.states = ManagerFragmentProyect.setState(states);
        this.states.execute((ContainerProyect) getContext());
    }

    private void main() {
        changeFragment(ManagerFragmentProyect.MAINPROYECT);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.toolbar_proyect,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_proyect:
                editProyect();
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    private void editProyect()
    {
        changeFragment(ManagerFragmentProyect.EDITPORYECT);

    }

    private void goShowRequi()
    {
        Intent proyectactivity = new Intent(getContext(),
                MainRequiActivity.class);
        startActivity(proyectactivity);
    }

}
