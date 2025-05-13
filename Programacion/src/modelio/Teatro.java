package modelio;
public class Teatro extends Evento {
    private String director;

    public Teatro(String nombre, String fecha, String director) {
        super(nombre, fecha);
        this.director = director;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Director: " + director);
    }
}
