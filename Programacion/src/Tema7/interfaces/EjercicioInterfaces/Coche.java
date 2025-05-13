package Tema7.interfaces.EjercicioInterfaces;

public class Coche implements Terrestre{
private String marco;
private String modelo;
private int kilometraje=0;
private boolean arrancado=false;


public Coche(String marco, String modelo) {
    this.marco = marco;
    this.modelo = modelo;
}

@Override
public void arrancar(){
    
    if(arrancado){
        System.out.println("el coche ya esta arrancado");
    }else{
        System.out.println("El coche ha arrancado");
    }
    arrancado=true;
}

@Override

public void detener(){
    
    if(!arrancado){
        System.out.println("El coche ya esta apagado");
    }else{
        System.out.println("El coche se ha detenido");
    }
    arrancado=false;
}

public void conducir(int distancia){
    if(arrancado){
        System.out.println("El coche ha recorrido: " + distancia);
    }else{
        System.out.println("El coche esta apagado");
    }
    
}

@Override
public boolean estaEnMarcha(){
    return arrancado;
}
}
