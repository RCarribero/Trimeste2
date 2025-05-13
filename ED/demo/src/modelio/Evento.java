public class Evento {
    protected String nombre;
    protected String fecha;

    public Evento(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public void mostrarInfo() {
        System.out.println("Evento: " + nombre + " | Fecha: " + fecha);
    }

    public String getNombre() {
        return nombre;
    }
}
