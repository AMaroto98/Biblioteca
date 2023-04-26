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

        // Condición para que la contraseña que introduce el usuario tenga 8 carácteres de longuitud y no sea null.
        while (contraseña == null || contraseña.length() < 8) {

            System.out.print("Introduce una contraseña con almenos 8 carácteres: ");
            contraseña = Libro.sc.nextLine();
        }

        this.contraseña = contraseña;
    }

    @Override
    public void solicitarDatosPersona() {

        // Utilizo el método solicitador datos de su clase padre
        super.solicitarDatosPersona();

        // Solicito los datos propios de esta clase
        System.out.print("Introduce el puesto de trabajo: ");
        puestoTrabajo = Persona.sc.nextLine();

        // Con el setNIF y setContraseña verifico que los datos que se introducen son correctos
        System.out.print("Introduce el NIF: ");
        nif = Persona.sc.nextLine();
        setNIF(nif);

        System.out.print("Introduce la contraseña: ");
        contraseña = Persona.sc.nextLine();
        setContraseña(contraseña);

    }

    public static void añadirBibliotecario(ArrayList<Persona> listaDePersonas) {

        // Creo un bibliotecario con un constructor vacío
        Bibliotecario bibliotecario = new Bibliotecario();

        // Con el método de solicitarDatos modifico los datos que se habrán preestablecido con el construcor vacio (null...)
        bibliotecario.solicitarDatosPersona();

        // Añado el bibliotecario a la lista de personal de la biblioteca
        listaDePersonas.add(bibliotecario);

        // Mensaje avisando al usuario
        System.out.println("Bibliotecario " + bibliotecario.getNombre() + " añadido con éxito");
    }

    public static void mostrarBibliotecarios(ArrayList<Persona> listaDePersonas) {

        // Recorro toda la lista de persona de la biblioteca
        for (Persona persona : listaDePersonas) {
            // Como la lista es de tipo Persona compruebo que la persona (que es el iterador del
            // bucle) sea instanciado de bibliotecario. Si lo es se imprime, si no se lo salta.
            if (persona instanceof Bibliotecario) {
                System.out.println(persona + "\n");

            }
        }
    }

    public static void eliminarBibliotecario(ArrayList<Persona> listaDePersona) {

        // Se solicita al usuario que introduzca el NIF del bibliotecario 
        System.out.print("Introduce el NIF del bibliotecario que quieres eliminar: ");
        String nif = Libro.sc.nextLine();

        // Iteramos sobre la array de personas
        for (Persona persona : listaDePersona) {
            // Comprobamos que sea bibliotecarios y no usuarios
            if (persona instanceof Bibliotecario) {
                // Se hace casting 
                Bibliotecario bibliotecario = (Bibliotecario) persona;
                // Se compara el NIF
                if (nif.equalsIgnoreCase(bibliotecario.getNif())) {
                    // Se elimina si coincide
                    listaDePersona.remove(bibliotecario);
                    System.out.println("Bibliotecario " + bibliotecario.getNombre() + " ha sido eliminado con éxito");

                } else {
                    // Si no coincide se avisa al usario
                    System.out.println("No hay ningún bibliotecario con el NIF: " + nif);
                }
            }
        }
    }

    public static Bibliotecario iniciarSesion(ArrayList<Persona> listaDePersonas) {

        // Se solicitan los datos para iniciar sesión
        System.out.print("Introduce el NIF del bibliotecario: ");
        String nif = Libro.sc.nextLine();

        System.out.print("Introduce la contraseña: ");
        String contraseña = Libro.sc.nextLine();
        // Iteramos sobre la lista de personas
        for (Persona persona : listaDePersonas) {
            // Se comprueba que sea un bibliotecario
            if (persona instanceof Bibliotecario) {
                // Casting
                Bibliotecario bibliotecario = (Bibliotecario) persona;

                // Se comprueba NIF y contraseña
                if ((nif.equals(bibliotecario.getNif())) && (contraseña.equals(bibliotecario.getContraseña()))) {

                    // Mensajes de que todo ha ido bien
                    System.out.println("NIF y contraseña correctos");
                    Sleep.pause(2000);
                    System.out.println("Bienvenido " + bibliotecario.getNombre() + " " + bibliotecario.getPrimerApellido());
                    Sleep.pause(3000);

                    // Me devuelve el bibliotecario que mantendrá la sesión iniciada
                    return bibliotecario;
 
                } else {
                    // Aviso de algún error de inicio de sesión
                    System.out.println("NIF o contraseña incorrectos. Intentalo de nuevo...");
                    Sleep.pause(3000);

                }
            }
        }
        return null;
    }

    public void reservarLibro(ArrayList<Persona> listaDePersonas, ArrayList<Libro> listaLibros) {

        // Se solicitan los datos al usuario
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

                    // Se comprueba que el usuario no tenga ya 5 libros reservados
                    if (usuario.getListaReserva().size() == 5) {

                        System.out.println("El número máximo de libros reservados a la vez es 5");
                        break;
                        
                    } else {

                        System.out.print("Introduce el ISBN del libro que quieres reservar: ");
                        String isbn = Libro.sc.nextLine();

                        for (Libro libro : listaLibros) {

                            if (isbn.equalsIgnoreCase(libro.getISBN())) {

                                // Se comprueba que el libro este disponible
                                if (libro.isPrestado()) {

                                    System.out.println("Lo siento, el libro ya está reservado");
                                    Sleep.pause(3000);
                                    
                                } else {
                                    // Si esta disponible cambiamos el estado del prestado y creamos una reserva
                                    libro.setPrestado(true);
                                    Reserva reserva = Reserva.crearReserva(libro);
                                    // Añadimos el libro reservado a la lista de reservas del usuario
                                    usuario.añadirLibroReservado(reserva);
                                    // Mensaje avisando de que ha ido bien
                                    System.out.println("Libro reservado con éxito");
                                    Sleep.pause(3000);
                                    
                                }

                            } else {

                                System.out.println("No se ha encontrado ningún libro con el siguiente ISBN: " + isbn);
                                Sleep.pause(3000);
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
        // Se solicitan los datos al usuario
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

                            } else {

                                System.out.println("No se encontrado ninguna reserva con el siguiente ISBN: " + isbn);
                                Sleep.pause(3000);
                            }
                        } else {

                            System.out.println("No hay reservas efectuadas por este usuario");
                            Sleep.pause(3000);
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

        // Se solicita al usuario la nueva contraseña
        System.out.print("Introduce la nueva contraseña: ");
        String nuevaContraseña = Libro.sc.nextLine();
        // Se verifica que la contraseña cumpla las condiciones
        setContraseña(nuevaContraseña);

        System.out.println("Contraseña cambiada con éxito");
    }

    @Override
    public String toString() {
        return "Bibliotecario Puesto de trabajo: " + puestoTrabajo + ", NIF: " + nif + ", Contraseña: " + contraseña;
    }

}
