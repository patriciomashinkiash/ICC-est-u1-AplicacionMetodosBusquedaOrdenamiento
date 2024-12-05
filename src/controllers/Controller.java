package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private Person[] personas;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods){
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;             
    }

    public void start() {
        int op = 0;
        do {
            op = view.showMenu();
            switch (op) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    addPersons();
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 100:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (op != 100);
    }

    public void inputPersons() {
        int numPersons = view.inputCantPerson();

        if (numPersons <= 0) {
            System.out.println("Error: No puede ingresar un numero negativo o cero de personas.");
            return;
        }

        personas = new Person[numPersons];
        for (int i = 0; i < numPersons; i++) {
            personas[i] = view.inputPerson();
        }
    }

    public void addPersons() {
        if (personas == null) {
            System.out.println("Primero debe ingresar personas.");
            return;
        }
        
        int numToAdd = view.inputCantPerson();
        Person[] newPersonas = new Person[personas.length + numToAdd];
        System.arraycopy(personas, 0, newPersonas, 0, personas.length);

        for (int i = personas.length; i < newPersonas.length; i++) {
            newPersonas[i] = view.inputPerson();
        }
        personas = newPersonas;
    }

    public void sortPersons() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No puede ordenar sin ingresar personas primero.");
            return;
        }

        int method = view.selectSortingmethod();
        switch (method) {
            case 1:
                sortingMethods.sortByNameWithBubble(personas);
                break;
            case 2:
                sortingMethods.sortByNameWithSelectionDes(personas);
                break;
            case 3:
                sortingMethods.sortByAgeWithInsertion(personas);
                break;
            case 4:
                sortingMethods.sortByNameWithInsertion(personas);
                break;
            default:
                System.out.println("Metodo no valido.");
        }
        view.displayPersons(personas);
    }

    public void searchPerson() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No puede buscar sin ingresar personas primero.");
            return;
        }

        int criterion = view.selectSearchCriterion();
        if (criterion == 1) {
            String name = view.inputName();
            view.displaySearchResult(searchMethods.binarySearchByName(personas, name));
        } else if (criterion == 2) {
            int age = view.inputAge();
            view.displaySearchResult(searchMethods.binarySearchByAge(personas, age));
        } else {
            System.out.println("Criterio no valido.");
        }
    }
}
