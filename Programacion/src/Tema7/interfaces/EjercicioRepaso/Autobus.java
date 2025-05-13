package Tema7.interfaces.EjercicioRepaso;

public class Autobus extends Vehiculo{
private boolean arrancado=false;



public Autobus() {

}

public Autobus(String tipo, Persona conductor, String matricula, int capacidadMAX) {
    super(tipo, conductor, matricula, capacidadMAX);
}

@Override
public void detener(){
    System.out.println("El autobus se ha detenido");
    arrancado=false;
}

public void arrancar(){
    System.out.println("El autobus esta en marcha");
    arrancado=true;
}
}
