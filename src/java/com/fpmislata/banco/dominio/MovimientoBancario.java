package com.fpmislata.banco.dominio;

public class MovimientoBancario {

    int idMovimintoBancario;

    int CuentaOrigen;

    int CuentaDestino;

    double cantidad;

    String motivo;

    public MovimientoBancario(int idMovimintoBancario, int CuentaOrigen, int CuentaDestino, double cantidad, String motivo) {
        this.idMovimintoBancario = idMovimintoBancario;
        this.CuentaOrigen = CuentaOrigen;
        this.CuentaDestino = CuentaDestino;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }
    
    public int getIdMovimintoBancario() {
        return idMovimintoBancario;
    }

    public int getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(int CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public int getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(int CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
