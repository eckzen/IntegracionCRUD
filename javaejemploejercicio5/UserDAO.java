/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaejemploejercicio5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UserDAO {

    // Método para insertar una persona
    public void insertPersona(Persona persona) throws SQLException {
        String sql = "INSERT INTO Persona (Nombre, Apellidos, Dni, Correo, Telefono, Contrasena, FechaNacimiento, Rol, FechaCreacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBBDDejemplo5.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getDni());
            stmt.setString(4, persona.getCorreo());
            stmt.setString(5, persona.getTelefono());
            stmt.setString(6, persona.getContrasena());
            stmt.setDate(7, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            stmt.setString(8, persona.getRol());
            stmt.setDate(9, new java.sql.Date(persona.getFechaCreacion().getTime()));
            stmt.executeUpdate();

            // Obtener la clave generada automáticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persona.setPersonaId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Método para insertar un empleado
    public void insertEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO Empleado (Persona_id) VALUES (?)";
        try (Connection conn = ConexionBBDDejemplo5.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, empleado.getPersonaId());
            stmt.executeUpdate();

            // Obtener la clave generada automáticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    empleado.setEmpleadoId(generatedKeys.getInt(1));
                }
            }
        }
    }
    
    // Método para actualizar un empleado
    public void updateEmpleado(Empleado empleado) throws SQLException {
    String sql = "UPDATE Empleado SET Nombre = ?, Apellidos = ?, Dni = ?, Correo = ?, Telefono = ?, Contrasena = ?, FechaNacimiento = ?, Rol = ?, FechaCreacion = ? WHERE Empleado_id = ?";
    try (Connection conn = ConexionBBDDejemplo5.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, empleado.getNombre());
        stmt.setString(2, empleado.getApellidos());
        stmt.setString(3, empleado.getDni());
        stmt.setString(4, empleado.getCorreo());
        stmt.setString(5, empleado.getTelefono());
        stmt.setString(6, empleado.getContrasena());
        stmt.setDate(7, empleado.getFechaNacimiento() != null ? new java.sql.Date(empleado.getFechaNacimiento().getTime()) : null);
        stmt.setString(8, empleado.getRol());
        stmt.setDate(9, empleado.getFechaCreacion() != null ? new java.sql.Date(empleado.getFechaCreacion().getTime()) : null);
        stmt.setInt(10, empleado.getEmpleadoId());
        stmt.executeUpdate();
    }
}


    
    // Método para eliminar un empleado
    public void deleteEmpleado(int empleadoId) throws SQLException {
        String sql = "DELETE FROM Empleado WHERE Empleado_id = ?";
        try (Connection conn = ConexionBBDDejemplo5.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empleadoId);
            stmt.executeUpdate();
        }
    }
    
    public Empleado getEmpleado(int empleadoId) throws SQLException {
    String sql = "SELECT Persona_id FROM Empleado WHERE Empleado_id = ?";
    try (Connection conn = ConexionBBDDejemplo5.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, empleadoId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int personaId = rs.getInt("Persona_id");
                // Ahora que tenemos el ID de la persona, recuperamos sus detalles desde la tabla Persona
                Persona persona = getPersona(personaId);
                if (persona != null) {
                    // Creamos y devolvemos un nuevo objeto Empleado con los detalles de la persona
                    return new Empleado(personaId, null, null, null, null, null, null, null, null, null, empleadoId);
                }
            }
        }
    }
    // Si no se encuentra el empleado, retornar null
    return null;
}

// Método para obtener los detalles de una persona
private Persona getPersona(int personaId) throws SQLException {
    String sql = "SELECT * FROM Persona WHERE Persona_id = ?";
    try (Connection conn = ConexionBBDDejemplo5.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, personaId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Obtener los detalles de la persona de la base de datos
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String dni = rs.getString("Dni");
                String correo = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String contrasena = rs.getString("Contrasena");
                Date fechaNacimiento = rs.getDate("FechaNacimiento");
                String rol = rs.getString("Rol");
                Date fechaCreacion = rs.getDate("FechaCreacion");
                // Crear y devolver un nuevo objeto Persona
                return new Persona(personaId, nombre, apellidos, dni, correo, telefono, contrasena, fechaNacimiento, rol, fechaCreacion);
            }
        }
    }
    // Si no se encuentra la persona, retornar null
    return null;
}

}
