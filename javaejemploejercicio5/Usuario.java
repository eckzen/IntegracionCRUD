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

//Clase Usuario hereda de Persona
class Usuario extends Persona {
  private int usuarioId;

    // Constructor sin el usuarioId
    public Usuario(int personaId, String dni) { //no se especifica usuarioID porque ya tiene AUTO_INCREMENT en la bbdd
        super(personaId, "", "", dni, "", "", "", null, "", null); //Llama al constructor de la clase Persona con los valores necesarios, pasando valores null para los atributos que no se usan en este caso
    }

    public Usuario(int usuarioId, int personaId, String dni) {
        super(personaId, "", "", dni, "", "", "", null, "", null);
        this.usuarioId = usuarioId;
    }

    public Usuario(int personaId, String nombre, String apellidos, String dni, String correo, String telefono, String contrasena, Date fechaNacimiento, String rol, Date fechaCreacion, int usuarioId) {
        super(personaId, nombre, apellidos, dni, correo, telefono, contrasena, fechaNacimiento, rol, fechaCreacion);
        this.usuarioId = usuarioId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}