
package Roles;


public class Desarrollador extends Empleado{
    
    private String lenguaje;

    public Desarrollador( String nombre, int edad, double salarioBase, String lenguaje) {
        super(nombre, edad, salarioBase);
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    @Override
    public double calcularSalario(){
         return getSalarioBase() + 1000;
    }
    
    @Override
     public void mostrarDatos(){
         System.out.println("DESARROLLADOR");
        super.mostrarDatos();
        System.out.println("Lenguaje de programacion"+ lenguaje);    
    }
    
    
}
