package modelio;
public class Concierto extends Evento {
    private String banda;

    public Concierto(String nombre, String fecha, String banda) {
        super(nombre, fecha);
        this.banda = banda;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Banda: " + banda);
    }
}
