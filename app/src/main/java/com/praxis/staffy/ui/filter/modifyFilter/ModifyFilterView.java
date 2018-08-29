package com.praxis.staffy.ui.filter.modifyFilter;

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
import android.widget.Toast;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;

import butterknife.BindView;

public class ModifyFilterView extends BaseView {
    @Nullable
    @BindView(R.id.tool_modifyfilter)
    Toolbar toolbar_modify_filter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.
                        fragment_modify_filter, container,
                false);
        showToolbar(rootView);
        setHasOptionsMenu(true);
        return rootView;
    }
    public void showToolbar( View view)
    {
        Toolbar toolbar = view.findViewById(R.id.tool_modifyfilter);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Modificar filtro");
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
            inflater.inflate(R.menu.toolbart_modify_filter,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_delete:
                Toast.makeText(getContext(), "se elemino", Toast.LENGTH_SHORT)
                        .show();
                // Not implemented here
                return false;

        }

        return super.onOptionsItemSelected(item);
    }

}
