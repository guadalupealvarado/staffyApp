package com.praxis.staffy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivity;



public class Splash_staffy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_staffy);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent=new Intent(Splash_staffy.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },500);
    }
}



