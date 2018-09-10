package com.praxis.staffy.ui.requests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;

public class ContainerRequest extends AppCompatActivity {
    public static ManagerFragmentRequest states;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_request);
        MyAplication.setContext(this);
        if(states!=null){

            changeFragment(states);
        }else{


        }

    }

    private void changeFragment(ManagerFragmentRequest states) {
        this.states = ManagerFragmentRequest.setState(states);
        this.states.execute(this);
    }
}
