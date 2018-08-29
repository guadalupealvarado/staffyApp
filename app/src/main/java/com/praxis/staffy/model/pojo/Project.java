package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

        @SerializedName("id_proyecto")
        @Expose
        private Integer idProyecto;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("nb_proyecto")
        @Expose
        private String nbProyecto;
        @SerializedName("fh_inicio")
        @Expose
        private String fhInicio;
        @SerializedName("fh_fin")
        @Expose
        private String fhFin;
        @SerializedName("observacion")
        @Expose
        private String observacion;
        @SerializedName("id_creacion")
        @Expose
        private Integer idCreacion;
        @SerializedName("tm_creacion")
        @Expose
        private String tmCreacion;
        @SerializedName("id_actualizacion")
        @Expose
        private Integer idActualizacion;
        @SerializedName("tm_actualizacion")
        @Expose
        private String tmActualizacion;
        @SerializedName("id_estatus_proyecto")
        @Expose
        private Integer idEstatusProyecto;
        @SerializedName("estatus_proyecto")
        @Expose
        private String estatusProyecto;
        @SerializedName("clientes")
        @Expose
        private Object clientes;
        @SerializedName("contactos")
        @Expose
        private String contactos;
        @SerializedName("direcciones")
        @Expose
        private String direcciones;

        public Integer getIdProyecto() {
            return idProyecto;
        }

        public void setIdProyecto(Integer idProyecto) {
            this.idProyecto = idProyecto;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getNbProyecto() {
            return nbProyecto;
        }

        public void setNbProyecto(String nbProyecto) {
            this.nbProyecto = nbProyecto;
        }

        public String getFhInicio() {
            return fhInicio;
        }

        public void setFhInicio(String fhInicio) {
            this.fhInicio = fhInicio;
        }

        public String getFhFin() {
            return fhFin;
        }

        public void setFhFin(String fhFin) {
            this.fhFin = fhFin;
        }

        public String getObservacion() {
            return observacion;
        }

        public void setObservacion(String observacion) {
            this.observacion = observacion;
        }

        public Integer getIdCreacion() {
            return idCreacion;
        }

        public void setIdCreacion(Integer idCreacion) {
            this.idCreacion = idCreacion;
        }

        public String getTmCreacion() {
            return tmCreacion;
        }

        public void setTmCreacion(String tmCreacion) {
            this.tmCreacion = tmCreacion;
        }

        public Integer getIdActualizacion() {
            return idActualizacion;
        }

        public void setIdActualizacion(Integer idActualizacion) {
            this.idActualizacion = idActualizacion;
        }

        public String getTmActualizacion() {
            return tmActualizacion;
        }

        public void setTmActualizacion(String tmActualizacion) {
            this.tmActualizacion = tmActualizacion;
        }

        public Integer getIdEstatusProyecto() {
            return idEstatusProyecto;
        }

        public void setIdEstatusProyecto(Integer idEstatusProyecto) {
            this.idEstatusProyecto = idEstatusProyecto;
        }

        public String getEstatusProyecto() {
            return estatusProyecto;
        }

        public void setEstatusProyecto(String estatusProyecto) {
            this.estatusProyecto = estatusProyecto;
        }

        public Object getClientes() {
            return clientes;
        }

        public void setClientes(Object clientes) {
            this.clientes = clientes;
        }

        public String getContactos() {
            return contactos;
        }

        public void setContactos(String contactos) {
            this.contactos = contactos;
        }

        public String getDirecciones() {
            return direcciones;
        }

        public void setDirecciones(String direcciones) {
            this.direcciones = direcciones;
        }

    }
