import java.util.ArrayList;

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

    public static void añadirBibliotecario(ArrayList<Persona> listaDePersonas) {

        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.solicitarDatosPersona();
        listaDePersonas.add(bibliotecario);

        System.out.println("Bibliotecario " + bibliotecario.getNombre() + " añadido con éxito");
    }

    public static void mostrarBibliotecarios(ArrayList<Persona> listaDePersonas) {

        for (Persona persona : listaDePersonas) {
            if (persona instanceof Bibliotecario) {
                System.out.println(persona);

            }
        }
    }

    public static void eliminarBibliotecario(ArrayList<Persona> listaDePersona) {

        System.out.print("Introduce el NIF del bibliotecario que quieres eliminar: ");
        String nif = Libro.sc.nextLine();

        for (Persona persona : listaDePersona) {

            if (persona instanceof Bibliotecario) {

                Bibliotecario bibliotecario = (Bibliotecario) persona;

                if (nif.equals(bibliotecario.getNif())) {

                    listaDePersona.remove(bibliotecario);
                    System.out.println("Bibliotecario " + bibliotecario.getNombre() + " ha sido eliminado con éxito");

                } else {

                    System.out.println("No hay ningún bibliotecario con el NIF: " + nif);
                }
            }
        }
    }

    public static Bibliotecario iniciarSesion(ArrayList<Persona> listaDePersonas) {

        System.out.print("Introduce el NIF del bibliotecario: ");
        String nif = Libro.sc.nextLine();

        System.out.print("Introduce la contraseña: ");
        String contraseña = Libro.sc.nextLine();

        for (Persona persona : listaDePersonas) {

            if (persona instanceof Bibliotecario) {

                Bibliotecario bibliotecario = (Bibliotecario) persona;

                if ((nif.equals(bibliotecario.getNif())) && (contraseña.equals(bibliotecario.getContraseña()))) {

                    System.out.println("NIF y contraseña correctos");
                    Sleep.pause(2000);
                    System.out.println("Bienvenido " + bibliotecario.getNombre() + " " + bibliotecario.getPrimerApellido());
                    Sleep.pause(3000);

                    return bibliotecario;
 
                } else {

                    System.out.println("NIF o contraseña incorrectos. Intentalo de nuevo...");
                    Sleep.pause(3000);

                }
            }
        }
        return null;
    }

    public void reservarLibro(ArrayList<Persona> listaDePersonas, ArrayList<Libro> listaLibros) {

        System.out.print("Introduce un teléfono del usuario: ");
        String telefono = Libro.sc.nextLine();

        System.out.print("Introduce el correo electrónico del usuario: ");
        String email = Libro.sc.nextLine();

        for (Persona persona : listaDePersonas) {

            if (persona instanceof Usuario) {

                Usuario usuario = (Usuario) persona;

                if ((telefono.equals(usuario.getTelefono())) && (email.equals(usuario.getEmail()))) {

                    System.out.println("Los datos de usuario " + usuario.getNombre() + " son correctos \n");
                    Sleep.pause(1000);

                    if (usuario.getListaReserva().size() == 5) {

                        System.out.println("El número máximo de libros reservados a la vez es 5");
                        break; //Quitar break;
                        
                    } else {

                        System.out.print("Introduce el ISBN del libro que quieres reservar: ");
                        String isbn = Libro.sc.nextLine();

                        for (Libro libro : listaLibros) {

                            if (isbn.equals(libro.getISBN())) {

                                if (libro.isPrestado()) {

                                    System.out.println("Lo siento, el libro ya está reservado");
                                    Sleep.pause(3000);
                                    
                                } else {

                                    libro.setPrestado(true);
                                    Reserva reserva = Reserva.crearReserva(libro);
                                    usuario.añadirLibroReservado(reserva);
                                    System.out.println("Libro reservado con éxito");
                                    Sleep.pause(3000);
                                    
                                }
                            }
                        }
                    }

                } else {

                    System.out.println("El teléfono o el email son incorrectos. Vuelve a intentarlo...");
                    Sleep.pause(3000);
                }
            }
        }
    }

    public void devolverLibro(ArrayList<Persona> listaDePersonas, ArrayList<Libro> listaLibros) {

        System.out.print("Introduce un teléfono del usuario: ");
        String telefono = Libro.sc.nextLine();

        System.out.print("Introduce el correo electrónico del usuario: ");
        String email = Libro.sc.nextLine();

        for (Persona persona : listaDePersonas) {

            if (persona instanceof Usuario) {

                Usuario usuario = (Usuario) persona;

                if ((telefono.equals(usuario.getTelefono())) && (email.equals(usuario.getEmail()))) {

                    System.out.println("Los datos de usuario " + usuario.getNombre() + " son correctos \n");
                    Sleep.pause(1000);

                    System.out.print("Introduce el ISBN del libro que quieres devolver: ");
                    String isbn = Libro.sc.nextLine();

                    for (Reserva reserva : usuario.getListaReserva()) {

                        if (reserva != null) {

                            if (isbn.equals(reserva.getLibro().getISBN())) {

                                if (reserva.getLibro().isPrestado()) {

                                    reserva.getLibro().setPrestado(false);
                                    usuario.eliminarLibroReservado(usuario.buscarReservaPorISBN(isbn));
                                    System.out.println("Libro devuelto con éxito");
                                    Sleep.pause(3000);
                                    return;
                                    
                                } else {

                                    System.out.println("Lo siento, no se ha podido devolver el libro");
                                    Sleep.pause(3000);
                                    
                                }
                            }
                        }
                    }

                } else {

                    System.out.println("El teléfono o el email son incorrectos. Vuelve a intentarlo...");
                    Sleep.pause(3000);
                }
            }
        }
    }

    @Override
    public void cambiarContraseña() {

        System.out.print("Introduce la nueva contraseña: ");
        String nuevaContraseña = Libro.sc.nextLine();

        setContraseña(nuevaContraseña);

        System.out.println("Contraseña cambiada con éxito");
    }

    @Override
    public String toString() {
        return "Bibliotecario Puesto de trabajo: " + puestoTrabajo + ", NIF: " + nif + ", Contraseña: " + contraseña;
    }

}
