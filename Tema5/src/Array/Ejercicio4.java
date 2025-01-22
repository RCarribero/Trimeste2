package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] array ={10,20,30,40,0,0,0,0,0,0};
        try {
            System.out.println("Escoje una opcion");
            int opcion=input.nextInt();
            switch (opcion) {
                case 1:
                    insertarArray(array, input);
                    System.out.println("Array no ordenado");
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i]+"|");
                    }
                    break;
                case 2:
                    insertarArrayOrdenado(array, input);
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i]+" ");
                    }
                break;
            }   
        } catch (Exception e) {
            System.out.println("Hubo un error: "+e);
        }
    
    }
    public static int[] insertarArray(int[] array, Scanner input) {
        System.out.println("Dime una posicion para cambiar el array");
        int n = input.nextInt();
        System.out.println("Dime un numero para insertar en el array");
        array[n]=input.nextInt();
        return array;
    }
    public static int[] insertarArrayOrdenado(int[]array,Scanner input) {
        System.out.println("Introduce un nuevo numero");
        int n = input.nextInt();
        for(int i=0; i<array.length;i++){
            if (array[i]==0) {
                array[i]=n;
                i=array.length;
            }
        }
        for(int i=0; i<array.length;i++){
            for(int j=0; j<array.length;j++){
                if (array[i] < array[j]&&array[i]!=0) {
                    int contenedor = array[i];
                    array[i] = array[j];
                    array[j] = contenedor;
                }
            }
        }
        return array;
    }
}
