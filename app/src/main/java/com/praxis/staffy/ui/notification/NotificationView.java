package com.praxis.staffy.ui.notification;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.notification.NotificationDAO;
import com.praxis.staffy.model.pojo.Notification;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.notification.adapter.NotificationAdapterRecyclerView;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationView extends BaseView implements NotificacionMvp.view {

    @Nullable
    @BindView(R.id.notificationRecycler)
    RecyclerView notificationRecycler;

    private NotificacionPresenterImp presenterImp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_notification_view, container, false);
        //Se crea un presentador y el recibe la vista que maneja.
        //Para usar el Butter.
        ButterKnife.bind(this, rootView);
        presenterImp = new NotificacionPresenterImp(this);
        presenterImp.oncreate();
        presenterImp.loadList();
        setLinerLayouManager(notificationRecycler);
        notificationRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    //showMessage("Cargando......");
                    if(dy==100)
                    {
                        showMessage("este es el final ");
                    }
                 //   presenterImp.restLoadNotification();
                }
            }
        });


        //Button back
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
       if(!NotificationModel.UPDATE)
       {
           cardDataCardView(NotificationDAO.getInstance().getList());
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

    public ArrayList<Notification> buidNotification()
    {
        if(!NotificationDAO.getInstance().getList().isEmpty())
        {
            if (NotificationDAO.getInstance().getList().get(0).getDescripcion().isEmpty())
            {
                showToastMsj("No tienes actividades");
            }
        }else
        {
           showToastMsj("No tienes actividades");
        }
        return  NotificationDAO.getInstance().getList();
    }

    private void setLinerLayouManager(RecyclerView notificationRecycler)
    {
        //RecyclerView notificationRecycler=rootView.findViewById(R.id.notificationRecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.scrollToPosition(LinearLayout.SCROLLBAR_POSITION_DEFAULT);
        notificationRecycler.setLayoutManager(linearLayoutManager);
    }

    public void setDataCardView(RecyclerView notificationRecycler,ArrayList<Notification> list)
    {
        NotificationAdapterRecyclerView notificationAdapterRecyclerView=
                new NotificationAdapterRecyclerView(
                        list,R.layout.cardview_notificaton,getActivity());
        notificationRecycler.setAdapter(notificationAdapterRecyclerView);
    }


    public void cardDataCardView(ArrayList<Notification> list)
    {
        NotificationAdapterRecyclerView notificationAdapterRecyclerView=
                new NotificationAdapterRecyclerView(
                        list,R.layout.cardview_notificaton,getActivity());
        notificationRecycler.setAdapter(notificationAdapterRecyclerView);
    }

    @Override
    public void showLoading() {
        showMessage("Cargando notificaciones");
    }

    @Override
    public void hiddenLoading() {
        showMessage("Listo notificaciones");
    }

    @Override
    public void showMessage(String msj) {
        showToastMsj(msj);
    }


    @Override
    public void onDestroyView() {
        presenterImp.ondestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        presenterImp.ondestroy();
        super.onDestroy();
    }
}

