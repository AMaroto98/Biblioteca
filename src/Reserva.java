import java.time.LocalDateTime;

public class Reserva implements Material {

    // Atributos de la clase
    private Libro libro;
    private LocalDateTime fechaHora;

    // Constructor vacio
    public Reserva() {
    }

    // Constructor con todos los parámetros
    public Reserva(Libro libro, LocalDateTime fechaHora) {
        this.libro = libro;
        setFechaHora();
    }

    // Constructor Copia
    public Reserva(Reserva original) {
        this.libro = original.libro;
        this.fechaHora = original.fechaHora;
    }

    // Getters
    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    // Setters
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaHora() {
        LocalDateTime ahora = LocalDateTime.now();
        this.fechaHora = LocalDateTime.of(ahora.getYear(), ahora.getMonth(), ahora.getDayOfMonth(), ahora.getHour(), ahora.getMinute());
    }
    

    public static Reserva crearReserva(Libro libro) {
        
        Reserva reserva = new Reserva();
        reserva.setLibro(libro);
        reserva.setFechaHora();
        return reserva;
    }

    @Override
    public void obtenerFechaDevolucion(Reserva reserva) {

        LocalDateTime fechaPrestamo = reserva.getFechaHora();

        // Sumamos a la fecha del día de préstamo 1 mes.
        LocalDateTime fechaDevolucion = fechaPrestamo.plusMonths(1);

        System.out.println("La fecha de devolución es: " + fechaDevolucion);

    }

    @Override
    public void mostrarInfoChula() {

    }

    @Override
    public String toString() {
        return "Reserva libro: " + libro + ", fechaHora: " + fechaHora;
    }
}
