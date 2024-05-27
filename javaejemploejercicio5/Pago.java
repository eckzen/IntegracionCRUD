/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaejemploejercicio5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author pc
 */
class Pago {
    private int pagoId;
    private Date fechaPago;
    private boolean estadoDelPago;

    public Pago(int pagoId, Date fechaPago, boolean estadoDelPago) {
        this.pagoId = pagoId;
        this.fechaPago = fechaPago;
        this.estadoDelPago = estadoDelPago;
    }

    public int getPagoId() {
        return pagoId;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public boolean isEstadoDelPago() {
        return estadoDelPago;
    }
}