package views;

import java.util.Scanner;
import models.*;

public class View {

    private Scanner scanner;

    public View(){
        scanner = new Scanner(System.in);
    }
   public int showMenu(){
    System.out.println("Menu");
    System.out.println("1. Ingresa Personas");
    System.out.println("100. Salir");
    System.out.print("Ingrese una opcion: ");
    return scanner.nextInt();
   }
   
   public int inputInt(String message){
    System.out.println(message);
    return scanner.nextInt();
   }

   public Person inputPerson(){
    String name = inputName();
    int age = inputAge();
    return new Person(name, age);
   }

   public String inputName(){
    System.out.print("Ingrese nombre: ");
    return scanner.next();
   }

   public int inputAge(){
       System.out.print("Ingrese edad: ");
       return scanner.nextInt();
    }

    public void showMessage(String message){
        System.out.println("LOG "+message);
    }

    public int selectSortingmethod(){
        System.out.println("Ingrese la condicion a ordenar");
        System.out.println("1. Por nombre");
        System.out.println("2. Por edad");
        System.out.print("Ingrese una opcion: ");
        return scanner.nextInt();
    }
}
