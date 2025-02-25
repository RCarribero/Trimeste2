package src.Tema6.Ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Patatas",1.99);
        producto1.mostrarInfo();
        System.out.println();
        producto1.setPrecio(2.99);
        producto1.mostrarInfo();
        System.out.println();
        producto1.setPrecio(0);
        producto1.mostrarInfo();
    }
}
