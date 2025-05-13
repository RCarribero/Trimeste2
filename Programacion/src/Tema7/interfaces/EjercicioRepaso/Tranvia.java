package Tema7.interfaces.EjercicioRepaso;

public class Tranvia extends Vehiculo{
    private boolean arrancado=false;

    public Tranvia(String tipo, Persona conductor, String matricula, int capacidadMAX) {
        super(tipo, conductor, matricula, capacidadMAX);
    }

    @Override
    public void detener(){
        System.out.println("El tranvia se ha detenido");
        arrancado=false;
    }
    
    public void arrancar(){
        System.out.println("El tranvia esta en marcha");
        arrancado=true;
    }

}
