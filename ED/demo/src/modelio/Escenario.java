public class Escenario {
    private String nombre;
    private Iluminacion sistemaIluminacion;

    public Escenario(String nombre, int intensidadIluminacion) {
        this.nombre = nombre;
        this.sistemaIluminacion = new Iluminacion(intensidadIluminacion);
    }

    public void preparar() {
        System.out.println("Preparando escenario: " + nombre);
        sistemaIluminacion.ajustar();
    }
}
