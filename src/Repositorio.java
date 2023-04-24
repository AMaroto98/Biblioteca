import java.awt.Desktop;
import java.net.URI;

public class Repositorio {
    
    public static void abrirRepositorio() {
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/AMaroto98/BibliotecaV2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
