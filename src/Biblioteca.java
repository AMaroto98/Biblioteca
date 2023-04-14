import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

    // Atributos
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> listaPersonal;

    // Constructor vacio
    public Biblioteca() {

    }

    // Constructor con todos los parámetros
    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        setNombre(nombre);
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }

    // Constructor copia
    public Biblioteca(Biblioteca original) {
        this.nombre = original.nombre;
        this.listaLibros = original.listaLibros;
        this.listaPersonal = original.listaPersonal;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }


    // Setters
    public void setNombre(String nombre) {

        // Extraemos la primera letra del nombre y la hacemos mayúscula.
        // Ejemplo con palabra java:
        String primeraLetra = nombre.substring(0, 1).toUpperCase(); // J
        String nombreSinPrimeraLetra = nombre.substring(1); // ava
        String nombreCorrecto = primeraLetra + nombreSinPrimeraLetra; // J + ava

        this.nombre = nombreCorrecto;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    // Métodos
    public void mostrarLibros(ArrayList<Libro> listaLibros) {

        if (listaLibros.size() == 0) {

            System.out.println("No hay librs en la Biblioteca");
            System.out.println("Añade alguno para poder ver sus datos");
            
        }

        Iterator<Libro> i = listaLibros.iterator();

        // Bucle para recorrer la lista entera
        while (i.hasNext()) {

            Libro libro = i.next();
            System.out.println(libro);
            
        } 
        
    }

    public void mostrarLibrosDisponibles(ArrayList<Libro> listaLibros) {

        if (listaLibros.size() == 0) {

            System.out.println("No hay librs en la Biblioteca");
            System.out.println("Añade alguno para poder ver sus datos");
            
        }

        Iterator<Libro> i = listaLibros.iterator();

        // Bucle para recorrer la lista entera
        while (i.hasNext()) {

            Libro libro = i.next();
            
            if (libro.isPrestado() == false) {

                System.out.println(libro);
                
            }

            
        } 

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Lista de Libros: " + listaLibros.size() + ", Lista de Personal: " + listaPersonal.size();
    }

    

    
}