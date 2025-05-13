package Tema7.interfaces.EjercicioInterfaces2;

public class Coche implements Terrestre{
    String marca;
    String modelo;
    boolean arrancado=false;
    Double distancia=0.0;


    public Coche() {
        
    }

    public Coche(String marca, String modelo) {
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
}
