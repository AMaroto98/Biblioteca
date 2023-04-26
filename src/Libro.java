
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Libro {

    // Atributos de la clase
    private String isbn;
    private String titulo;
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
    public Libro(String isbn, String titulo, String autor, String editorial, int nCopias, int nCopiasDisponibles,
            boolean prestado) {

        this.isbn = isbn;
        this.titulo = titulo;
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
        this.titulo = original.titulo;
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

    public String getTitulo() {
        return titulo;
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

    public void settitulo(String titulo) {
        this.titulo = titulo;
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

        System.out.print("Introduce el titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.print("Introduce el autor del libro " + titulo + ": ");
        String autor = sc.nextLine();

        System.out.print("Introduce la editorial del libro " + titulo + ": ");
        String editorial = sc.nextLine();

        int nCopias = 0;
        boolean esNumeroEntero = false;

        while (nCopias <= 0 || !esNumeroEntero) {

            System.out.print("Introduce el número de copias del libro " + titulo + ": ");

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
                // Parche
                sc.nextLine();

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

            // Si el libro está disponible prestado es false.
            if (respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("Si")) {

                prestado = false;
                salir = true;

            // Si no está disponible el libro es true.
            } else if (respuesta.equalsIgnoreCase("N") || respuesta.equalsIgnoreCase("No")) {

                prestado = true;
                salir = true;

            } else {

                System.out.println("Respuesta inválida, por favor introduce S o N");
            }
        }

        // Creamos un nuevo libro con el constructor anterior
        Libro libro = new Libro(isbn, titulo, autor, editorial, nCopias, nCopias, prestado);

        // Añadimos a la lista de libros de la biblioteca del Borja Moll
        listaLibros.add(libro);

        // Mensaje para que el usuario sepa que se ha añadido el libro
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
                System.out.println(libro.getTitulo() + " ha sido eliminado con éxito");
            }
        }
    }

    public static void buscarLibroISBN(List<Libro> listaLibros) {

        // Variable con índice para no encontrado
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

        // Mensaje que se muestra en función de si se ha encontrado el libro o no
        if (indice != -1) {

            System.out.println("El libro se encuentra en la posición " + indice);

        } else {

            System.out.println("No se ha encontrado ningún libro con el ISBN: " + isbn);
        }
    }

    public static Libro buscarLibroTitulo(List<Libro> listaLibros) {

        // Variables que usa el método
        String tituloLibro = "";
        boolean encontrado = false;

        // Esta variable fue añadida a posteriori para poder utilizarla en otros métodos
        Libro libroEncontrado = null;

        System.out.print("Introduce el titulo del libro que quieres buscar: ");
        String titulo = sc.nextLine();

        // Se crea un iterador para la lista
        Iterator<Libro> i = listaLibros.iterator();

        // Bucle para recorrer la lista entera
        while (i.hasNext()) {

            Libro libro = i.next();
            // Si el ISBN que ha introducido el usuario coincide con alguno de la lista de
            // libros lo elimina.
            // Se usa Equals porque un String no es un tipo primitivo y == no funcionaría.
            if (titulo.equalsIgnoreCase(libro.getTitulo())) {

                tituloLibro = libro.getTitulo();
                System.out.println("Se ha encontrado el siguiente libro: " + tituloLibro);
                encontrado = true;
                libroEncontrado = libro;
            }
        }
        // Mensaje en el caso de que no se encuentre el título
        if (!encontrado) {
            System.out.println("No se ha encontrado ningún libro con el siguiente titulo: " + titulo);
        }
        // Return que fue añadido a posteriori para el método añadirLibroCopia
        return libroEncontrado;
    }

    public static void añadirLibroCopia(ArrayList<Libro> listaLibros) {

        // Buscamos el libro y lo almacenamos en una variable de tipo Libro.
        Libro libroOriginal = buscarLibroTitulo(listaLibros);

        // Si no se ha encontrado el libro original, mostramos un mensaje de error y salimos del método
        if (libroOriginal != null) {
            // Pasamos el libro al constructor vacio
            Libro libroCopia = new Libro(libroOriginal);
            // Modiicamos los datos que sean necesarios por el usuario
            libroCopia.modificarDatos();
            // Añadimos la copia a la lista de libros
            listaLibros.add(libroCopia);

            // Mensaje si todo ha ido bien
            System.out.println("Libro copiado añadido con exito");

        } else {
            // Mensaje si ha habido fallos
            System.out.println("No se ha podido añadir el libro");

        }
    }

    public void modificarDatos() {

        // Input que el usuario tiene que introducir
        System.out.println("Datos para modificar: ISBN, titulo, autor, editorial, nCopias, nCopiasDisponibles.");
        System.out.print("Introduce el dato que quieres modificar: ");
        String dato = sc.nextLine();

        // Comprobamos si el dato coincide con alguno de los atributos de los libros
        if (dato.equalsIgnoreCase("isbn")) {

            System.out.print("Introduce el ISBN nuevo: ");
            String isbnNuevo = sc.nextLine();
            this.isbn = isbnNuevo;
            
        } else if (dato.equalsIgnoreCase("título")) {

            System.out.print("Introduce el título nuevo: ");
            String tituloNuevo = sc.nextLine();
            this.titulo = tituloNuevo;
            
        } else if (dato.equalsIgnoreCase("autor")) {

            System.out.print("Introduce el autor nuevo: ");
            String autorNuevo = sc.nextLine();
            this.autor = autorNuevo;
            
        } else if (dato.equalsIgnoreCase("editorial")) {

            System.out.print("Introduce el editorial nuevo: ");
            String editorialNueva = sc.nextLine();
            this.editorial = editorialNueva;
            
        } else if (dato.equalsIgnoreCase("nCopias")) {

            System.out.print("Introduce el número de copias nuevo: ");
            int nCopiasNuevo = sc.nextInt();
            setnCopias(nCopiasNuevo);
            this.nCopias = nCopiasNuevo;
            
        } else if (dato.equalsIgnoreCase("nCopiasDisponibles")) {

            System.out.print("Introduce el número de copias disponibles nuevas: ");
            int nCopiasDisponiblesNueva = sc.nextInt();
            this.nCopiasDisponibles = nCopiasDisponiblesNueva;
            
        } else {
            // Si ha habido algún error avisamos al usuario
            System.out.println("No hay ningún dato con el nombre: " + dato);
        }

    }

    @Override
    public String toString() {
        return "Libro ISBN: " + isbn + ", titulo: " + titulo + ", autor: " + autor + ", editorial:" + editorial
                + ", nCopias: " + nCopias + ", nCopiasDisponibles: " + nCopiasDisponibles + ", prestado: " + prestado;
    }
}