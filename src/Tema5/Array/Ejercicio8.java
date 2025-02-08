package src.Tema5.Array;
import Array.Ejercicio6;
import java.util.Random;

public class Ejercicio8 {
    public static void main(String[] args) {
        int[][] matrizA = new int[2][3];
        int[][] matrizB = new int[3][2];
        rellenarArray(matrizA);
        rellenarArray(matrizB);
        int[][] resultado = multiplicarMatriz(matrizA, matrizB);
        mostrarMatriz(matrizA);
        System.out.println();
        mostrarMatriz(matrizB);
        System.out.println();
        mostrarMatriz(resultado);
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static int[][] rellenarArray(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Random random = new Random();
                matriz[i][j] = random.nextInt(5)+1;
            }
        }
        return matriz;
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
}
