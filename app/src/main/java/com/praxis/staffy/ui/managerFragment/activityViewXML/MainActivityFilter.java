package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentFilter;

public class MainActivityFilter extends AppCompatActivity {

    public static ManagerFragmentFilter state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_filter);
        MyAplication.setContext(this);
        changeFragment(MainActivityFilter.state);
    }
    public void changeFragment(ManagerFragmentFilter state)
    {
        this.state=ManagerFragmentFilter.setState(state);
        this.state.execute(this);
    }
}
