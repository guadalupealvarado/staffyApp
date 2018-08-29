package com.praxis.staffy.ui.requests.format.newFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;
import com.praxis.staffy.ui.requests.ContainerRequest;


public class NewFormatView extends BaseView {
    public static ManagerFragmentRequest states;
    EditText txt_start_date_format, txt_finish_date_format, txt_mail_format;
    Button addProyect;

    public NewFormatView()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_format, container, false);
        txt_start_date_format = rootView.findViewById(R.id.txt_start_date_format);
        txt_finish_date_format = rootView.findViewById(R.id.txt_finish_date_format);
        txt_mail_format = rootView.findViewById(R.id.txt_mail_format);



        showToolbar(rootView);
        backButton();
        newProyect();

        return  rootView;
    }

    private void newProyect()
    {
        addProyect = rootView.findViewById(R.id.btn_submit_request_edit);
        addProyect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewFormat();

            }
        });
    }

    private void NewFormat()
    {
        if (txt_start_date_format.getText().length()==0){
            txt_start_date_format.setError(getString(R.string.fill));
        }
        else if (txt_finish_date_format.getText().length()==0){
            txt_finish_date_format.setError(getString(R.string.fill));
        }

        else if(txt_mail_format.getText().length()==0){
            txt_mail_format.setError(getString(R.string.fill));

        }
        else {
            saveFormat();
        }

    }

    private void saveFormat()
    {
        changeFragment(ManagerFragmentRequest.VIEWREQUEST);

    }

    private void backButton()
    {
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                return false;
            }
        });
    }

    private void changeFragment(ManagerFragmentRequest states){
        this.states=ManagerFragmentRequest.setState(states);
        this.states.execute((ContainerRequest) getContext());
    }

    private void showToolbar(View view)
    {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.addFormat));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    main();
                }
            });
        }

    }

    private void main()
    {
        changeFragment(ManagerFragmentRequest.VIEWREQUEST);
    }
}
