package com.praxis.staffy.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.ui.managerFragment.activityViewXML.IndexView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragment;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.utils.CheckMailFormat;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class  LoginView extends BaseView implements  LoginMvp.LoginViewInterface {

    private LoginPresenterImp loginPresenter;
    private static String STATUS="success";



    //LayoutInflater Crea una instancia de un archivo XML de diseño en sus View objetos correspondientes . Nunca se usa directamente

    // A ViewGroupes una vista especial que puede contener otras vistas (llamadas niños).
    // El grupo de vista es la clase base para diseños y contenedores de vistas.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*
        * Crea una instancia de un archivo XML de diseño en sus View objetos correspondientes .
        * Nunca se usa directamente. En su lugar, use Activity.getLayoutInflater()o para
        * recuperar una instancia estándar de LayoutInflater que ya está conectada al
        * contexto actual y configurada correctamente para el dispositivo en el que
        * se está ejecutando. Context.getSystemService(Class)
        * */

        // El rootView de la clase padre pasaa ser.

        //Se crea un presentador y el recibe la vista que maneja.
        rootView = inflater.inflate(R.layout.login_view, container, false);
        loginPresenter = new LoginPresenterImp(this);
        loginPresenter.oncreate();
        //Para usar el Butter.
        ButterKnife.bind(this, rootView);
       // starSet();
        TextInputEditText inputUser=rootView.findViewById(R.id.inputUserTXT);
        TextInputEditText inputPassword=rootView.findViewById(R.id.etPasswordTXT);
        inputUser.setText("jorge-jy2@hotmail.com");
        inputPassword.setText("password");
        return rootView;
    }



    @Override
    public void showLoading() {
        //Muestra loading
       // showMessage("Cargando.....");
    }

    @Override
    public void hiddenLoading() {
        //Esconde loading
       // showMessage("Listo...");
    }

    @Override
    public void succesLogin()
    {
        Intent intent=new Intent(rootView.getContext(), IndexView.class);
        startActivity(intent);
      // ((MainActivity) activity).changeFragment(ManagerFragment.BRAND);
    }


    @Override
    public void showMessage(String msj) {
        showToastMsj(msj);
    }

    @Override
    public void onDestroy() {
        loginPresenter.ondestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        loginPresenter.ondestroy();
        super.onDestroyView();
    }

    @Override
    public void goRecoverPasswordI()
    {
        ((MainActivity) activity).changeFragment(ManagerFragment.RECOVERPASSWORD);
    }

    @Optional
    @OnClick(R.id.initLogin)
    public void initLogin() {

        TextInputLayout inputUserLayou=rootView.findViewById(R.id.inputUser);
        TextInputLayout inputPasswordLayout=rootView.findViewById(R.id.etPassword);

        TextInputEditText inputUser=rootView.findViewById(R.id.inputUserTXT);
        TextInputEditText inputPassword=rootView.findViewById(R.id.etPasswordTXT);

        String user = inputUser.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        inputUserLayou.setError(null);
        inputUserLayou.clearFocus();

        if(CheckMailFormat.checkMailFormat(user))
        {

            if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password))
            {
                loginPresenter.login(user, password);
            } else
            {
                if (TextUtils.isEmpty(user))
                {
                    inputUserLayou.setError("Ingresa  el usuario");
                } else if (TextUtils.isEmpty(password))
                {
                    inputPasswordLayout.setError("Ingresa el password");
                }
            }
        }else
        {
            inputUserLayou.setError("Ingresa un correo valido");
        }
    }

    @OnClick(R.id.recoverPasswordtxt)
    public void goRecoverPassword()
    {
         goRecoverPasswordI();
    }


}
