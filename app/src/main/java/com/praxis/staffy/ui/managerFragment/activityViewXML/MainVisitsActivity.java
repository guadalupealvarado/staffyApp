package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentVisit;

public class MainVisitsActivity extends AppCompatActivity {


    public static ManagerFragmentVisit state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_visits);
        MyAplication.setContext(this);
        changeFragment(MainVisitsActivity.state);
    }

    public void changeFragment(ManagerFragmentVisit state)
    {
        this.state=ManagerFragmentVisit.setState(state);
        this.state.execute(this);
    }
}
