package com.praxis.staffy.ui.purse.showPurse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.DetailsPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewConsultPurse.ViewConsultPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.ViewPostulanPurseView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowPurseView extends BaseView {
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.navigationViewPurse)
    BottomNavigationView btNVview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_show_purse, container, false);
        ButterKnife.bind(this, rootView);
        changeFragment(ViewPostulanPurseView.class);
        showToolbar();
        setListenerNavigation();
        return rootView;
    }

    public void goDetilsResource(int id_position) {
        Bundle bundle = new Bundle();
        bundle.putInt(DetailsPurseView.POSICIONRESOURCE, id_position);
        MainActivityPurse.state = ManagerFragmentPurse.SHOWDETAILSPURSE.setBundle(bundle);
        Intent intent = new Intent(rootView.getContext(), MainActivityPurse.class);
        startActivity(intent);
    }

    public void showToolbar()
    {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Cartera");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }

   public void changeFragment(Class<? extends Fragment> fragmentclass)
   {
       Fragment newFragment = null;
       try {
           newFragment = fragmentclass.newInstance();
       } catch (java.lang.InstantiationException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       FragmentManager manager = getActivity().getSupportFragmentManager();
       FragmentTransaction transaction = manager.beginTransaction();
       transaction.replace(R.id.fragmentConteinerViewPostulanResource,
               newFragment, fragmentclass.getCanonicalName());
       transaction.commit();
   }


    private void setListenerNavigation() {
        btNVview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mnNavPostulants:
                        changeFragment(ViewPostulanPurseView.class);
                        break;
                    case R.id.mnNavConsultants:
                        changeFragment(ViewConsultPurseView.class);
                        break;
                }
                return true;
            }
        });
    }
}
