package Array;

import java.util.Random;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[][] matriz=new int[2][3];
        rellenarArray(matriz);
        trasnpuestaMatriz(matriz);
        mostrarMatriz(matriz);
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
}
