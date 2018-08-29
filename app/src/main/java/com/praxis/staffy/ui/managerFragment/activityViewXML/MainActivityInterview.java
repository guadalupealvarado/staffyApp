package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentInterview;

public class MainActivityInterview extends AppCompatActivity {

    public static ManagerFragmentInterview state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interview);
        MyAplication.setContext(this);
        changeFragment(MainActivityInterview.state);
    }
    public void changeFragment(ManagerFragmentInterview state)
    {
        this.state=ManagerFragmentInterview.setState(state);
        this.state.execute(this);
    }
}
