
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Libro {

    // Atributos de la clase
    private String isbn;
    private String título;
    private String autor;
    private String editorial;
    private int nCopias;
    private int nCopiasDisponibles;
    private boolean prestado;

    // Contador común en todos los libros
    private static int contadorLibros = 0;

    // Variable constante para el mínimo número de libros
    private static final int NUMERO_MINIMO = 1;

    // Scanner común para todas las clases
    static Scanner sc = new Scanner(System.in);

    // "^\\d{13}$" ---> Regex para verificar en un futuro los ISBN de los libros

    // Constructor vacío
    public Libro() {
        // Se añade el contador para que aumente el número de libros.
        contadorLibros++;
    }

    // Constructor con todos los atributos
    public Libro(String isbn, String título, String autor, String editorial, int nCopias, int nCopiasDisponibles,
            boolean prestado) {

        this.isbn = isbn;
        this.título = título;
        this.autor = autor;
        this.editorial = editorial;
        setnCopias(nCopiasDisponibles);
        this.nCopiasDisponibles = nCopiasDisponibles;
        this.prestado = prestado;
        contadorLibros++;
    }

    // Constructor copia
    public Libro(Libro original) {

        this.isbn = original.isbn;
        this.título = original.título;
        this.autor = original.autor;
        this.editorial = original.editorial;
        this.nCopias = original.nCopias;
        this.nCopiasDisponibles = original.nCopiasDisponibles;
        contadorLibros++;
    }

    // Getters
    public String getISBN() {
        return isbn;
    }

    public String getTítulo() {
        return título;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getnCopias() {
        return nCopias;
    }

    public int getnCopiasDisponibles() {
        return nCopiasDisponibles;
    }

    public static int getContadorLibros() {
        return contadorLibros;
    }

    public boolean isPrestado() {
        return prestado;
    }

    // Setters
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setnCopias(int nCopias) {

        // Control para que el número de copias inicial nunca sea menor que 1
        if (nCopias < 1) {
            nCopias = NUMERO_MINIMO;
        }

        this.nCopias = nCopias;
    }

    public void setnCopiasDisponibles(int nCopiasDisponibles) {
        this.nCopiasDisponibles = nCopiasDisponibles;
    }

    public static void setContadorLibros(int contadorLibros) {
        Libro.contadorLibros = contadorLibros;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    // Métodos
    public static void añadirLibro(List<Libro> listaLibros) {

        // Solicitamos todos los datos del libro al usuario
        System.out.print("Introduce el ISBN del libro: ");
        String isbn = sc.nextLine();

        System.out.print("Introduce el título del libro: ");
        String título = sc.nextLine();

        System.out.print("Introduce el autor del libro " + título + ": ");
        String autor = sc.nextLine();

        System.out.print("Introduce la editorial del libro " + título + ": ");
        String editorial = sc.nextLine();

        int nCopias = 0;
        boolean esNumeroEntero = false;

        while (nCopias <= 0 || !esNumeroEntero) {

            System.out.print("Introduce el número de copias del libro " + título + ": ");

            try {

                nCopias = sc.nextInt();

                // Vacio el buffer del Scanner porque cambiamos de un Int a un String
                sc.nextLine();
                esNumeroEntero = true;

                if (nCopias <= 0) {
                    System.out.println("Por favor introduce un número valido mayor que cero");
                }

            } catch (InputMismatchException e) {

                System.out.println("Por favor introduce un número entero valido");

            }
        }

        // Variable prestado inicializado a false, doy por hecho que los libros que
        // añadimos no han sido prestados.
        boolean prestado = false;

        // Variable para salir del bucle cuando se introduce una respuesta correcta.
        boolean salir = false;

        while (!salir) {

            System.out.print("¿El libro que vas a añadir está disponible? (S/N) ");
            String respuesta = sc.nextLine();

            if (respuesta.equals("S") || respuesta.equals("s") || respuesta.equals("Si") || respuesta.equals("SI")) {

                prestado = false;
                salir = true;

            } else if (respuesta.equals("N") || respuesta.equals("n") || respuesta.equals("No")
                    || respuesta.equals("NO")) {

                prestado = true;
                salir = true;

            } else {

                System.out.println("Respuesta inválida, por favor introduce S o N");
            }
        }

        // Creamos un nuevo libro con el constructor anterior
        Libro libro = new Libro(isbn, título, autor, editorial, nCopias, nCopias, prestado);

        // Añadimos a la lista de libros el libro que hemos creado
        listaLibros.add(libro);

        System.out.println("Libro añadido con éxito");

    }

    public static void eliminarLibro(List<Libro> listaLibros) {

        // Solicitamos el ISBN del libro al usuario
        System.out.print("Introduce el ISBN del libro que quieres eliminar: ");
        String isbn = sc.nextLine();

        // Se crea un iterador para la lista
        Iterator<Libro> i = listaLibros.iterator();

        // Bucle para recorrer la lista entera
        while (i.hasNext()) {

            Libro libro = i.next();
            // Si el ISBN que ha introducido el usuario coincide con alguno de la lista de
            // libros lo elimina.
            // Se usa Equals porque un String no es un tipo primitivo y == no funcionaría.
            if (isbn.equals(libro.getISBN())) {
                i.remove();
                System.out.println(libro.getTítulo() + " ha sido eliminado con éxito");
            }
        }
    }

    public static void buscarLibroISBN(List<Libro> listaLibros) {

        int indice = -1;

        System.out.print("Introduce el ISBN del libro que quieres bucar: ");
        String isbn = sc.nextLine();

        // Se crea un iterador para la lista
        Iterator<Libro> i = listaLibros.iterator();

        // Bucle para recorrer la lista entera
        while (i.hasNext()) {

            Libro libro = i.next();
            // Si el ISBN que ha introducido el usuario coincide con alguno de la lista de
            // libros lo elimina.
            // Se usa Equals porque un String no es un tipo primitivo y == no funcionaría.
            if (isbn.equals(libro.getISBN())) {

                indice = listaLibros.indexOf(libro);

            }
        }

        if (indice != -1) {

            System.out.println("El libro se encuentra en la posición " + indice);

        } else {

            System.out.println("No se ha encontrado ningún libro con el ISBN: " + isbn);
        }
    }

    public static void buscarLibroTitulo(List<Libro> listaLibros) {

        String tituloLibro = "";

        System.out.print("Introduce el título del libro que quieres buscar: ");
        String titulo = sc.nextLine();

        // Se crea un iterador para la lista
        Iterator<Libro> i = listaLibros.iterator();

        // Bucle para recorrer la lista entera
        while (i.hasNext()) {

            Libro libro = i.next();
            // Si el ISBN que ha introducido el usuario coincide con alguno de la lista de
            // libros lo elimina.
            // Se usa Equals porque un String no es un tipo primitivo y == no funcionaría.
            if (titulo.equals(libro.getTítulo())) {

                tituloLibro = libro.getTítulo();
                System.out.println("Se ha encontrado el siguiente libro: " + tituloLibro);
            }
        }

    }

    @Override
    public String toString() {
        return "Libro ISBN: " + isbn + ", título: " + título + ", autor: " + autor + ", editorial:" + editorial
                + ", nCopias: " + nCopias + ", nCopiasDisponibles: " + nCopiasDisponibles + ", prestado: " + prestado;
    }
}