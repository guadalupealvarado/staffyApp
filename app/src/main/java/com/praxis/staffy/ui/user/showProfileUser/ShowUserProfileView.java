package com.praxis.staffy.ui.user.showProfileUser;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.ui.BaseView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowUserProfileView extends BaseView {

    @Nullable
    @BindView(R.id.tv_name_view_profile)
    TextView tv_name_view_profile;

    @Nullable
    @BindView(R.id.tv_email_view_profile)
    TextView tv_email_view_profile;


    @Nullable
    @BindView(R.id.tv_number_phone)
    TextView tv_number_phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_view_profile, container, false);
        ButterKnife.bind(this,rootView);
        loadDataProfile();
       // showToolbar(rootView);
        return  rootView;
    }


    private void loadDataProfile() {
        tv_name_view_profile.setText(UserDAO.getInstance().getUser(0).getNombre()
                +" "+ UserDAO.getInstance().getUser(0).getApPaterno()
                +" "+ UserDAO.getInstance().getUser(0).getApMaterno());
        tv_email_view_profile.setText(UserDAO.getInstance().getUser(0).getCorreoElectronico());
    }


}
