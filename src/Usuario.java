import java.util.ArrayList;

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
        this.listaReserva = new ArrayList<Reserva>();;    
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
        // Llamo al método de la clase padre 
        super.solicitarDatosPersona();

        // Solicito el resto de datos de la clase usuario
        System.out.print("Introduce el número de teléfono: ");
        telefono = Persona.sc.nextLine();

        System.out.print("Introduce la dirección: ");
        direccion = Persona.sc.nextLine();

        System.out.print("Introduce el código postal: ");
        codigoPostal = Persona.sc.nextLine();

        System.out.print("Introduce el correo electrónico: ");
        email = Persona.sc.nextLine();

        // Inicializo la lista de reservas para poder añadir
        listaReserva = new ArrayList<Reserva>();
    }

    public static void añadirUsuario(ArrayList<Persona> listaDePersonas) {

        // Creo un usuario mediante el contructor vacío
        Usuario usuario = new Usuario();

        // Modifico sus datos mediante el método solicitar datos
        usuario.solicitarDatosPersona();

        // Añado el nuevo usuario a la lista de Personas
        listaDePersonas.add(usuario);

        // Aviso de que todo ha ido bien
        System.out.println("Usuario " + usuario.getNombre() + " añadido con éxito");
    }

    public static void mostrarUsuarios(ArrayList<Persona> listaDePersonas) {

        // Itero sobre la lista de personas
        for (Persona persona : listaDePersonas) {
            // Copruebo que el que objeto que itera sea un usuario y no un bibliotecario
            if (persona instanceof Usuario) {
                // Muestro el usuario por pantalla
                System.out.println(persona + "\n");
                
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

        // Solicito datos al usuario
        System.out.print("Introduce el teléfono: ");
        String telefono = Libro.sc.nextLine();

        System.out.print("Introduce el email: ");
        String email = Libro.sc.nextLine();

        // Itero sobre la lista de personas
        for (Persona persona : listaDePersonas) {
            // Compruebo que la persona sea un usuario
            if (persona instanceof Usuario) {
                // Casting
                Usuario usuario = (Usuario) persona;
                // Compruebo que la información sea correcta
                if ((telefono.equals(usuario.getTelefono())) && (email.equals(usuario.getEmail()))) {

                    System.out.println("Teléfono y email correctos");
                    Sleep.pause(2000);
                    System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getPrimerApellido());
                    Sleep.pause(3000);
                    // Devuelvo el usuario que mantendrá la sesión iniciada en el menú principal
                    return usuario;
 
                } else {
                    // Mensaje en el caso de que haya fallos
                    System.out.println("Teléfono o email incorrectos. Intentalo de nuevo...");
                    Sleep.pause(3000);

                }
            }
        }
        // Devuelvo null si ha habido problemas
        return null;
    }


    public void añadirLibroReservado(Reserva reserva) {
        // Añado la reserva a la lista de reserva
        listaReserva.add(reserva);
    }

    public void eliminarLibroReservado(Reserva reserva) {
        // compruebo que la reserva no sea null
        if (reserva != null) {
            // elimino la reserva que entra por parámetro
            listaReserva.remove(reserva);
        } else {
            // si la reserva es null se avisa al usuario
            System.out.println("No hay ninguna reserva con ese ISBN");
        }
    }

    public Reserva buscarReservaPorISBN(String isbn) {
        for (Reserva reserva : listaReserva) {
            if (reserva != null) {
                if (reserva.getLibro().getISBN().equals(isbn)) {
                    return reserva;
                }
            }
        }
        return new Reserva(); 
    }
    

    public void mostrarLibrosReservados() {
        // si la lista de reserva es null o vacio se muestra el siguiente mensaje
        if (listaReserva == null ||listaReserva.size() == 0) {

            System.out.println("No hay reservas hechas");
            return;
        }
        // Itero sobre las reservas
        for (Reserva reserva : listaReserva) {
            // Muestro las reservas
            System.out.println(reserva);
            // Muestro la fecha de devolución del libro 
            reserva.obtenerFechaDevolucion(reserva);
            reserva.mostrarInfoChula();
        }
    }

    public void saludar() {
        System.out.println("Hola, me llamo " + super.getNombre());
    }

    @Override
    public void cambiarContraseña() {
        // SOlicito información al usuario
        System.out.print("Introduce la nueva contraseña: ");
        String contraseña = Libro.sc.nextLine();
        // Mediante el setEmail compruebo que su contraseña sea correcta
        setEmail(contraseña);

        System.out.println("Contraseña cambiada con éxito");
    }

    @Override
    public String toString() {
        // super.ToString() para que aparezca la información de la persona
        return super.toString() + " Teléfono: " + telefono + ", Dirección: " + direccion + ", Codigo Postal: " + codigoPostal + ", Email: " + email + ", Lista de Reserva: " + listaReserva;
    }

}
