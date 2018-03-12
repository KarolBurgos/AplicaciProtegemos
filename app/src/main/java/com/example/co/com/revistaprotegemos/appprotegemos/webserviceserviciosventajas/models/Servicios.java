package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public class Servicios {

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
    public Servicios(String titulo, String descripcion, String img) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
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

}
