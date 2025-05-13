package Tema7.interfaces.EjercicioInterfaces2;

public class Main {
    public static void main(String[] args) {
        Coche coche = new Coche("hola", "adios");
        Barco barco = new Barco("adios", "hola");
        Anfibio anfibio = new Anfibio("si", "no");

        coche.arrancar();
        coche.detener();
        coche.conducir(20);
        coche.enMarcha();

        barco.arrancar();
        barco.detener();
        barco.navegar(20);
        barco.enMarcha();

        anfibio.arrancar();
        anfibio.detener();
        anfibio.conducir(20);
        anfibio.enMarcha();
    }
    

    
}
