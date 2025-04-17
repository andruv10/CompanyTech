
package Roles;


public class Tester extends Empleado{
    
    private String nivelCert;

    public Tester( String nombre, int edad, double salarioBase, String nivelCert) {
        super(nombre, edad, salarioBase);
        this.nivelCert = nivelCert;
    }

    public String getNivelCert() {
        return nivelCert;
    }

    public void setNivelCert(String nivelCert) {
        this.nivelCert = nivelCert;
    }
    
     @Override
    public double calcularSalario(){
        double extra = 0;
        
        switch(nivelCert.toLowerCase()){
            case "junior":
                extra = getSalarioBase() * 0.05;
                break;
            case "semisenior":
                extra = getSalarioBase() * 0.10;
                break;
            case "senior":
                extra = getSalarioBase() * 0.15;
                break;
            default:
                System.out.println("nivel no valido");
            
        }
        
        return getSalarioBase() + extra;
     }
    
    @Override
     public void mostrarDatos(){
         System.out.println("TESTER");
        super.mostrarDatos();
        System.out.println("Nivel de certificacion"+ nivelCert);    
    }

    @Override
    public String trabajar() {
        return getNombre() + " está completando los test unitarios del actual proyecto";
    }
    
    
    
}
