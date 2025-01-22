package Array;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        int [] tabla={1,2,3,4,5};
        System.out.println("Primer valor");
        System.out.println(tabla[0]); 
        Scanner input =new Scanner(System.in);
        tabla[0]=input.nextInt();
        modificar(tabla);
    }
    public static void modificar(int[] messi){
        System.out.println("Segundo valor");
        System.out.println(messi[0]);
    }
}
