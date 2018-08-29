package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentClient;

public class MainClientActivity extends AppCompatActivity {

    public static ManagerFragmentClient states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
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

    public void changeFragment(ManagerFragmentClient state)
    {
        this.states = ManagerFragmentClient.setState(state);
        this.states.execute(this);
    }
}