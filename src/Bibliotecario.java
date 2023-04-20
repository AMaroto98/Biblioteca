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
    public Bibliotecario(String nombre, String primerApellido, String segundoApellido, int edad, String puestoTrabajo,
            String nif, String contraseña) {
        super(nombre, primerApellido, segundoApellido, edad);
        this.puestoTrabajo = puestoTrabajo;
        setNIF(nif);
        setContraseña(contraseña);
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

    public void setNIF(String nif) {

        // expresión regular para validar el formato del NIF
        String regex = "^\\d{8}[a-zA-Z]$";

        while (!nif.matches(regex)) {

            System.out.print("Introduce un NIF con 8 números y 1 letra: ");
            nif = Persona.sc.nextLine();

        }

        this.nif = nif;

    }

    public void setContraseña(String contraseña) {

        while (contraseña == null || contraseña.length() < 8) {

            System.out.print("Introduce una contraseña con almenos 8 carácteres: ");
            contraseña = Libro.sc.nextLine();

        }

        this.contraseña = contraseña;
    }

    @Override
    public void solicitarDatosPersona() {

        super.solicitarDatosPersona();

        System.out.print("Introduce el puesto de trabajo: ");
        puestoTrabajo = Persona.sc.nextLine();

        System.out.print("Introduce el NIF: ");
        nif = Persona.sc.nextLine();
        setNIF(nif);

        System.out.print("Introduce la contraseña: ");
        contraseña = Persona.sc.nextLine();
        setContraseña(contraseña);

    }

    @Override
    public String toString() {
        return "Bibliotecario Puesto de trabajo: " + puestoTrabajo + ", NIF: " + nif + ", Contraseña: " + contraseña;
    }

}
