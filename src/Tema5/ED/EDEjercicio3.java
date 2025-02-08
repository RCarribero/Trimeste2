package src.Tema5.ED;
import java.util.*;

public class EDEjercicio3 {
    public static void main(String[] args) {
        double precio,precioDescuento=0.00,precioFinal;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el precio base del producto: ");
        precio = input.nextDouble();
        if (precio>100)
        precioDescuento = precio*0.9;
        precioFinal=precioDescuento*1.21;
        System.out.println("El precio final es de : "+precioFinal);
        input.close();
    }
}
