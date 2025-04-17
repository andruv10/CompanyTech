package Roles;

import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        System.out.println("Proyecto: " + nombre);
        for (Empleado emp : empleados) {
            System.out.println("- " + emp.getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
