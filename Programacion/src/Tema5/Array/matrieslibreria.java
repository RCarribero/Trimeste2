package src.Tema5.Array;

import java.util.Random;

public class matrieslibreria {
        public static int[][] rellenarArray(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Random random = new Random();
                matriz[i][j] = random.nextInt(5)+1;
            }
        }
        return matriz;
    }
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static int[][] multiplicarMatriz(int[][] matrizA, int[][] matrizB) {
        int[][] matrizResultado = new int[matrizA.length][matrizB[0].length];
        if (matrizA[0].length == matrizB.length) {
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA.length; j++) {
                    for (int k = 0; k < matrizB.length; k++) {
                        matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }
        }
        return matrizResultado;
    }
    public static int[][] trasnpuestaMatriz(int[][]matriz) {
        int [][]trasnpuestaMatriz=new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                trasnpuestaMatriz[j][i]=matriz[i][j];
            }
        }
        return trasnpuestaMatriz;
    }
    public static void matrizSimetrica(int[][] matriz) {
        boolean comprobacion=true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j]!=matriz[j][i]) {
                    comprobacion=false;
                }
            }
        }
        matrieslibreria.mostrarMatriz(matriz);
        if (comprobacion) {
            System.out.println("La matriz es simetrica ");
        }else
        System.out.println("La matriz no es simetrica");
    }
    public static void matrizAntisimetrica(int[][] matriz) {
        boolean comprobacion=true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j]!=(matriz[j][i]*(-1))&&i!=j) {
                    comprobacion=false;
                }
            }
        }
        matrieslibreria.mostrarMatriz(matriz);
        if (!comprobacion) {
            System.out.println("No es una matriz Antisimetrica");
        }else
        System.out.println("Es una matriz Antisimetrica");
    }
}
