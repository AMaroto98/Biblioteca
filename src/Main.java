import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList< Persona> listaDePersona = new ArrayList<Persona>();


        // creación de una nueva instancia de Usuario
        Usuario usuario = new Usuario("Juan", "Pérez", "García", 30, "555-1234", "Calle 123", "28001");

        Bibliotecario prueba = new Bibliotecario("Pedro", "Pito", "Sexo", 3, "Cum Tributer", "12345678A", "12345678");

        // System.out.println(prueba);
        System.out.println(usuario);

        prueba.solicitarDatosPersona();
        usuario.solicitarDatosPersona();

        // System.out.println(prueba);
        System.out.println(usuario);
        
    }
    
}
