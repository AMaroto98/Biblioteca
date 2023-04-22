import java.util.ArrayList;
import java.util.Arrays;

public class Usuario extends Persona {

    // Atributos de la clase
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private String email;
    private ArrayList<Reserva> listaReserva;

    // Constructor vacio
    public Usuario() {
        // Se llama al constructor vacio de Persona
        super();
    }

    // Constructor con todos los parámetros
    public Usuario(String nombre, String primerApellido, String segundoApellido, int edad, String telefono, String direccion, String codigoPostal, String email) {
        super(nombre, primerApellido, segundoApellido, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.listaReserva = new ArrayList<>(Arrays.asList(new Reserva[1]));    
    }

    // Constructor copia
    public Usuario(Usuario original) {
        super(original.getNombre(), original.getPrimerApellido(), original.getSegundoApellido(), original.getEdad());
        this.telefono = original.telefono;
        this.direccion = original.direccion;
        this.codigoPostal = original.codigoPostal;
        this.email = original.email;
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

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    @Override
    public void solicitarDatosPersona() {

        super.solicitarDatosPersona();

        System.out.print("Introduce el número de teléfono: ");
        telefono = Persona.sc.nextLine();

        System.out.print("Introduce la dirección: ");
        direccion = Persona.sc.nextLine();

        System.out.print("Introduce el código postal: ");
        codigoPostal = Persona.sc.nextLine();

        System.out.print("Introduce el correo electrónico: ");
        email = Persona.sc.nextLine();

    }

    public static void añadirUsuario(ArrayList<Persona> listaDePersonas) {

        Usuario usuario = new Usuario();
        usuario.solicitarDatosPersona();
        listaDePersonas.add(usuario);

        System.out.println("Usuario " + usuario.getNombre() + " añadido con éxito");
    }

    public static void mostrarUsuarios(ArrayList<Persona> listaDePersonas) {

        for (Persona persona : listaDePersonas) {
            if (persona instanceof Usuario) {
                System.out.println(persona);
                
            }
        }
    }

    public static void eliminarUsuario(ArrayList<Persona> listaDePersona) {

        System.out.print("Introduce el teléfono del usuario que quieres eliminar: ");
        String telefono = Libro.sc.nextLine();

        for (Persona persona : listaDePersona) {

            if (persona instanceof Usuario) {

                Usuario usuario = (Usuario) persona;

                if (telefono.equals(usuario.getTelefono())) {

                    listaDePersona.remove(usuario);
                    System.out.println("Usuario " + usuario.getNombre() + " ha sido eliminado con éxito");
                    
                } else {
                    
                    System.out.println("No hay ningún usuario con el teléfono: " + telefono);
                }
            }
        }
    }

    public static Usuario iniciarSesion(ArrayList<Persona> listaDePersonas) {

        System.out.print("Introduce el teléfono: ");
        String telefono = Libro.sc.nextLine();

        System.out.print("Introduce el email: ");
        String email = Libro.sc.nextLine();

        for (Persona persona : listaDePersonas) {

            if (persona instanceof Usuario) {

                Usuario usuario = (Usuario) persona;

                if ((telefono.equals(usuario.getTelefono())) && (email.equals(usuario.getEmail()))) {

                    System.out.println("Teléfono y email correctos");
                    Sleep.pause(2000);
                    System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getPrimerApellido());
                    Sleep.pause(3000);

                    return usuario;
 
                } else {

                    System.out.println("Teléfono o email incorrectos. Intentalo de nuevo...");

                }
            }
        }
        return null;
    }


    public void añadirLibroReservado(Reserva reserva) {

        listaReserva.add(reserva);

    }

    public void saludar() {
        System.out.println("Hola, vuelve por donde has venido");
    }

    @Override
    public String toString() {
        // super.ToString() para que aparezca la información de la persona
        return super.toString() + " Teléfono: " + telefono + ", Dirección: " + direccion + ", Codigo Postal: " + codigoPostal + ", Email: " + email + ", Lista de Reserva: " + listaReserva;
    }

}
