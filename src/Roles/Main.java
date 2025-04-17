package Roles;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Proyecto> proyectos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);    
    
    
    public static void main(String[] args) {
            
        System.out.print("Ingrese el nombre de la empresa tecnológica: ");
        String nombreEmpresa = scanner.nextLine();
        EmpresaTecnologica empresa = new EmpresaTecnologica(nombreEmpresa);
        
        System.out.println("¿Desea cargar datos de prueba? (s/n)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            inicializarDatosPrueba(empresa);
        }        
        
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n=== SISTEMA DE GESTIÓN - " + empresa.getNombreEmpresa().toUpperCase() + " ===");
            System.out.println("1. Gestionar Empleados");
            System.out.println("2. Gestionar Proyectos");
            System.out.println("3. Asignar Empleados a Proyectos");
            System.out.println("4. Mostrar Reportes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    menuEmpleados(empresa);
                    break;
                case 2:
                    menuProyectos(empresa);
                    break;
                case 3:
                    menuAsignaciones(empresa);
                    break;
                case 4:
                    menuReportes(empresa);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        System.out.println("Sistema cerrado. ¡Hasta pronto!");
        scanner.close();
    }
    
    public static void inicializarDatosPrueba(EmpresaTecnologica empresa) {
        empresa.agregarEmpleado(new Desarrollador("Laura Martínez", 28, 4000, "Java"));
        empresa.agregarEmpleado(new Diseñador("Carlos Sánchez", 32, 3500, "Figma"));
        empresa.agregarEmpleado(new Gerente("Ana Rodríguez", 45, 6000, 2000));

        System.out.println("Datos de prueba inicializados correctamente:");
    }

    private static void menuEmpleados(EmpresaTecnologica empresa) {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
            System.out.println("1. Contratar Desarrollador");
            System.out.println("2. Contratar Diseñador");
            System.out.println("3. Contratar Gerente");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    contratarDesarrollador(empresa);
                    break;
                case 2:
                    contratarDiseñador(empresa);
                    break;
                case 3:
                    contratarGerente(empresa);
                    break;
                case 4:
                    empresa.mostrarEmpleados();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
   private static void contratarDiseñador(EmpresaTecnologica empresa) {
        System.out.println("\n=== CONTRATAR DISEÑADOR ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Salario Base: ");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Lenguaje de diseño: ");
        String herramientaDiseño = scanner.nextLine();

        empresa.agregarEmpleado(new Diseñador(nombre, edad, salarioBase, herramientaDiseño));
        System.out.println("Diseñador contratado exitosamente!");
    }    

    private static void contratarDesarrollador(EmpresaTecnologica empresa) {
        System.out.println("\n=== CONTRATAR DESARROLLADOR ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Salario Base: ");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Lenguaje de programación: ");
        String lenguaje = scanner.nextLine();
        
        empresa.agregarEmpleado(new Desarrollador(nombre, edad, salarioBase, lenguaje));
        System.out.println("Desarrollador contratado exitosamente!");
    }

    private static void contratarGerente(EmpresaTecnologica empresa) {
        System.out.println("\n=== CONTRATAR GERENTE ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Salario Base: ");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Bono Gerencial: ");
        double bonoGerencial = scanner.nextDouble();
        scanner.nextLine();

        empresa.agregarEmpleado(new Gerente(nombre, edad, salarioBase, bonoGerencial));
        System.out.println("Gerente contratado exitosamente!");
    }    
    

    private static void menuProyectos(EmpresaTecnologica empresa) {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== GESTIÓN DE PROYECTOS ===");
            System.out.println("1. Crear Proyecto");
            System.out.println("2. Listar Proyectos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("\nNombre del nuevo proyecto: ");
                    String nombreProyecto = scanner.nextLine();
                    empresa.crearProyecto(nombreProyecto);
                    System.out.println("Proyecto creado exitosamente!");
                    break;
                case 2:
                    empresa.mostrarProyectos();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuAsignaciones(EmpresaTecnologica empresa) {
        if (empresa.getEmpleados().isEmpty() || empresa.getProyectos().isEmpty()) {
            System.out.println("Debe haber al menos un empleado y un proyecto registrado.");
            return;
        }
        
        System.out.println("\n=== ASIGNAR EMPLEADOS A PROYECTOS ===");
        System.out.println("Empleados disponibles:");
        ArrayList<Empleado> empleados = empresa.getEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " + empleados.get(i).getNombre());
        }
        System.out.print("Seleccione empleado: ");
        int empIndex = scanner.nextInt() - 1;
        
        System.out.println("\nProyectos disponibles:");
        ArrayList<Proyecto> proyectos = empresa.getProyectos();
        for (int i = 0; i < proyectos.size(); i++) {
            System.out.println((i + 1) + ". " + proyectos.get(i).getNombre());
        }
        System.out.print("Seleccione proyecto: ");
        int proyIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        empresa.asignarEmpleadoAProyecto(empIndex, proyIndex);
        System.out.println("Asignación realizada exitosamente!");
    }

    private static void menuReportes(EmpresaTecnologica empresa) {
        System.out.println("\n=== REPORTES ===");
        empresa.mostrarEmpleados();
        empresa.mostrarProyectos();
    }
}