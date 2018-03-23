package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */
public class Pautas {

    private String id_zona_pautas;
    private String lugar;
    private String descripcion;
    private String img;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pautas() {
    }

    /**
     *
     * @param lugar
     * @param descripcion
     */
    public Pautas(String lugar, String descripcion,String img, String id_zona_pautas) {
        super();
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.img=img;
        this.id_zona_pautas=id_zona_pautas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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

    public String getId_zona_pautas() {
        return id_zona_pautas;
    }

    public void setId_zona_pautas(String id_zona_pautas) {
        this.id_zona_pautas = id_zona_pautas;
    }
}