package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRetro;

/**
 * Created by b.najera on 16/08/2018.
 */

public class ContainerRetro extends AppCompatActivity {

    public static ManagerFragmentRetro states;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_retro);

        MyAplication.setContext(this);

        if(states!=null)
        {
            changeFragment(states);
        }
        else
        {
            //Default fragment
        }

    }

    public void changeFragment(ManagerFragmentRetro states)
    {
        this.states = ManagerFragmentRetro.setState(states);
        this.states.execute(this);
    }
}