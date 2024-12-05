package controllers;

import models.Person;

public class SortingMethods {
    // METODO DE ORDENAMIENTO - BUBUJA POR NOMBRE
    public void sortByNameWithBubble(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - i - 1; j++) {
                if (personas[j].getName().compareToIgnoreCase(personas[j + 1].getName()) > 0) {
                    Person temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    // METODO DE ORDENAMIENTO - SELECCION DESENDENTE POR NOMBRE
    public void sortByNameWithSelectionDes(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < personas.length; j++) {
                if (personas[j].getName().compareToIgnoreCase(personas[maxIdx].getName()) > 0) {
                    maxIdx = j;
                }
            }
            Person temp = personas[maxIdx];
            personas[maxIdx] = personas[i];
            personas[i] = temp;
        }
    }

    // METODO DE ORDENAMIENTO - INSERCION POR EDAD
    public void sortByAgeWithInsertion(Person[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Person key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getAge() > key.getAge()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }

    // METODO DE ORDENAMIENTO - INSERCION POR NOMBRE
    public void sortByNameWithInsertion(Person[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Person key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }
}
