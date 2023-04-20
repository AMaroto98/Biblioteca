import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Libro> listaLibros = new ArrayList<>();
        ArrayList<Persona> listaDePersonas = new ArrayList<>();

        Biblioteca biblioteca = new Biblioteca("Borja Moll", listaLibros, listaDePersonas);

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean atras = false;
        int opcionPrincipal;
        int opcion;

        while (!salir) {

            // Limpiamos la terminal
            ClearTerminal.clearTerminal();

            System.out.println("------------ Menú ------------");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Gestionar Personas");
            System.out.println("3. Gestionar Reservas");
            System.out.println("5. Salir");
            System.out.println("------------------------------ \n");

            System.out.print("Elige una de las opciones disponibles: ");
            opcionPrincipal = sc.nextInt();
            System.out.println();

            // Restablecer la variable a false en cada caso del switch
            atras = false;

            switch (opcionPrincipal) {

                case 1:

                    while (!atras) {

                        ClearTerminal.clearTerminal();

                        System.out.println("------------ Gestionar Libros ------------");
                        System.out.println("1. Añadir libro");
                        System.out.println("2. Eliminar libro");
                        System.out.println("3. Buscar libro por ISBN");
                        System.out.println("4. Buscar libro por título");
                        System.out.println("5. Mostrar todos los libros");
                        System.out.println("6. Mostrar libros disponibles");
                        System.out.println("7. Atrás");
                        System.out.println("------------------------------------------ \n");

                        System.out.print("Elige una de las opciones disponibles: ");
                        opcion = sc.nextInt();
                        System.out.println();

                        switch (opcion) {

                            case 1:

                                Libro.añadirLibro(listaLibros);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 2:

                                Libro.eliminarLibro(listaLibros);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 3:

                                Libro.buscarLibroISBN(listaLibros);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 4:

                                Libro.buscarLibroTitulo(listaLibros);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 5:

                                biblioteca.mostrarLibros(listaLibros);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 6:

                                biblioteca.mostrarLibrosDisponibles(listaLibros);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 7:

                                atras = true;
                                ClearTerminal.clearTerminal();
                                break;

                            default:
                                break;
                        }
                    }

                    break;

                case 2:

                    while (!atras) {

                        ClearTerminal.clearTerminal();

                        System.out.println("------------ Gestionar Personas ------------");
                        System.out.println("1. Añadir bibliotecario");
                        System.out.println("2. Añadir usuario");
                        System.out.println("3. Mostrar bibliotecarios");
                        System.out.println("4. Mostrar usuarios");
                        System.out.println("5. Eliminar bibliotecario");
                        System.out.println("6. Eliminar usuario");
                        System.out.println("7. Atrás");
                        System.out.println("-------------------------------------------- \n");

                        System.out.print("Elige una de las opciones disponibles: ");
                        opcion = sc.nextInt();
                        System.out.println();

                        switch (opcion) {

                            case 1:

                                Bibliotecario.añadirBibliotecario(listaDePersonas);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 2:

                                Usuario.añadirUsuario(listaDePersonas);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 3:

                                Bibliotecario.mostrarBibliotecarios(listaDePersonas);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 4:

                                Usuario.mostrarUsuarios(listaDePersonas);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 5:

                                Bibliotecario.eliminarBibliotecario(listaDePersonas);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 6:

                                Usuario.eliminarUsuario(listaDePersonas);
                                Sleep.pause(3000);
                                ClearTerminal.clearTerminal();
                                break;

                            case 7:

                                atras = true;
                                ClearTerminal.clearTerminal();
                                break;

                            default:
                                break;
                        }
                    }

                    break;

            } // Switch principal
        } // While principal
        sc.close();
    } // Cierre Main
} // Cierre Clase
