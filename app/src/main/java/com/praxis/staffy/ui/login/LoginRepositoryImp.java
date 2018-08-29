package com.praxis.staffy.ui.login;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.event.general.PostEventGeneral;
import com.praxis.staffy.model.DTO.ListUser;
import com.praxis.staffy.model.setPojoServices.SetUserModel;
import com.praxis.staffy.service.serviceLogin.AppiLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Hereda de postEvent debido a que usa los eventos ue realiza al hacer la consulta.
//Como es el model tiene la interfaz .
public class LoginRepositoryImp extends PostEventGeneral implements LoginMvp.LoginRepositoryInterface {


    public static String POJOLOGIN="POJOLOGIN";
    private final AppiLogin appiLogin;

/*

    public LoginRepositoryImp() {
        apiService = new ApiService();
        apiService.initApiService();
    }
*/

public LoginRepositoryImp()
{
    appiLogin=new AppiLogin();
    appiLogin.initApiservices();
}

   // @Override
    //???????????????? Por qué final final String user solo user?
   // public void initLogin(final String user, String password, String deviceId, String version)
    //{
        //Crea el objeto
      //  BodyLogin bodyLogin = new BodyLogin(user, password, deviceId, version);
        //del api services
        //
       // Call<Session> loginCall = apiService.apiclient.newClient(bodyLogin);

      /*  loginCall.enqueue(new Callback<Session>()
        {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
                //Sí no es exitosa la conexíon
                if (!response.isSuccessful()) {
                    String error = "";
                    //Se busca el error.
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json"))
                    {

                    }
                    //Se obtiene el error.
                    else {
                        error = response.message();
                    }
                    //Se llama al evento postEvento para decirle con el valor estatico hay un error. con el nombre.
                //    postEvent(GeneralEventExample.onErrorEvent, error);
                    return;
                }else {
                    Session session = response.body();


                    //ANTERIOR
                 //   postEvent(GeneralEventExample.onSuccesEvent, session);
                }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                postEvent(GeneralEventExample.onErrorEvent,  t.getMessage());
            }
        });
        */
   // }


    @Override
    public boolean login(final String user, final String password)
    {
        GeneralEvent.POJO= LoginRepositoryImp.POJOLOGIN;
       // Log.e("Envio",PurseGeneralEvent.POJO);
        Call<ListUser> response=appiLogin.servicesLoginI.getPostUser(new SetUserModel(user,password));
            response.enqueue(new Callback<ListUser>()
            {
                @Override
                public void onResponse(Call<ListUser> call, Response<ListUser> response)
                {
                    if(!response.isSuccessful())
                    {
                        String error = "";
                        //Se busca el error.
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("application/json"))
                        {

                        }
                        //Se obtiene el error.
                        else {
                            error = response.message();
                        }
                        postEvent(GeneralEvent.onErrorEvent, error);
                        return;
                    }else
                        {
                            ListUser obRes = response.body();
                        if (obRes.getList().get(0).getCorreoElectronico() != null)
                        {
                            postEvent(GeneralEvent.onSuccesEvent,obRes);
                        }else
                        {
                            postEvent(GeneralEvent.onErrorEvent,"El usuario no existe. ");
                        }
                            return;
                    }
                }
                @Override
                public void onFailure(Call<ListUser> call, Throwable t) {
                    postEvent(GeneralEvent.onErrorEvent,t.getLocalizedMessage());
                }
            });
        return true;
    }


}
