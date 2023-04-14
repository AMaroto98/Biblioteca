public class Persona {

    // Atributos de la clase
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int edad;

    // Constructor vacio
    public Persona() {
    }

    // Constructor con todos los parámetros
    public Persona(String nombre, String primerApellido, String segundoApellido, int edad) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
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
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona Nombre: " + nombre + ", Primer Apellido: " + primerApellido + ", Segundo Apellido: "
                + segundoApellido + ", Edad: " + edad;
    }

}
