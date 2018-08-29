package com.praxis.staffy.ui.toolbar;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.praxis.staffy.R;

public class ShowToolbar {
    private ShowToolbar() {
    }

    private static ShowToolbar instance;

    public static ShowToolbar getInstance() {
        if(instance==null)
        {
            instance=new ShowToolbar();
        }
        return instance;
    }

    public void showToolbar(final Activity activity, Toolbar toolbar, String title)
    {
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        final ActionBar actionBar=((AppCompatActivity) activity).getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setTitle(title);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }
}
