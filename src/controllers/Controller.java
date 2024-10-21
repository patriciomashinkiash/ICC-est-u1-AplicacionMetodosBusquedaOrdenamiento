package controllers;

import models.Person;
import views.View;

public class Controller {

        private View view;
        private SortingMethods sortingmethods;
        private SearchMethods searchmethods;

        private Person[] personas;

        public Controller(View view,
                        SortingMethods sortingmethods, 
                        SearchMethods searchmethods){
                
            this.view = view;
            this.sortingmethods = sortingmethods;
            this.searchmethods = searchmethods;

            System.out.println("CONTROLADOR CREADO");
                
        }

        public void start(){
            int op=0;
            do{
                op = view.showMenu();
                switch (op) {
                    case 1:
                        inputPerson();
                        break;
                    case 2:
                        addPerson();
                        break;
                    case 3:
                        sortPersons();
                        break;
                    case 100:
                        System.out.println("Adios");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            }while(op !=0);
        }

        public void sortPersons(){
            int sortingOption = view.selectSortingmethod();

            if (sortingOption==1) {
                sortingmethods.sortByNameWithBubble(personas);
                
            }else if(sortingOption==2){
                sortingmethods.sorByNameWithSelection(personas);
            }else{
                view.showMessage("Opcion invalida");
            }
        }

        public void inputPerson(){
            int numPersonas = view.inputInt("Ingrese el numero de personas: ");
            personas = new Person[numPersonas];
            for(int i=0; i<numPersonas;i++){
                personas[i] = view.inputPerson();

            }
        }

        public void addPerson(){
            if(personas == null){
                view.showMessage("No existe, ingrese las personas por primera vez");
                inputPerson();
            }

            int numPersonas = view.inputInt("Ingrese el numero de personas a adicionar: ");

            Person[] personasTotales = new Person[personas.length + numPersonas];

            for(int i=0; i<personas.length;i++){
                personasTotales[i] = personas[i];
            }

            for(int i= personas.length; i<personasTotales.length;i++){
                personasTotales[i] = view.inputPerson();

            }

            personas = personasTotales;
        }
}
