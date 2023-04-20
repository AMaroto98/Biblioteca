import java.util.Scanner;

public abstract class Persona {

    // Atributos de la clase
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int edad;

    public static Scanner sc = new Scanner(System.in);

    // Constructor vacio
    public Persona() {
    }

    // Constructor con todos los parámetros
    public Persona(String nombre, String primerApellido, String segundoApellido, int edad) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        setEdad(edad);
    }

    // Constructor copia
    public Persona(Persona original) {
        this.nombre = original.nombre;
        this.primerApellido = original.primerApellido;
        this.segundoApellido = original.segundoApellido;
        this.edad = original.edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public int getEdad() {
        return edad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setEdad(int edad) {

        while (edad < 1) {

            System.out.print("Introduce una edad válida: ");
            edad = sc.nextInt();
            
        }

        this.edad = edad;
        
        // vacio el buffer
        sc.nextLine();
    }

    public void solicitarDatosPersona() {

        System.out.print("Introduce el nombre: ");
        nombre = sc.nextLine();

        System.out.print("Introduce el primer apellido: ");
        primerApellido = sc.nextLine();

        System.out.print("Introduce el segundo apellido: ");
        segundoApellido = sc.nextLine();

        System.out.print("Introduce la edad: ");
        edad = sc.nextInt();
        setEdad(edad);

        // Vacio el buffer del Scanner
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "Persona Nombre: " + nombre + ", Primer Apellido: " + primerApellido + ", Segundo Apellido: "
                + segundoApellido + ", Edad: " + edad;
    }

}
