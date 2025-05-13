package Tema7.interfaces.EjercicioInterfaces;

public class Barco implements Acuatico{
    private String nombre;
    private String modelo;
    private int kilometraje=0;
    private boolean navegando=false;

    
    public Barco(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    @Override
    public void arrancar(){
        
        if(navegando){
            System.out.println("El barco ya esta arrancado");
        }else{
            System.out.println("El barco ha arrancado");
        }
        navegando=true;
    }

    @Override
    public void detener(){
        
        if(!navegando){
            System.out.println("El barco ya esta detenido");
        }else{
            System.out.println("El barco se ha detenido");
        }
        navegando=false;
    }

    @Override
    public void navegar(int kilometrajeT){
        if(navegando){
            kilometraje+=kilometrajeT;
            System.out.println("El barco ha recorrido: " + kilometrajeT);
        }else{
            System.out.println("El barco esta apagado");
        }
        
    }

    @Override
    public boolean estaEnMarcha(){
        return navegando;
    }
}
