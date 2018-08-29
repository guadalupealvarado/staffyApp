package com.praxis.staffy.ui.recoverPassword.newPassword;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.praxis.staffy.model.DTO.restorePassword.ObjectRestorePassword;
import com.praxis.staffy.model.setPojoServices.RecoverPassword.SetObjectNewPassword;
import com.praxis.staffy.service.servicesRecoverPassword.newPassword.AppiNewPassword;
import com.praxis.staffy.ui.managerFragment.activityViewXML.IndexView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragment;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.recoverPassword.enterMail.RecoverPasswordView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewPasswordView extends BaseView {

    AppiNewPassword appiNewPassword;

    @BindView(R.id.passwordNewPassword)
    EditText passwordNewPassword;

    @BindView(R.id.verifyPasswordNewPassword)
    EditText verifyPasswordNewPassword;

    NewPasswordPresenter presenter=null;
    String code=null;
    String mail=null;

    public NewPasswordView()
    {
        appiNewPassword=new AppiNewPassword();
        appiNewPassword.initAppiNewPassword();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_new_password_view, container, false);
        code=getArguments().getString(RecoverPasswordView.CODE);
        mail=getArguments().getString(RecoverPasswordView.MAIL);
        showToastMsj(mail);
        showToastMsj(code);
        presenter=new NewPasswordPresenter(this);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Optional
    @OnClick (R.id.btnNewPassword)
    public void newPassword()
    {
        if(passwordNewPassword.getText().toString().trim().isEmpty()
                || verifyPasswordNewPassword.getText().toString().trim().isEmpty())
        {
            showMessage("Debes escribir ambas contraseñas");
        }else {
            if (passwordNewPassword.getText().toString().trim().equalsIgnoreCase(verifyPasswordNewPassword.getText().toString().trim())) {
              // showMessage("Cambio realizado. ");
                restartPassword(code,mail,passwordNewPassword.getText().toString().trim());
                //presenter.newPassword(code,passwordNewPassword.getText().toString().trim());
               // goToIndex();
            } else {
                showMessage("Las contraseñas no son iguales.");
            }

        }
    }

    public void restartPassword(String code,String mail,String newPassword)
    {
        Call<ObjectRestorePassword> response=
                appiNewPassword.
                        servicesNewPassword.
                        newPassword(new SetObjectNewPassword(mail,code,newPassword));

        response.enqueue(new Callback<ObjectRestorePassword>() {
            @Override
            public void onResponse(Call<ObjectRestorePassword> call, Response<ObjectRestorePassword> response) {
                if(!response.isSuccessful())
                {
                    String error = "";
                    //Se busca el error.
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json"))
                    {
                        error="Erro en el body";
                        showMessage(error);
                    }
                    //Se obtiene el error.
                    else {
                        error = response.message();
                        showMessage(error);
                    }
                    //postEvent(PurseGeneralEvent.onErrorEvent, error);

                    return;
                }else {
                    ObjectRestorePassword objectRestorePassword=response.body();
                    if(objectRestorePassword.getMessage()!=null)
                    {
                        showMessage(objectRestorePassword.getMessage());
                    }else
                    {
                        showToastMsj("Vacio..");
                    }
                }
                }

            @Override
            public void onFailure(Call<ObjectRestorePassword> call, Throwable t) {
                showMessage(t.getMessage());
            }
        });
    }

    @Optional
    @OnClick(R.id.btnCancelNewPassword)
    public void goEnterCode()
    {
        ((MainActivity) activity).changeFragment(ManagerFragment.ENTERCODE);
    }


    public void showMessage(String msj) {
        showToastMsj(msj);
    }


    public void goToIndex()
    {
        Intent intent=new Intent(rootView.getContext(), IndexView.class);
        startActivity(intent);
    }

}
