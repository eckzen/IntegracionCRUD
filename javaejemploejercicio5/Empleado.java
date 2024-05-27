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

//Clase Empleado hereda de Persona
public class Empleado extends Persona {
    private int empleadoId;

    public Empleado(int personaId, String nombre, String apellidos, String dni, String correo, String telefono, String contrasena, Date fechaNacimiento, String rol, Date fechaCreacion, int empleadoId) {
        super(personaId, nombre, apellidos, dni, correo, telefono, contrasena, fechaNacimiento, rol, fechaCreacion);
        this.empleadoId = empleadoId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }
}