package com.praxis.staffy.ui.interview.showInterviewView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityInterview;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentInterview;

import butterknife.BindView;

public class ShowInterviewView extends BaseView{

    @BindView(R.id.shoToolInterview)
    Toolbar toolbar_show_interview;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.
                        fragment_show_entrevi, container,
                false);
        showToolbar(rootView);
        setHasOptionsMenu(true);
        return rootView;
    }
    public void showToolbar( View view)
    {
        Toolbar toolbar= view.findViewById(R.id.shoToolInterview);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Ver entrevista");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.toolbart_show_interview,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.interview:
                ((MainActivityInterview) getActivity()).changeFragment(ManagerFragmentInterview.MODIFYINTERVIEW);
                return false;

        }

        return super.onOptionsItemSelected(item);
    }
    
}
