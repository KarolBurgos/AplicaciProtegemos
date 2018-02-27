package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

/**
 * Created by ASPIRE VX15 on 20/02/2018.
 */

public class Planes {

   private String titulo;
    private String descripcion;
    private String img;

    public Planes(String titulo, String descripcion) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
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
  /*private String ver;
    private String name;
    private String api;

    public String getVer() {
        return ver;
    }

    public String getName() {
        return name;
    }

    public String getApi() {
        return api;
    }
*/
}

