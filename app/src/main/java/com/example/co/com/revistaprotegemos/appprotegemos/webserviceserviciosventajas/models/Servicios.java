package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public class Servicios {


    private int id_servicios;
    private String titulo;
    private String descripcion;
    private String img;

    /**
     * No args constructor for use in serialization
     *
     */
    public Servicios() {
    }

    /**
     *
     * @param titulo
     * @param img
     * @param descripcion
     */
    public Servicios(String titulo, String descripcion, String img,int id_servicios) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
        this.id_servicios=id_servicios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId_servicios() {
        return id_servicios;
    }

    public void setId_servicios(int id_servicios) {
        this.id_servicios = id_servicios;
    }
}
