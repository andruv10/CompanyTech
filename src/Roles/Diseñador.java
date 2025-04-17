package Roles;

public class Diseñador extends Empleado {

    private String herramientaDiseño;

    public Diseñador(String nombre, int edad, double salarioBase, String herramientaDiseño) {
        super(nombre, edad, salarioBase);
        this.herramientaDiseño = herramientaDiseño;
    }

    public String getHerramientaDiseño() {
        return herramientaDiseño;
    }

    public void setHerramientaDiseño(String herramientaDiseño) {
        this.herramientaDiseño = herramientaDiseño;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + 500;
    }

    @Override
    public String trabajar() {
        return getNombre() + " está diseñando usando " + herramientaDiseño;
    }
}