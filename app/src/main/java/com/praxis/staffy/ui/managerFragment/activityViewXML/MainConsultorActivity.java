package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentConsultor;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;

public class MainConsultorActivity extends AppCompatActivity {
    public static ManagerFragmentConsultor state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_consultor);
        MyAplication.setContext(this);
        if(state!=null)
        {
            changeFragment(state);
        }
    }
    public  void changeFragment(ManagerFragmentConsultor state)
    {
        this.state=ManagerFragmentConsultor.setState(state);
        this.state.execute(this);
    }
}
