/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

/**
 *
 * @author Cycycorp
 */
public class EntidadBancaria {

    Integer idEntidadBancaria;

    String nombre;

    String codigoEntidad;

    public EntidadBancaria() {

    }

    public EntidadBancaria(Integer idEntidadBancaria, String codigoEntidad, String nombre) {
        this.codigoEntidad = codigoEntidad;
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigo) {
        this.codigoEntidad = codigo;
    }
}
