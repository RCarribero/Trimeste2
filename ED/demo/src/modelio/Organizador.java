import java.util.ArrayList;

public class Organizador {
    private String nombre;
    private ArrayList<Evento> eventos;

    public Organizador(String nombre) {
        this.nombre = nombre;
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        System.out.println("Eventos organizados por " + nombre + ":");
        for (Evento e : eventos) {
            System.out.println("- " + e.getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }
}
