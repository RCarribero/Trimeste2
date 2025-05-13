package Tema7.interfaces.EjercicioRepaso;

public class Tren extends Vehiculo{
    private boolean arrancado=false;

    public Tren(String tipo, Persona conductor, String matricula, int capacidadMAX) {
        super(tipo, conductor, matricula, capacidadMAX);
    }

    @Override
    public void detener(){
        System.out.println("El tren se ha detenido");
        arrancado=false;
    }
    
    public void arrancar(){
        System.out.println("El tren esta en marcha");
        arrancado=true;
    }
}
