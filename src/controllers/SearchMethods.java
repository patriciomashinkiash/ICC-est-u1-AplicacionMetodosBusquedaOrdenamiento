package controllers;

import models.Person;

public class SearchMethods {
    // BUSQUEDA BINARIA POR NOMBRE
    public Person binarySearchByName(Person[] personas, String name) {
        int low = 0, high = personas.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (personas[mid].getName().equalsIgnoreCase(name)) {
                return personas[mid];
            } else if (personas[mid].getName().compareToIgnoreCase(name) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // BUSQUEDA BINARIA POR EDAD
    public Person binarySearchByAge(Person[] personas, int age) {
        int low = 0, high = personas.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (personas[mid].getAge() == age) {
                return personas[mid];
            } else if (personas[mid].getAge() < age) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // VERIFICACION SI EL ARREGLO ESTA ORDENADO POR NOMBRE
    public boolean isSortedByName(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getName().compareToIgnoreCase(personas[i + 1].getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    // VERIFICACION SI EL ARREGLO ESTA ORDENADO POR NOMBRE
    public boolean isSortedByAge(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getAge() > personas[i + 1].getAge()) {
                return false;
            }
        }
        return true;
    }
}
