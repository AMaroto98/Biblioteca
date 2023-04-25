import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // Creo las lista que necesitará el objeto Biblioteca
        ArrayList<Libro> listaLibros = new ArrayList<>();
        ArrayList<Persona> listaDePersonas = new ArrayList<>();

        // Librerias para la hora del Menú
        LocalTime horaActual = LocalTime.now();

        // Añado un bibliotecario para poder Iniciar Sesión la primera vez
        Bibliotecario administrador = new Bibliotecario("Administrador", "Supremo", "Chicote", 35, "Cocinero", "12345678A","12345678");
        listaDePersonas.add((Persona) administrador);

        // Añado un usuario para poder hacer pruebas
        Usuario usuarioPruebas = new Usuario("Antonio", "Maroto", "Blasco", 25, "655303348", "Calle Piruleta", "07011","antonio");
        listaDePersonas.add((Persona) usuarioPruebas);

        Libro libro = new Libro("1", "W", "W", "W", 1, 1, false);
        listaLibros.add(libro);

        // Creo la biblioteca del Borja Moll
        Biblioteca biblioteca = new Biblioteca("Borja Moll", listaLibros, listaDePersonas);

        // Creo Scanner y variables que usaré en el menú principal y anidados
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean atras = false;
        boolean atrasAnidado = false;
        int opcionPrincipal;
        int opcion;

        while (!salir) {

            // Limpiamos la terminal
            ClearTerminal.clearTerminal();

            System.out.println("Hora: " + horaActual.getHour() + ":" + horaActual.getMinute() + "\n");

            System.out.println("------------ Menú Principal ------------");
            System.out.println("1. Iniciar Sesión como Bibliotecario");
            System.out.println("2. Iniciar Sesión como Usuario");
            System.out.println("3. Repositorio Github");
            System.out.println("4. Salir");
            System.out.println("--------------------------------------- \n");

            try {

                System.out.print("Elige una de las opciones disponibles: ");
                opcionPrincipal = sc.nextInt();
                System.out.println();

            } catch (InputMismatchException e) {

                System.out.println("Opción invalida, debes ingresar un número");
                Sleep.pause(2000);
                sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                continue; // volvemos al inicio del loop
            }

            // Restablecer la variable a false en cada caso del switch
            atras = false;

            switch (opcionPrincipal) {

                case 1: // Inicio de sesión como Bibliotecario

                    Bibliotecario bibliotecario = Bibliotecario.iniciarSesion(listaDePersonas);

                    if (bibliotecario != null) {

                        while (!atras) {

                            ClearTerminal.clearTerminal();

                            System.out.println("Sesión iniciada como: " + bibliotecario.getNombre() + " " + bibliotecario.getPrimerApellido());
                            System.out.println("Hora: " + horaActual.getHour() + ":" + horaActual.getMinute() + "\n");

                            System.out.println("-------------- Opciones de " + bibliotecario.getNombre() + " --------------");
                            System.out.println("1. Gestionar libros");
                            System.out.println("2. Gestionar personas");
                            System.out.println("3. Cambiar contraseña");
                            System.out.println("4. Atrás");
                            System.out.println("------------------------------------------------ \n");

                            // Restablecer la variable a false en cada caso del switch
                            atrasAnidado = false;

                            try {

                                System.out.print("Elige una de las opciones disponibles: ");
                                opcion = sc.nextInt();
                                System.out.println();

                            } catch (InputMismatchException e) {

                                System.out.println("Opción invalida, debes ingresar un número");
                                Sleep.pause(2000);
                                sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                                continue; // volvemos al inicio del loop
                            }

                            switch (opcion) {

                                case 1: // Opciones del Bibliotecario - Gestionar libros

                                    while (!atrasAnidado) {

                                        ClearTerminal.clearTerminal();

                                        System.out.println("Sesión iniciada como: " + bibliotecario.getNombre() + " " + bibliotecario.getPrimerApellido());
                                        System.out.println("Hora: " + horaActual.getHour() + ":" + horaActual.getMinute() + "\n");

                                        System.out.println("------------ Gestionar Libros ------------");
                                        System.out.println("1. Añadir libro");
                                        System.out.println("2. Eliminar libro");
                                        System.out.println("3. Buscar libro por ISBN");
                                        System.out.println("4. Buscar libro por título");
                                        System.out.println("5. Mostrar todos los libros");
                                        System.out.println("6. Mostrar libros disponibles");
                                        System.out.println("7. Reservar libro");
                                        System.out.println("8. Devolver libro");
                                        System.out.println("9. Añadir copia de un libro");
                                        System.out.println("0. Atrás");
                                        System.out.println("------------------------------------------ \n");

                                        try {

                                            System.out.print("Elige una de las opciones disponibles: ");
                                            opcion = sc.nextInt();
                                            System.out.println();

                                        } catch (InputMismatchException e) {

                                            System.out.println("Opción invalida, debes ingresar un número");
                                            Sleep.pause(2000);
                                            sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                                            continue; // volvemos al inicio del loop
                                        }

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

                                                bibliotecario.reservarLibro(listaDePersonas, listaLibros);
                                                Sleep.pause(3000);
                                                ClearTerminal.clearTerminal();
                                                break;

                                            case 8:

                                                bibliotecario.devolverLibro(listaDePersonas, listaLibros);
                                                Sleep.pause(3000);
                                                ClearTerminal.clearTerminal();
                                                break;

                                            case 9:

                                                Libro.añadirLibroCopia(listaLibros);
                                                Sleep.pause(3000);
                                                ClearTerminal.clearTerminal();

                                            case 0:

                                                atrasAnidado = true;
                                                ClearTerminal.clearTerminal();
                                                break;

                                            default:

                                                System.out.println("Opción invalida, vuelve a intentarlo");
                                                Sleep.pause(3000);
                                                break;
                                        }
                                    }

                                    break; // Break Case 1 - Opciones Bibliotecario

                                case 2: // Opciones del bibliotecario - Gestionar Personas

                                    while (!atrasAnidado) {

                                        ClearTerminal.clearTerminal();

                                        System.out.println("Sesión iniciada como: " + bibliotecario.getNombre() + " " + bibliotecario.getPrimerApellido());
                                        System.out.println("Hora: " + horaActual.getHour() + ":" + horaActual.getMinute() + "\n");

                                        System.out.println("------------ Gestionar Personas ------------");
                                        System.out.println("1. Añadir bibliotecario");
                                        System.out.println("2. Añadir usuario");
                                        System.out.println("3. Mostrar bibliotecarios");
                                        System.out.println("4. Mostrar usuarios");
                                        System.out.println("5. Eliminar bibliotecario");
                                        System.out.println("6. Eliminar usuario");
                                        System.out.println("7. Atrás");
                                        System.out.println("-------------------------------------------- \n");

                                        try {

                                            System.out.print("Elige una de las opciones disponibles: ");
                                            opcion = sc.nextInt();
                                            System.out.println();

                                        } catch (InputMismatchException e) {

                                            System.out.println("Opción invalida, debes ingresar un número");
                                            Sleep.pause(2000);
                                            sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                                            continue; // volvemos al inicio del loop
                                        }

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

                                                atrasAnidado = true;
                                                ClearTerminal.clearTerminal();
                                                break;

                                            default:

                                                System.out.println("Opción invalida, vuelve a intentarlo");
                                                Sleep.pause(3000);
                                                break;
                                        }
                                    }

                                    break; // Break Case 2 - Opciones del Bibliotecario
                                
                                case 3: 

                                    bibliotecario.cambiarContraseña();
                                    Sleep.pause(3000);
                                    ClearTerminal.clearTerminal();
                                    break;

                                case 4:

                                    atras = true;
                                    ClearTerminal.clearTerminal();
                                    break;

                                default:

                                    System.out.println("Opción invalida, vuelve a intentarlo");
                                    Sleep.pause(3000);
                                    break;
                            }
                        }

                        break;

                    } else {

                        System.out.println("Error de inicio de sesión");
                        ClearTerminal.clearTerminal();
                        break;
                    }

                case 2: // Inicio de sesión como Usuario

                    Usuario usuario = Usuario.iniciarSesion(listaDePersonas);

                    if (usuario != null) {

                        while (!atras) {

                            ClearTerminal.clearTerminal();

                            System.out.println("Sesión iniciada como: " + usuario.getNombre() + " " + usuario.getPrimerApellido());
                            System.out.println("Hora: " + horaActual.getHour() + ":" + horaActual.getMinute() + "\n");

                            System.out.println("------------ Opciones de " + usuario.getNombre() + " ----------");
                            System.out.println("1. Saludar");
                            System.out.println("2. Mostrar libros reservados");
                            System.out.println("3. Cambiar contraseña");
                            System.out.println("4. Atrás");
                            System.out.println("------------------------------------------- \n");

                            try {

                                System.out.print("Elige una de las opciones disponibles: ");
                                opcion = sc.nextInt();
                                System.out.println();

                            } catch (InputMismatchException e) {

                                System.out.println("Opción invalida, debes ingresar un número");
                                Sleep.pause(2000);
                                sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                                continue; // volvemos al inicio del loop
                            }

                            switch (opcion) {

                                case 1:

                                    usuario.saludar();
                                    Sleep.pause(3000);
                                    ClearTerminal.clearTerminal();
                                    break;

                                case 2:

                                    usuario.mostrarLibrosReservados();
                                    Sleep.pause(8000);
                                    ClearTerminal.clearTerminal();
                                    break;
                                
                                case 3:

                                    usuario.cambiarContraseña();
                                    Sleep.pause(3000);
                                    ClearTerminal.clearTerminal();
                                    break;

                                case 4:

                                    atras = true;
                                    ClearTerminal.clearTerminal();
                                    break;

                                default:

                                    System.out.println("Opción invalida, vuelve a intentarlo");
                                    break;
                            }
                        }

                        break;

                    } else {

                        System.out.println("Error de inicio de sesión");
                        ClearTerminal.clearTerminal();
                        break;
                    }

                case 3:

                    Repositorio.abrirRepositorio();
                    Sleep.pause(3000);
                    ClearTerminal.clearTerminal();
                    break;

                case 4:

                    salir = true;
                    break;

                default: // Default principal
                    System.out.println("Opción invalida, vuelve a intentarlo");
                    Sleep.pause(3000);
                    break;

            } // Cierre del Switch principal
        } // Cierre del While Principal
        sc.close();
    } // Cierre del Main
} // Cierre Clase
