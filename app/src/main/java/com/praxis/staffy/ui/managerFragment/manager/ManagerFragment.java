package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivity;
import com.praxis.staffy.ui.login.LoginView;
import com.praxis.staffy.ui.recoverPassword.enterMail.RecoverPasswordView;
import com.praxis.staffy.ui.recoverPassword.entercode.EnterCodeView;
import com.praxis.staffy.ui.recoverPassword.newPassword.NewPasswordView;


public enum ManagerFragment {

    LOGIN(){
        @Override
        public Fragment execute(MainActivity activity) {
            //Envio de fragmento, El main activity, el id donde se remplaza y el objeto del fragmento que se pondrá.
            return setFragment(activity, R.id.fragmentConteiner, LoginView.class);
        }
    },RECOVERPASSWORD() {
        @Override
        public Fragment execute(MainActivity activity) {
            return setFragment(activity, R.id.fragmentConteiner, RecoverPasswordView.class);
        }
    },ENTERCODE {
        @Override
        public Fragment execute(MainActivity activity) {
            return setFragment(activity, R.id.fragmentConteiner, EnterCodeView.class);
        }
    },NEWPASSWORD{
        @Override
        public Fragment execute(MainActivity activity) {
            return setFragment(activity, R.id.fragmentConteiner, NewPasswordView.class);
        }
    };


    //El metodo execute es abstract
    //Decirlo de una manera es el padre
    //que sera implementado.
    public abstract Fragment execute(MainActivity activity);
    //?????????????
    //¿Por qué la clase Menu no es abstract sí usa un metodo abstract

    //Bundle para mandar parametros
    public Bundle bundle;

    public Fragment setFragment(MainActivity activity, int id, Class<? extends Fragment> fragmentclass){
        // Con Class<? extends Fragment> fragmentclass se dice que recibe de una clase que
        // debe extender de Fragment.
        try {

            // Se guarda una objeto
            //Se ponde Fragment porque debe extender de fragmento.
            //Se castea para ser un Fragmento.
            Fragment newFragment = fragmentclass.newInstance();
            //sí el bundle no es nulo
            if(bundle != null){
                //Del nuevo fragmento
                newFragment.setArguments(bundle);
            }

            // se crea un Manager para enviar el soporte.
            FragmentManager manager = activity.getSupportFragmentManager();
            // encarga de la transición.
            FragmentTransaction transaction = manager.beginTransaction();

            //ID de donde se va a remplazar, el nuevo fragmento, el nombre
            //transaction.replace(id, newFragment, fragmentclass.getCanonicalName());
            transaction.replace(id, newFragment, fragmentclass.getCanonicalName());
            transaction.commit();
            return newFragment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //?????????????????????????????????
    //Es necesario este metodo?
    public static ManagerFragment setState(ManagerFragment newState){
        //Recibes el newState que es un ENUM de Ls clase
        //Se crea un objeto de esa clase y se regresa.

        ManagerFragment state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }



    public ManagerFragment setBundle(Bundle bundle) {
        this.bundle = bundle;
        //?????????????????
        //Por que retorna todo ???

        return this;
    }
}
