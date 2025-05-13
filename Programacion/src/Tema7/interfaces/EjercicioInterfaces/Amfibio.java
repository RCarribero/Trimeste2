package Tema7.interfaces.EjercicioInterfaces;

public class Amfibio implements Terrestre, Acuatico{
private String nombre;
private int kilometraje=0;
private boolean arrancado=false;
private String modo="tierra";



public Amfibio(String nombre) {
    this.nombre = nombre;
}

@Override
public void arrancar(){
    arrancado=true;
    if(arrancado){
        System.out.println("El anfibio se ha arrancado");
    }else{
        System.out.println("El anfibio esta en marcha");
    }
    
}

@Override

public void detener(){
    arrancado=false;
    if (!arrancado) {
        System.out.println("El anfibio ya esta detenido");
    }else{
        System.out.println("El anfibio se ha detenido");
    }
    
}
@Override
public void conducir(int distancia){
    if(!modo.equals("tierra"))
        System.out.println("Error:" + nombre + " no está en modo tierra.");
    else if(arrancado){
        kilometraje+=distancia;
        System.out.println(nombre + "ha conducido: " + distancia);
    }
    else{
        System.out.println("El anfibio esta apagado");
    }
    
}

@Override
public boolean estaEnMarcha(){
    return arrancado;
}

@Override
public void navegar(int kilometrajeA){
    if(!modo.equals("agua")){
        System.out.println("No esta en modo agua");
    }else if(arrancado){
        kilometraje+=kilometrajeA;
        System.out.println("El barco ha recorrido: " + kilometrajeA);
    }else{
        System.out.println("El barco esta apagado");
    }
    
}
public void cambiarModo(String nuevoModo){
    if(!arrancado){
        modo=nuevoModo;
    }else{
        System.out.println("El anfibio esta arrancado, apagalo antes");
        System.out.println(modo);
    }
}
}
