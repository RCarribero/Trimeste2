public class Iluminacion {
    private int intensidad;

    public Iluminacion(int intensidad) {
        this.intensidad = intensidad;
    }

    public void ajustar() {
        System.out.println("Iluminación ajustada a " + intensidad + "% de intensidad.");
    }
}
