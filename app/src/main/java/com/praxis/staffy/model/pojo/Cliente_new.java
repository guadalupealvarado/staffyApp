package com.praxis.staffy.model.pojo;

public class Cliente_new {
    private String logo;
    private String Name;
    private String contador;

    public Cliente_new(String logo, String name, String contador) {
        this.logo = logo;
        this.Name = name;
        this.contador = contador;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }
}
