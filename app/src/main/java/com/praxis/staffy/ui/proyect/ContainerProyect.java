package com.praxis.staffy.ui.proyect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentProyect;

public class ContainerProyect extends AppCompatActivity  {

    public static ManagerFragmentProyect states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyect);
        changeFragment(ManagerFragmentProyect.MAINPROYECT);
        }

    public void changeFragment(ManagerFragmentProyect states) {
        this.states = ManagerFragmentProyect.setState(states);
        this.states.execute(this);
    }

}

