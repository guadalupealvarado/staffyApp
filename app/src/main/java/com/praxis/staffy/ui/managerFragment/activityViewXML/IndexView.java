package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentClient;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentConfiguration;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentConsultor;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentIndexE;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRetro;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentVisit;
import com.praxis.staffy.ui.proyect.ContainerProyect;
import com.praxis.staffy.ui.purse.showPurse.viewConsultPurse.ViewConsultPurseView;

import org.jetbrains.annotations.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexView extends AppCompatActivity {
    private ManagerFragmentIndexE state;
    private ManagerFragmentClient states;

    @Nullable
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Nullable
    @BindView(R.id.navigationView)
    BottomNavigationView btNVview;

    @Nullable
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
      //  Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_index_view);
        ButterKnife.bind(this, this);
        MyAplication.setContext(this);
        setUserNameNavigation();
        if(navigationView!=null)
        {
            setupDrawerContent(navigationView);
        }
        setToolbar("Notificaciones");
        changeFragment(ManagerFragmentIndexE.NOTIFICACION);
        setListenerNavigation();
    }

    private void setListenerNavigation() {
        btNVview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId()) {
                    case R.id.Notificationmt:
                        setToolbar("Notificaciones");
                        changeFragment(ManagerFragmentIndexE.NOTIFICACION);
                        break;
                    case R.id.ListActivity:
                        setToolbar("Actividades");
                        changeFragment(ManagerFragmentIndexE.ACTIVITIES);
                        break;
                    case R.id.Calendar:
                        setToolbar("Calendario");
                        changeFragment(ManagerFragmentIndexE.CALENDAR);
                        break;
                }
                return true;
            }
        });
    }

    public  void setUserNameNavigation()
    {
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usernameNavigation);
        TextView nameNav=headerView.findViewById(R.id.txt_email_navigation);
        navUsername.setText(UserDAO.getInstance().getUser(0).getCorreoElectronico());
        nameNav.setText(
                UserDAO.getInstance().getUser(0).getNombre()
                        +" "+ UserDAO.getInstance().getUser(0).getApPaterno()
                        +" "+ UserDAO.getInstance().getUser(0).getApMaterno());

        nameNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                btNVview.setVisibility(View.GONE);
                Intent cliente = new Intent(getApplicationContext(),
                        MainViewProfileActivity.class);
                startActivity(cliente);
            }
        });
    }

    public void changeFragment(ManagerFragmentIndexE state)
    {
        this.state = ManagerFragmentIndexE.setState(state);
        this.state.execute(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        drawerLayout.closeDrawers();
                        //String title = menuItem.getTitle().toString();
                        switch (menuItem.getItemId())
                        {
                            case R.id.nav_customers:
                                //cliente
                                //declaracion para poder crear el metodo
                                //changeFragment(ManagerFragmentIndexE.CLIENTS);
                                goClient(ManagerFragmentClient.CONSULTCLIENT);
                                break;

                            case R.id.nav_draft:
                                //Proyecto
                                goproyect();
                                break;

                            case R.id.nav_evaluators_praxis:
                                //evaluadores
                                consultores(ManagerFragmentConsultor.SHOWMAIN);
                                break;

                            case R.id.nav_purse:
                                //cartera

                                goPurse(ManagerFragmentPurse.SHOWPURSE);
                                break;

                            case R.id.retros:
                                //retros
                                goRetros(ManagerFragmentRetro.LISTRETRO);
                                break;

                            case R.id.nav_configuration:
                                //configuracion
                                goConfiguration(ManagerFragmentConfiguration.VIEWCONFIGURATION);
                                break;

                            case R.id.nav_log_out:
                                //cerrar sesion
                                signoff();
                                break;
                            case R.id.visitas:
                                //Visitas
                                goVisits(ManagerFragmentVisit.SEEVISIT);
                                break;


                        }
                        return true;
                    }
                }
        );
    }

    private void goRetros(ManagerFragmentRetro state) {
        ContainerRetro.states=state;
        Intent myIntent=new Intent(getApplicationContext(),ContainerRetro.class);
        startActivity(myIntent);
    }


    private void goClient(ManagerFragmentClient states) {
        MainClientActivity.states=states;
        Intent cliente = new Intent(getApplicationContext(),
                MainClientActivity.class);
        startActivity(cliente);
    }



    private void goConfiguration(ManagerFragmentConfiguration state) {
        ActivityConfiguration.state=state;
        Intent configuration = new Intent(getApplicationContext(),
                ActivityConfiguration.class);
        startActivity(configuration);
    }
    private void goVisits(ManagerFragmentVisit state) {//Recibo como parametro que es lo que quiero cargar en este caso SEEVISIT
        MainVisitsActivity.state=state;//Asigno que cargar
        Intent visitas = new Intent(getApplicationContext(),
                MainVisitsActivity.class);
        startActivity(visitas);
    }




    private void goPurse(ManagerFragmentPurse state) {
        MainActivityPurse.state= state;
        Intent purse = new Intent(getApplicationContext(), MainActivityPurse.class);
        startActivity(purse);
    }
    private void consultores(ManagerFragmentConsultor state) {
        MainConsultorActivity.state= state;
        Intent purse = new Intent(getApplicationContext(), MainConsultorActivity.class);
        startActivity(purse);
    }

    private void signoff()
    {
      /*  AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea cerrar la sesion")
                .setTitle("Advertencia")
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();*/

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea cerrar la sesion")
                .setTitle("Advertencia")
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void goproyect() {
        Intent proyectactivity = new Intent(getApplicationContext(),
                ContainerProyect.class);
        startActivity(proyectactivity);
    }

    private void  setToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_edit_proyect);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setTitle(title);
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_drawer_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
}
