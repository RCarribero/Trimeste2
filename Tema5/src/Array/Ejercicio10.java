package Array;

public class Ejercicio10 {
    public static void main(String[] args) {
        int[][]matriz={{1,2,3},{-2,4,5},{-3,-5,6}};
        matrizSimetrica(matriz);
        matrizAntisimetrica(matriz);
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
                if (i==j) {
                    matriz[i][j]=0;
                }
                if (matriz[i][j]!=matriz[j][i]*(-1)) {
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
