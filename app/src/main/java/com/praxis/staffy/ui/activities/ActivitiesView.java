package com.praxis.staffy.ui.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.Activities.ActivitiesDAO;
import com.praxis.staffy.model.DAO.notification.NotificationDAO;
import com.praxis.staffy.model.pojo.ActivityP;
import com.praxis.staffy.model.pojo.Notification;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.activities.adapter.ActivitiesAdapterRecyclerView;
import com.praxis.staffy.ui.notification.NotificationModel;
import com.praxis.staffy.ui.notification.adapter.NotificationAdapterRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivitiesView extends BaseView implements ActivitiesMvp.view {
    @Nullable
    @BindView(R.id.activitiesPerformedRecycler)
    RecyclerView activitiesRecyclerView;

    ActivitiesPresenter activitiesPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_activities, container, false);
        ButterKnife.bind(this,rootView);

        activitiesPresenter = new ActivitiesPresenter(this);
        activitiesPresenter.oncreate();
        activitiesPresenter.loadList();
        setLinearLayouManager(activitiesRecyclerView);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();

        if(!NotificationModel.UPDATE)
        {
            cardDataCardView(ActivitiesDAO.getInstance().getList());
            showMessage("Ya se cargó.");
        }
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    // Metodos antes de realizar el back o capturar el evento back
                    showMessage("Adios...");
                    return true;
                }
                return false;
            }
        });

        //setDataCardView(notificationRecycler,buidNotification());
        return rootView;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void showMessage(String msj) {

    }

    private void setLinearLayouManager(RecyclerView activitiesRecycler)
    {
        //RecyclerView notificationRecycler=rootView.findViewById(R.id.notificationRecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.scrollToPosition(LinearLayout.SCROLLBAR_POSITION_DEFAULT);
        activitiesRecycler.setLayoutManager(linearLayoutManager);
    }
    public void setDataCardView(RecyclerView notificationRecycler,ArrayList<Notification> list)
    {
        NotificationAdapterRecyclerView notificationAdapterRecyclerView=
                new NotificationAdapterRecyclerView(
                        list,R.layout.cardview_activities,getActivity());
        notificationRecycler.setAdapter(notificationAdapterRecyclerView);
    }


    public void cardDataCardView(ArrayList<ActivityP> list)
    {
        ActivitiesAdapterRecyclerView activitiesAdapterRecyclerView=
                new ActivitiesAdapterRecyclerView(
                        list,R.layout.cardview_activities,getActivity());
        activitiesRecyclerView.setAdapter(activitiesAdapterRecyclerView);
    }
    @Override
    public void onDestroyView() {
        activitiesPresenter.ondestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        activitiesPresenter.ondestroy();
        super.onDestroy();
    }
}
