import java.time.LocalDateTime;

public class Reserva {

    // Atributos de la clase
    private Libro libro;
    private LocalDateTime fechaHora;

    // Constructor vacio
    public Reserva() {
    }

    // Constructor con todos los parámetros
    public Reserva(Libro libro, LocalDateTime fechaHora) {
        this.libro = libro;
        this.fechaHora = fechaHora;
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

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Reserva libro: " + libro + ", fechaHora: " + fechaHora;
    }

}
