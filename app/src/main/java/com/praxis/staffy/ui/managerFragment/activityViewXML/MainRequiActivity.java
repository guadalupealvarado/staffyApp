package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequi;

public class MainRequiActivity extends AppCompatActivity {

    public static ManagerFragmentRequi state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_requi);
        MyAplication.setContext(this);
        if(state!=null){

            changeFragment(state);
        }
    }


    public void changeFragment(ManagerFragmentRequi managerFragmentRequi)
    {
        this.state=ManagerFragmentRequi.setState(managerFragmentRequi);
        this.state.excute(this);
    }
}
