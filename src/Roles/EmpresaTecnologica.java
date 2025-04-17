package Roles;

import java.util.ArrayList;

public class EmpresaTecnologica {
    private String nombreEmpresa;
    private ArrayList<Empleado> empleados;
    private ArrayList<Proyecto> proyectos;

    public EmpresaTecnologica(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.empleados = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public ArrayList<Proyecto> getProyectos() {
        return new ArrayList<>(proyectos);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(int index) {
        if (index >= 0 && index < empleados.size()) {
            empleados.remove(index);
        }
    }

    public void crearProyecto(String nombreProyecto) {
        proyectos.add(new Proyecto(nombreProyecto));
    }

    public void asignarEmpleadoAProyecto(int empleadoIndex, int proyectoIndex) {
        if (empleadoIndex >= 0 && empleadoIndex < empleados.size() && 
            proyectoIndex >= 0 && proyectoIndex < proyectos.size()) {
            proyectos.get(proyectoIndex).agregarEmpleado(empleados.get(empleadoIndex));
        }
    }

    public void mostrarEmpleados() {
        System.out.println("\n=== EMPLEADOS DE " + nombreEmpresa.toUpperCase() + " ===");
        for (Empleado emp : empleados) {
            emp.mostrarDatos();
            System.out.println("------");
        }
    }

    public void mostrarProyectos() {
        System.out.println("\n=== PROYECTOS DE " + nombreEmpresa.toUpperCase() + " ===");
        for (Proyecto proy : proyectos) {
            System.out.println("Proyecto: " + proy.getNombre());
            proy.mostrarEmpleados();
            System.out.println("------");
        }
    }
}