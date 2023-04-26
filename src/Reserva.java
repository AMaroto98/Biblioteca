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
        // Creo una reserva mediante el contructor vacio
        Reserva reserva = new Reserva();
        // Setteo sus valores con el libro que el usuario quiere reservar y la hora actual
        reserva.setLibro(libro);
        reserva.setFechaHora();
        // Devuelvo la reserva
        return reserva;
    }

    @Override
    public void obtenerFechaDevolucion(Reserva reserva) {

        // Obtengo la fecha en la que se hizo la reserva
        LocalDateTime fechaPrestamo = reserva.getFechaHora();

        // Sumamos a la fecha del día de préstamo 1 mes.
        LocalDateTime fechaDevolucion = fechaPrestamo.plusMonths(1);

        // Mostramos por pantalla cuando se tiene que devolver el libro
        System.out.println("La fecha de devolución es: " + fechaDevolucion);
    }

    @Override
    public void mostrarInfoChula() {
        // Muestro la información mediante un salto de línea
        System.out.println("Libro: " + libro + "\n Fecha y Hora: " +  fechaHora);
    }

    @Override
    public String toString() {
        return "Reserva libro: " + libro + ", Fecha Hora: " + fechaHora;
    }
}
