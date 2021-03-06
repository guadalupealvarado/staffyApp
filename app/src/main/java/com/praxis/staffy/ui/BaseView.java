package com.praxis.staffy.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.ComponentCallbacks2;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;

import com.praxis.staffy.R;


public abstract class BaseView extends Fragment {
    public View rootView;
    public Context context;
    public Activity activity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*Adjuntar.
    *llamado una vez que el fragmento está asociado a su actividad
    * */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        * Interfaz con información global sobre un entorno
        * de aplicación. Esta es una clase abstracta cuya
        * implementación es proporcionada por el sistema
        * Android. Permite el acceso a clases y recursos
        * específicos de la aplicación, así como a llamadas
        * para operaciones a nivel de aplicación, como
        * actividades de inicio, transmisión y recepción d
        * e intentos, etc.
        * */

        this.activity = getActivity();
        this.context = activity.getApplicationContext();
    }


    public void showToastMsj(String msj){
        //Toast.makeText(context, msj, Toast.LENGTH_SHORT).show();
        Toast toast = new Toast(context);
        //usamos cualquier layout como Toast
        View toast_layout = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) rootView.findViewById(R.id.rlToast));
        toast.setView(toast_layout);
        

        //se podría definir el texto en el layout si es invariable pero lo hacemos programáticamente como ejemplo
        //tenemos acceso a cualquier widget del layout del Toast
        TextView textView = (TextView) toast_layout.findViewById(R.id.toastMessage);
        textView.setText(msj);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

    }



    public  interface FragmentInfoProyectInterfas extends LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, View.OnCreateContextMenuListener, ComponentCallbacks2, LifecycleOwner, ViewModelStoreOwner, ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator, AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
        View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState);}

}
