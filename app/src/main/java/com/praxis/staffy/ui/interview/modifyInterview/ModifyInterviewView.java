package com.praxis.staffy.ui.interview.modifyInterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import butterknife.BindView;

public class ModifyInterviewView extends BaseView {

    @Nullable
    @BindView(R.id.ed_datefilter_fragment_modify_interview)
    EditText edt_datefilter_fragment_modifyInterview;
    @Nullable
    @BindView(R.id.ed_hourfilter_fragment_modify_interview)
    EditText edt_hour_fragment_modify;
    @Nullable
    @BindView(R.id.ed_sendemail_fragment_modify_interview)
    EditText ed_sendemail_fragment_modifyinterview;

    @Nullable
    @BindView(R.id.modifyInterview)
    Toolbar tool_modifyInterview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.
                        fragment_modify_interview, container,
                false);

        shoTool(rootView);
        setHasOptionsMenu(true);
        return rootView;

    }

    private void shoTool( View view) {
        Toolbar toolbar= view.findViewById(R.id.modifyInterview);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Modificar entrevista");
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
        inflater.inflate(R.menu.toolbart_modify_interview,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(getContext(), "se elemino", Toast.LENGTH_SHORT)
                        .show();
                // Not implemented here
                return false;

        }

        return super.onOptionsItemSelected(item);
    }

}
