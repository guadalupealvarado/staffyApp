package com.praxis.staffy.model.DAO.user;
import android.util.Log;

import com.praxis.staffy.model.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInterfaz {

    private  static UserDAO instance;
    private ArrayList<User> list=new ArrayList<User>();

    private UserDAO()
    {
        instance=null;
    }

    public static UserDAO getInstance()
    {
        if(instance==null)
        {
            instance=new UserDAO();
        }
        return instance;
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }

    @Override

    public List<User> getAllUser() {
        return null;
    }


    @Override
    public User getUser(int id) {
        return list.get(id);
    }

    @Override
    public boolean changeOfPassword(int id_user, String newPassword, String correo)
    {

        return true;
    }

    @Override
    public User getUserToChangePassword(String code) {
        User objusuario=new User("Retro", "Retro", "s", "f", "f", "Retro", "s", "f", "f", "sd", "v");
        objusuario.setNombre("Jorge");
        objusuario.setApMaterno("Jacobo");
        objusuario.setApPaterno("Francisco");
        objusuario.setContrasenia("123456");
        objusuario.setId(1);
        objusuario.setCorreoElectronico("");
        objusuario.setIdTelefono(1);
        return objusuario;
    }

    @Override
    public int getSizeList() {
        return list.size();
    }

    @Override
    public void addUser(User user) {
        list.add(user);
        Log.e("Resultado","Se agrego un nuevo obj "+list.size());
    }
}
