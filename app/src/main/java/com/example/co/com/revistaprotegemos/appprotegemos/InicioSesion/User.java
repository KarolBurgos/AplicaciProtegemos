package com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion;

/**
 * Created by ASPIRE VX15 on 22/03/2018.
 */

public class User {

    private String nombre,tipoPlan,con_cod,per_cc;


    public String getCon_cod() {
        return con_cod;
    }

    public void setCon_cod(String con_cod) {
        this.con_cod = con_cod;
    }

    public String getPer_cc() {
        return per_cc;
    }

    public void setPer_cc(String per_cc) {
        this.per_cc = per_cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
}
