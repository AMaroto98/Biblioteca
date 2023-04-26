public class Sleep {

    // Método para pausar ejecuciones en el programa durante x milisegundos
    // Los milisegundos es el parametro que entra
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}
