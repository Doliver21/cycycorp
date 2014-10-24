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
public class Empleado {
    
    int idEmpleado;
    
    String usuario;
    
    String contrasenya;
    
    String nombre;
    
    String dni;
    
    String sucursal;

    public Empleado(int idEmpleado, String usuario, String contrasenya, String dni, String sucursal) {
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.dni = dni;
        this.sucursal = sucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }    
}
