import controllers.*;
import views.View;

public class App {
    public static void main(String[] args) throws Exception {
        
        /// CREAR VISTA
        View vista = new View();

        // Crear las clases con los metodos de ordenamiento y busqueda
        SortingMethods sortingmethods = new SortingMethods();
        SearchMethods searchmethods = new SearchMethods();

        /// CREAR EL CONTROLADOR
        Controller controller = new Controller(vista, sortingmethods, searchmethods);

        
    }
}
