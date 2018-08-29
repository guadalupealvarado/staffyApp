package com.praxis.staffy.model.setPojoServices.updateClient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class setClientsUpdate {


        @SerializedName("nb_cliente")
        @Expose
        private String nbCliente;
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("id_usuario")
        @Expose
        private Integer idUsuario;
        @SerializedName("direcciones")
        @Expose
        private List<SetAddressClientUpdate> direcciones = null;

        public String getNbCliente() {
            return nbCliente;
        }

        public void setNbCliente(String nbCliente) {
            this.nbCliente = nbCliente;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public Integer getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
        }

        public List<SetAddressClientUpdate> getDirecciones() {
            return direcciones;
        }


        public void setDirecciones(List<SetAddressClientUpdate> direcciones) {
            this.direcciones = direcciones;
        }

    }
