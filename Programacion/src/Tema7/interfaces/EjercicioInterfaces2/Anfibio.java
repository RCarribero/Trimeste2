package Tema7.interfaces.EjercicioInterfaces2;

public class Anfibio implements Terrestre, Acuatico{
    String marca;
    String modelo;
    boolean arrancado=false;
    Double distancia=0.0;
    String tipo="terrestre";

    public Anfibio() {
        
    }
    public Anfibio(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    public void detener(){
        arrancado=false;
        System.out.println("El coche esta apagado");
    }
    public void arrancar(){
        arrancado=true;
        System.out.println("El coche esta encendido");
    }
    public boolean enMarcha(){
        return arrancado;
    }

    public void conducir(int distancia){
        this.distancia+=distancia;
        System.out.println("Aqui tienes la distancia maxima " + this.distancia);
    }
    public void navegar(int distancia){
        this.distancia+=distancia;
        System.out.println("Aqui tienes la distancia maxima " + this.distancia);

    }
}
