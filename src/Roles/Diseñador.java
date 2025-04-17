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

    // Implementación del método abstracto
    @Override
    public double calcularSalario() {
        // Puedes modificar esta lógica si deseas
        return getSalarioBase() + 500;
    }

    // Este método NO es abstracto en Empleado, pero puedes definirlo para
    // comportamiento específico
    public void trabajar() {
        System.out.println(getNombre() + " está diseñando usando " + herramientaDiseño);
    }
}