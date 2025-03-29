package src.Tema6.Ejercicio1;
public class Ejercicio1 {
    public static void main(String[] args) {
        coches coche1= new coches("Hyunday", "El primero", 1998);
        coche1.mostrarInfo();
        coches coche2= new coches("lambo", "Huracan", 1421421);
        coche2.mostrarInfo();
        coches coche3= new coches("La otra", "ese", 124);
        coche3.mostrarInfo();
    }
}
class coches {
    private String marca;
    private String modelo;
    private int año;
    private int velocidad;
    public coches(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.velocidad = 0;
    }
    public void acelerar(int incremento){
        velocidad=+incremento;
    }
    public void frenar(int decremento){
        if (velocidad-decremento<=0) {
            System.out.println("No puedes ir a velocidad negativa");
            velocidad=0;
        }else{
            velocidad=-decremento;
        }
    }
    public void mostrarInfo(){
        System.out.println("Marca: "+this.marca);
        System.out.println("Modelo: "+this.modelo);
        System.out.println("Año: "+this.año);
        System.out.println("Velocidad: "+this.velocidad);
    }
}
