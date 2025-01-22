package Array;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int elementoBorrar=30;
        int[] array ={10,20,30,40,50,60,0,0,0,0};
        System.out.println("Escoje una opcion");
        int opcion=input.nextInt();
        switch (opcion) {
            case 1:
                eliminarManual(array,elementoBorrar);
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
                break;
            case 2:
                eliminarAuto(array,elementoBorrar);
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            break;
        }    
        input.close();
    }
    public static int[] eliminarManual(int[] array,int elementoBorrar) {
        int indice=0;
        for(int i=0;i<array.length-1;i++){
            if (array[i]==elementoBorrar) {
                array[i]=0;
                indice=i;
            }if (array[i+1]==0&&indice<i) {
                array[indice]=array[i];
                array[i]=0;
                i=array.length;
            }
        }
        return array;
    }
    public static int[] eliminarAuto(int[] array,int elementoBorrar) {
        int indice=0;
        for(int i=0;i<array.length;i++){
            if (array[i]==elementoBorrar) {
                array[i]=0;
                indice=i;
                i=array.length;
            }
        }
        for(int i=indice+1;i<array.length;i++){
                int contenedor=array[i];
                array[i-1]=contenedor;
                }
        return array;
    }
}
