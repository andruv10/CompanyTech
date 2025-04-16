
package Roles;


public class Gerente extends Empleado {
    
    private double bonoGerencial;

    public Gerente( String nombre, int edad, double salarioBase, double bonoGerencial) {
        super(nombre, edad, salarioBase);
        this.bonoGerencial = bonoGerencial;
    }

    public double getBonoGerencial() {
        return bonoGerencial;
    }

    public void setBonoGerencial(double bonoGerencial) {
        this.bonoGerencial = bonoGerencial;
    }
    
     @Override
    public double calcularSalario(){
         return getSalarioBase() + bonoGerencial;
     }
    
    @Override
     public void mostrarDatos(){
         System.out.println("GERENTE");
        super.mostrarDatos();
        System.out.println("Bono Gerencial"+ bonoGerencial);    
}
    
    
    
}
