package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentViewUser;

public class MainViewProfileActivity extends AppCompatActivity {

    private ManagerFragmentViewUser state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_profile);
        MyAplication.setContext(this);
        changeFragment(ManagerFragmentViewUser.SEEALLUSER);
    }

    public void changeFragment(ManagerFragmentViewUser state)
    {
        this.state = ManagerFragmentViewUser.setState(state);
        this.state.execute(this);
    }

}
