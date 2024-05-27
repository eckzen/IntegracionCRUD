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
class Notificacion {
    private int notificacionId;
    private Date fechaEnvio;
    private String textoNotificacion;

    public Notificacion(int notificacionId, Date fechaEnvio, String textoNotificacion) {
        this.notificacionId = notificacionId;
        this.fechaEnvio = fechaEnvio;
        this.textoNotificacion = textoNotificacion;
    }

    public int getNotificacionId() {
        return notificacionId;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public String getTextoNotificacion() {
        return textoNotificacion;
    }
}