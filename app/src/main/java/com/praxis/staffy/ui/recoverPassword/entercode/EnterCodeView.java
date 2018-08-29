package com.praxis.staffy.ui.recoverPassword.entercode;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragment;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.recoverPassword.enterMail.RecoverPasswordView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterCodeView extends BaseView implements EnterCodeMvp.view{

    String code=null;
    String mail=null;
    public EnterCodeView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView =inflater.inflate(R.layout.fragment_enter_code_view, container, false);
        ButterKnife.bind(this,rootView);
        code=getArguments().getString(RecoverPasswordView.CODE);
        mail=getArguments().getString(RecoverPasswordView.MAIL);
        showToastMsj(mail);
        showToastMsj(code);
        enterMail(getArguments().getString(RecoverPasswordView.MAIL));
        return  rootView;
    }

    @Override
    public void showMessage(String msj) {
        showToastMsj(msj);
    }



    @BindView(R.id.textEmailCode)
    TextView textEmailCode;

    public void enterMail(String mail)
    {
        textEmailCode.setText(textEmailCode.getText().toString()+" : "+mail);
    }


    @Optional
    @OnClick(R.id.btnCancelEnterCode)
    public void goRecoverPasswordFragment()
    {

        ((MainActivity) activity).changeFragment(ManagerFragment.RECOVERPASSWORD);
    }


    @BindView(R.id.codeEditTextRecoerPassword)
    EditText codeEditTextRecoerPassword;


    @Optional
    @OnClick(R.id.btnSendMail)
    public void sendEmailCode()
    {
        try
        {
            String codeRecoverPassword=(codeEditTextRecoerPassword.getText().toString());
            if(codeRecoverPassword.isEmpty())
                showToastMsj("Debes ingresar un código.");
            else
                if(code.equalsIgnoreCase(codeRecoverPassword))
                goToNewPassword(codeRecoverPassword);
                else
                    showToastMsj("El código debe ser el mismo.");

        }catch (Exception ex)
        {
            showToastMsj("Debes ingresar un código valido");
        }
    }

    private void goToNewPassword(String code)
    {
        Bundle bundle=new Bundle();
        bundle.putString(RecoverPasswordView.MAIL,mail);
        bundle.putString(RecoverPasswordView.CODE,code);
        ((MainActivity) activity).changeFragment(ManagerFragment.NEWPASSWORD.setBundle(bundle));
    }
}
