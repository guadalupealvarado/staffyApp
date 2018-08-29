package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;

public class MainActivityPurse extends AppCompatActivity {

    public static ManagerFragmentPurse state;
    //public static String nameToolBar="Cartera";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartera);
        MyAplication.setContext(this);
        if(state!=null)
        {
            changeFragment(state);
        }
      // changeFragment(ManagerFragmentPurse.SHOWDETAILSPURSE);
      //  ToolbarPurse(true,nameToolBar);
    }

   /* @SuppressLint("RestrictedApi")
    public void ToolbarPurse(Boolean upButton,String name_toolbar) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_purse);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(name_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }*/

    public  void changeFragment(ManagerFragmentPurse state)
    {
        this.state=ManagerFragmentPurse.setState(state);
        this.state.execute(this);
    }
}
