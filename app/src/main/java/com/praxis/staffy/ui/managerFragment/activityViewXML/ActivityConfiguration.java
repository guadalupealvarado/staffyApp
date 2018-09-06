package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentConfiguration;


public class ActivityConfiguration extends AppCompatActivity {

    public static ManagerFragmentConfiguration state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        //ToolbarConfiguration(true);
        MyAplication.setContext(this);
        if(state!=null){

            changeFragment(state);
        }else{


        }
    }


    public void changeFragment(ManagerFragmentConfiguration state)
    {
        this.state = ManagerFragmentConfiguration.setState(state);
        this.state.execute(this);
    }
}
