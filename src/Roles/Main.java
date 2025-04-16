
package Roles;


public  class Main {
    
    public static void main(String[] args) {
        
        Desarrollador dev1 = new Desarrollador("Johan", 37, 5000, "Java");
        Gerente gerente1 = new Gerente("Alejandro", 40, 1000, 1000);
        Tester tester1 = new Tester("Xiomara", 34, 500, "senior");
        
        
        dev1.mostrarDatos();
        dev1.calcularSalario();
        gerente1.mostrarDatos();
        gerente1.calcularSalario();
        tester1.mostrarDatos();
        tester1.calcularSalario();
        
    }
    
}
