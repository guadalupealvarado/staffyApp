package com.praxis.staffy.model.DAO.Proyect;

import com.praxis.staffy.model.pojo.Project;

import java.util.ArrayList;

public class ProyectDAO {

    private ArrayList<Project> projectArrayList=new ArrayList<>();
    private static ProyectDAO instance;

    private ProyectDAO() {
    }

    public static ProyectDAO getInstance() {
        if(instance==null)
        {
            instance=new ProyectDAO();
        }
        return instance;
    }

    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    public Project getProyect(String nameProyect)
    {
        for(int a=0;a<projectArrayList.size();a++)
        {
            if(projectArrayList.get(a).getNbProyecto().equalsIgnoreCase(nameProyect))
            {
                return projectArrayList.get(a);
            }
        }
        return null;
    }
}
