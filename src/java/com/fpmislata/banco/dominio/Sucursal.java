/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.dominio;

/**
 *
 * @author alumno
 */
public class Sucursal {
   
    int idSucursal;
    
    String localizacion;
    
    String codigoSucursal;
    
    String entidadBancaria;
    
    String nombreSucursal;

    public Sucursal(int idSucursal, String localizacion, String codigoSucursal, String entidadBancaria, String nombreSucursal) {
        this.idSucursal = idSucursal;
        this.localizacion = localizacion;
        this.codigoSucursal = codigoSucursal;
        this.entidadBancaria = entidadBancaria;
        this.nombreSucursal = nombreSucursal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(String entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
}
