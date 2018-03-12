package com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models;

/**
 * Created by ASPIRE VX15 on 5/03/2018.
 */

public class Jornadas {
    private String tipojornada;
    private String descrjornada;
    private String img;

    /**
     * No args constructor for use in serialization
     *
     */
    public Jornadas() {
    }

    /**
     *
     * @param descrjornada
     * @param tipojornada
     */
    public Jornadas(String tipojornada, String descrjornada,String img) {
        super();
        this.tipojornada = tipojornada;
        this.descrjornada = descrjornada;
        this.img=img;
    }

    public String getTipojornada() {
        return tipojornada;
    }

    public void setTipojornada(String tipojornada) {
        this.tipojornada = tipojornada;
    }

    public String getDescrjornada() {
        return descrjornada;
    }

    public void setDescrjornada(String descrjornada) {
        this.descrjornada = descrjornada;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.descrjornada = img;
    }
}
