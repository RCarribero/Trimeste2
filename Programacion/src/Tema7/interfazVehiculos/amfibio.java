package Tema7.interfazVehiculos;

public class amfibio implements terrestre, acuatico {
    private String nombre;
    private int km;
    private boolean marcha;
    private String modo;

    public amfibio(String string) {
        //TODO Auto-generated constructor stub
    }

    public void navegar(int distancia) {
        if (marcha && modo=="agua")
            System.out.println(km += distancia);
    }

    @Override
    public boolean estaEnMarcha() {
        if (marcha)
            return true;
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void arrancar() {
        if (marcha  && modo=="tierra") {
            System.out.println("Ya esta arrancado");
        } else
            marcha = true;
    }

    @Override
    public void detener() {
        if (!estaEnMarcha()) {
            System.out.println("No esta arrancado");
        }
        marcha = false;

    }

    @Override
    public void conducir(int distancia) {
        if (estaEnMarcha())
            System.out.println(km += distancia);
    }
    void cambiarModo(String nuevoModo){
        if (!marcha) {
            modo=nuevoModo;
        }
    }
}
