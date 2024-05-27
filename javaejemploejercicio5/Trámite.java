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
class Tramite {
    private int tramiteId;
    private Date fechaDelTramite;
    private Date fechaCita;
    private String tipoTramite;
    private float tasaTramite;

    public Tramite(int tramiteId, Date fechaDelTramite, Date fechaCita, String tipoTramite, float tasaTramite) {
        this.tramiteId = tramiteId;
        this.fechaDelTramite = fechaDelTramite;
        this.fechaCita = fechaCita;
        this.tipoTramite = tipoTramite;
        this.tasaTramite = tasaTramite;
    }

    public int getTramiteId() {
        return tramiteId;
    }

    public Date getFechaDelTramite() {
        return fechaDelTramite;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public float getTasaTramite() {
        return tasaTramite;
    }
}
