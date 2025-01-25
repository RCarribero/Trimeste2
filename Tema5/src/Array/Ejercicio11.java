package Array;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce las filas para la matriz 1: ");
        int filas = input.nextInt();
        System.out.print("Introduce las columnas para la matriz 1: ");
        int columnas = input.nextInt();
        System.out.print("Introduce las filas para la matriz 2: ");
        int filas2 = input.nextInt();
        System.out.print("Introduce las columnas para la matriz 2: ");
        int columnas2 = input.nextInt();
        int[][] matriz1 = new int[filas][columnas];
        int[][] matriz2 = new int[filas2][columnas2];
        matrieslibreria.rellenarArray(matriz1);
        matrieslibreria.rellenarArray(matriz2);
        matrieslibreria.mostrarMatriz(matriz1);
        System.out.println();
        matrieslibreria.mostrarMatriz(matriz2);
        System.out.println();
        matrieslibreria.mostrarMatriz(concatenacionHorizontal(matriz1, matriz2));
        System.out.println();
        matrieslibreria.mostrarMatriz((concatenacionVertical(matriz1, matriz2)));
    }

    public static int[][] concatenacionHorizontal(int[][] matriz1, int[][] matriz2) {
        int matrizResultado[][];
        int tempJ = 0;
        if (matriz1.length == matriz2.length) {
            matrizResultado = new int[matriz1.length][matriz1[0].length + matriz2[0].length];
            for (int i = 0; i < matrizResultado.length; i++) {
                for (int j = 0; j < matrizResultado[0].length; j++) {
                    if (j <= matriz1.length) {
                        matrizResultado[i][j] = matriz1[i][j];
                    } else {       
                        matrizResultado[i][j] = matriz2[i][tempJ];
                        tempJ++;
                    }
                }
                tempJ = 0;
            }
        } else {
            matrizResultado = new int[0][0];
        }
        return matrizResultado;
    }
    public static int[][] concatenacionVertical(int[][] matriz1, int[][] matriz2) {
        int matrizResultado[][];
        int tempI = 0;
        if (matriz1[0].length == matriz2[0].length){
            matrizResultado = new int[matriz1.length+matriz2.length][matriz1[0].length];
            for (int i = 0; i < matrizResultado[0].length; i++) {
                for (int j = 0; j < matrizResultado[0].length; j++) {
                    if (i<matriz1.length) {
                        matrizResultado[i][j]=matriz1[i][j];
                    }else{
                        matrizResultado[i][j]=matriz2[tempI][j];
                        tempI++;
                    }
                }
                if (i>matriz1.length)tempI++;
                tempI = 0;
            }
        } else {
            matrizResultado = new int[0][0];
        }
        return matrizResultado;
    }
}
