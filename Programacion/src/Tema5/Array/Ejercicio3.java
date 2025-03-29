package src.Tema5.Array;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Ingresa un numero entero para mas tarde introducir numero: ");
        int n=input.nextInt();
        int contador=0,contador2=0;
        double mediaPositiva=0, mediaNegativa=0,ceros=0;
        int [] array  = new int[n];
        for (int i=0;i<n;i++) {
            System.out.println("Ingresa un numero para la posicion["+(i+1)+"]");
            array[i]=input.nextInt();
        }
        for (int i : array) {
            if (i>0) {
                mediaPositiva+=i;
                contador++;
            }else if (i<0) {
                mediaNegativa+=i;
                contador2++;
            }else if (i==0) {
                ceros++;
            }
        }
        System.out.println("La media de numeros positivos es: "+ mediaPositiva/contador);
        System.out.println("La media de numeros negativos es: "+ mediaNegativa/contador2);
        if (ceros==1) {
            System.out.println("Hay "+ceros+" cero en la cadena");
        }else if (ceros==0) {
            System.out.println("No hay cero en la cadena");
        }else{
            System.out.println("Hay "+ceros+" ceros en la cadena");
        }
        input.close();
    }
}
