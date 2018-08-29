package com.praxis.staffy.ui.managerFragment.activityViewXML;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragment;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.R;

public class MainActivity extends AppCompatActivity {
    private ManagerFragment state;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        MyAplication.setContext(this);
    /*    if(UserDAO.getInstance().getList().size()==0)
        {*/
            changeFragment(ManagerFragment.LOGIN);
        /*}else
        {
            Intent intent=new Intent(this, IndexView.class);
            startActivity(intent);
        }*/
    }

        public void changeFragment(ManagerFragment state)
        {
            this.state = ManagerFragment.setState(state);
            this.state.execute(this);
        }

}
