package com.praxis.staffy.ui.recoverPassword.enterMail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.praxis.staffy.model.DTO.ObjectRecoverPassword;
import com.praxis.staffy.model.setPojoServices.RecoverPassword.SetObjetMailRecoverPassword;
import com.praxis.staffy.service.servicesRecoverPassword.AppiRecoverPassword;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragment;
import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.utils.CheckMailFormat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoverPasswordView extends BaseView implements Recover_passwordMvp.view {

    //--------------------- VAR------------------------------------------------
    private   final AppiRecoverPassword appiRecoverPassword;
    private RecoverPasswordPresenterImp presenterImp;
    public static final String MAIL="correo";
    public static final String CODE="code";
    private static final String MESSAGGE="Se ejecuto correctamente el procedimiento";
   // private String mail;
    //---------------------Contructor----------------
    public RecoverPasswordView()
    {
        appiRecoverPassword=new AppiRecoverPassword();
        appiRecoverPassword.initRecoverPassword();
    }

    //--------------- UI-------------------------------
    @Nullable
    @BindView(R.id.rpPasswordMail)
    public EditText rpMail;

    //-----------------VIEW---------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_recover_password, container, false);
        presenterImp=new RecoverPasswordPresenterImp(this);
        ButterKnife.bind(this,rootView);
        return rootView;
    }


    //--------------- EVENTS------------------------------
    @Optional
    @OnClick (R.id.btnSendMail)
    @Override
    public void sendMain()
    {
       String mail=rpMail.getText().toString().trim().toLowerCase();
        if(!mail.isEmpty())
        {
            if(CheckMailFormat.checkMailFormat(mail))
              // presenterImp.searchEmail(rpMail.getText().toString().trim());
                recoverPassword(mail);
            else
                showMessage(getResources().getString(R.string.invalid_email_recover_password_enter_mail));
        }else
            showToastMsj(MyAplication.getContext().getResources().getString(R.string.txt_you_must_enter_an_email_msg));
    }

    @Optional
    @OnClick(R.id.btnCancel)
    public void goLogin()
    {
        ((MainActivity) getActivity()).changeFragment(ManagerFragment.LOGIN);
    }

    @Override
    public void showMessage(String msj)
    {
        showToastMsj(msj);
    }

    @Override
    public void  goEnterCode(String code,String mail)
    {
        Bundle bundle=new Bundle();
        bundle.putString(RecoverPasswordView.MAIL,mail);
        bundle.putString(RecoverPasswordView.CODE,code);
        ((MainActivity) activity).changeFragment(ManagerFragment.ENTERCODE.setBundle(bundle));
    }


    public boolean recoverPassword(final String mail)
    {
        Call<ObjectRecoverPassword> response=appiRecoverPassword.servicesRecoverPassword.
                recoverPassword(new SetObjetMailRecoverPassword(mail));
        response.enqueue(new Callback<ObjectRecoverPassword>() {
            @Override
            public void onResponse(Call<ObjectRecoverPassword> call, Response<ObjectRecoverPassword> response)
            {
                if(!response.isSuccessful())
                {
                    String error = "";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json"))
                    {
                        error=getResources().getString(R.string.error_body_recover_password_web_services);
                    }
                    //Se obtiene el error.
                    else { error = response.message(); }
                    //postEvent(PurseGeneralEvent.onErrorEvent, error);
                    if(error!="") showMessage(error);
                    return;
                }else
                {
                    ObjectRecoverPassword objectRecoverPassword=response.body();
                    if(objectRecoverPassword!=null)
                    {
                        if(objectRecoverPassword.getMessage().equalsIgnoreCase(RecoverPasswordView.MESSAGGE))
                        {
                            if(objectRecoverPassword!=null) {
                                goEnterCode(objectRecoverPassword.getData().getCodigo(),mail);
                            }
                        }else
                        {
                            showMessage("El correo ingresado no existe.");
                        }
                    }else
                        showMessage("La petición  al web services ah fallado.");
                }
            }
            @Override
            public void onFailure(Call<ObjectRecoverPassword> call, Throwable t) {
                showMessage(t.getMessage());
            }
        });
        return true;
    }

}