public class Bibliotecario extends Persona {
    
    // Atributos de la clase
    private String puestoTrabajo;
    private String nif;
    private String contraseña;

    // Constructor vacio
    public Bibliotecario() {
        super();
    }

    // Constructor con todos los parámetros
    public Bibliotecario(String nombre, String primerApellido, String segundoApellido, int edad, String puestoTrabajo, String nif, String contraseña) {
        super(nombre, primerApellido, segundoApellido, edad);
        this.puestoTrabajo = puestoTrabajo;
        this.nif = nif;
        this.contraseña = contraseña;
    }

    // Constructor copia
    public Bibliotecario(Bibliotecario original) {
        super(original.getNombre(), original.getPrimerApellido(), original.getSegundoApellido(), original.getEdad());
        this.puestoTrabajo = original.puestoTrabajo;
        this.nif = original.nif;
        this.contraseña = original.contraseña;
    }

    // Getters
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public String getNif() {
        return nif;
    }

    public String getContraseña() {
        return contraseña;
    }

    // Setters
    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Bibliotecario Puesto de trabajo: " + puestoTrabajo + ", NIF: " + nif + ", Contraseña: " + contraseña;
    }

    

    

    
}
