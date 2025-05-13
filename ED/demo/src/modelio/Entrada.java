public class Entrada {
    private Asistente asistente;
    private Evento evento;
    private Organizador organizador;
    private String precio;

    public Entrada(Asistente asistente, Evento evento, Organizador organizador, String precio) {
        this.asistente = asistente;
        this.evento = evento;
        this.organizador = organizador;
        this.precio = precio;
    }

    public void mostrarEntrada() {
        System.out.println("----- Entrada -----");
        System.out.println("Asistente: " + asistente.getNombre());
        System.out.println("Evento: " + evento.getNombre());
        System.out.println("Organizador: " + organizador.getNombre());
        System.out.println("Precio: " + precio + " €");
    }
}
