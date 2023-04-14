import java.util.ArrayList;

public class Usuario extends Persona {

    // Atributos de la clase
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private ArrayList<Reserva> listaReserva;

    // Constructor vacio
    public Usuario() {
        // Se llama al constructor vacio de Persona
        super();
    }

    // Constructor con todos los parámetros
    public Usuario(String nombre, String primerApellido, String segundoApellido, int edad, String telefono,
            String direccion, String codigoPostal, ArrayList<Reserva> listaReserva) {
        super(nombre, primerApellido, segundoApellido, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.listaReserva = new ArrayList<>(listaReserva);
    }

    // Constructor copia
    public Usuario(Usuario original) {
        super(original.getNombre(), original.getPrimerApellido(), original.getSegundoApellido(), original.getEdad());
        this.telefono = original.telefono;
        this.direccion = original.direccion;
        this.codigoPostal = original.codigoPostal;
        this.listaReserva = new ArrayList<>(original.listaReserva);
    }

    // Getters
    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    // Setters
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    @Override
    public String toString() {
        // super.ToString() para que aparezca la información de la persona
        return super.toString() + "Teléfono: " + telefono + ", Dirección: " + direccion + ", Codigo Postal: "
                + codigoPostal + ", Lista de Reserva: " + listaReserva;
    }

}
