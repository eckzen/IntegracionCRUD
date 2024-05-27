/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaejemploejercicio5;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class JavaEjemploEjercicio5 {

    public static void main(String[] args) {
        try {
            UserDAO userDAO = new UserDAO(); // Movido aquí
            Random random = new Random();

            // Crea y agrega 5 personas y empleados con datos aleatorios
            for (int i = 1; i <= 5; i++) {
                // Genera datos aleatorios
                String nombre = "Nombre" + i + random.nextInt(100);
                String apellidos = "Apellido" + i + random.nextInt(100);
                String dni = "DNI" + i + random.nextInt(1000);
                String correo = "correo" + i + random.nextInt(100) + "@example.com";
                String telefono = "Telefono" + random.nextInt(1000000);
                String contrasena = "contrasena" + random.nextInt(1000);

                // Crear nueva persona con datos aleatorios
                Persona nuevaPersona = new Persona(0, nombre, apellidos, dni, correo, telefono, contrasena, new Date(), "empleado", new Date());
                userDAO.insertPersona(nuevaPersona);
                System.out.println("Persona " + i + " insertada con nombre: " + nombre);

                // Crear nuevo empleado con datos aleatorios
                Empleado nuevoEmpleado = new Empleado(nuevaPersona.getPersonaId(), nombre, apellidos, dni, correo, telefono, contrasena, new Date(), "empleado", new Date(), 0);
                userDAO.insertEmpleado(nuevoEmpleado);
                System.out.println("Empleado " + i + " insertado con nombre: " + nombre);
            }

            // Obtener un empleado existente por su ID
            Empleado empleado = userDAO.getEmpleado(1);
            if (empleado != null) {
                // Actualizar los datos del empleado
                empleado.setNombre("Nuevo Nombre");
                empleado.setApellidos("Nuevos Apellidos");
                empleado.setDni("Nuevo DNI");
                // Actualizar otros campos según sea necesario

                userDAO.updateEmpleado(empleado);
                System.out.println("Empleado actualizado");
            } else {
                System.out.println("Empleado no encontrado");
            }

            // Eliminar un empleado por su ID
            int empleadoIdAEliminar = 2; // ID del empleado a eliminar
            userDAO.deleteEmpleado(empleadoIdAEliminar);
            System.out.println("Empleado eliminado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
