package views;

import java.util.Scanner;
import models.Person;

public class View {

    private Scanner scanner;

    public View(){
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        int option = -1;
        while (option == -1) {
            System.out.println("\nMenu");
            System.out.println("1. Ingresar personas");
            System.out.println("2. Añadir personas");
            System.out.println("3. Ordenar personas");
            System.out.println("4. Buscar persona");
            System.out.println("100. Salir");
            System.out.print("Ingrese una opción: ");
            
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 0 || (option > 4 && option != 100)) {
                    System.out.println("Error: Opcion no valida.");
                    option = -1;
                }
            } else {
                System.out.println("Error: Debe ingresar un numero valido");
                scanner.next();
            }
        }
        return option;
    }
   
    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    public int selectSortingmethod() {
        int method = -1;
        while (method == -1) {
            System.out.println("\nSeleccione metodo de ordenamiento:");
            System.out.println("1. Por nombre (Burbuja)");
            System.out.println("2. Por nombre descendente (Seleccion)");
            System.out.println("3. Por edad (Insercion)");
            System.out.println("4. Por nombre (Insercin)");
            System.out.print("Ingrese una opcion: ");
            
            if (scanner.hasNextInt()) {
                method = scanner.nextInt();
                if (method < 1 || method > 4) {
                    System.out.println("Error: Opcion no valida");
                    method = -1;
                }
            } else {
                System.out.println("Error: Debe ingresar un numero valido.");
                scanner.next();
            }
        }
        return method;
    }

    public int selectSearchCriterion() {
        int criterion = -1;
        while (criterion == -1) {
            System.out.println("\nSeleccione criterio de busqueda:");
            System.out.println("1. Por nombre");
            System.out.println("2. Por edad");
            System.out.print("Ingrese una opción: ");
            
            if (scanner.hasNextInt()) {
                criterion = scanner.nextInt();
                if (criterion < 1 || criterion > 2) {
                    System.out.println("Error: Opcion no valida.");
                    criterion = -1;
                }
            } else {
                System.out.println("Error: Debe ingresar un numero valido.");
                scanner.next();
            }
        }
        return criterion;
    }

    public void displayPersons(Person[] personas) {
        System.out.println("\nLista de Personas:");
        for (Person persona : personas) {
            System.out.println(persona);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputInt(String message){
        System.out.println(message);
        return scanner.nextInt();
       }

    public int inputCantPerson() {
        int numPersons;
        while (true) {
            System.out.print("Ingrese la cantidad de personas: ");
            if (scanner.hasNextInt()) {
                numPersons = scanner.nextInt();
                if (numPersons > 0) {
                    break;
                } else {
                    System.out.println("Error: La cantidad de personas debe ser un numero positivo.");
                }
            } else {
                System.out.println("Error: Debe ingresar un numero valido.");
                scanner.next();
            }
        }
        return numPersons;
    }

    public int inputAge() {
        int age;
        while (true) {
            System.out.print("Ingrese la edad: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age > 0) {
                    break;
                } else {
                    System.out.println("Error: La edad debe ser un numero positivo. Intente de nuevo.");
                }
            } else {
                System.out.println("Error: Debe ingresar un numero válido.");
                scanner.next();
            }
        }
        return age;
    }
    
    public String inputName() {
        System.out.print("Ingrese el nombre: ");
        return scanner.next();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    
}
