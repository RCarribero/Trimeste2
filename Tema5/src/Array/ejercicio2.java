package Array;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        int condition = 0;
        Scanner input = new Scanner(System.in);
        int[] array = { 5, 2, 9, 1, 6, 3, 4, 7, 8, 0 };
        do {
            System.out.println("1.Ordenar array \n2.Comprobar si esta en array\n3.Rellenar Array\n4.Copiar array\n5.Comparar array");
            condition = input.nextInt();
            switch (condition) {
                case 1:
                    ordenarArray(array);
                    break;
                case 2:
                    System.out.println("Ingresa num para array");
                    int num = input.nextInt();
                    System.out.println(buscarNumero(array, num));
                    break;
                case 3:
                    System.out.println("Ingresa num para array");
                    num = input.nextInt();
                    rellenarArray(array, num);
                    break;
                case 4:
                    System.out.println("Ingresa num para array");
                    num = input.nextInt();
                    copiaArray(array, num);
                    break;
                case 5:
                    if (compararArrays(array, array)) {
                        System.out.println("Si son del mismo tamaño y contienen los mismos valores");
                    } else {
                        System.out.println("No tienen los mismo valores");
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } while (condition != 6);

    }

    public static void ordenarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int contenedor = array[i];
                    array[i] = array[j];
                    array[j] = contenedor;
                }

            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static boolean compararArrays(int[] array1, int[] array2) {
        int[] array3 = { 1, 5, 8, 6, 9 };
        int[] array4 = { 1, 5, 8, 6, 9 };
        boolean comprobacion = true;
        if (array3.length == array4.length) {
            for (int i = 0; i < array3.length; i++) {
                if (array3[i] != array4[i])
                    comprobacion = false;
            }
        } else {
            System.out.println("No son de la misma longitud");
            comprobacion = false;
        }
        return comprobacion;
    }

    public static int buscarNumero(int[] array, int numero) {
        int resultado = 0;
        if (array.length > numero && array.length < numero) {
            resultado = -1;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == numero)
                    resultado = numero;
            }
        }
        return resultado;
    }

    public static void rellenarArray(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
            System.out.print(array[i] + "|");
        }
        System.out.println();
    }

    public static int[] copiaArray(int[] array, int n) {
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array2[i] = array[i];
        }
        return array2;
    }
}
