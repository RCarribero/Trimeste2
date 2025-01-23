package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Indica el tamaño de la matriz");
        int n = input.nextInt();
        int[][] matriz= new int[n][n];
        rellenarArray(matriz);
        Arrays.toString(matriz);
        System.out.println(Arrays.deepToString(matriz));
    }
    public static int[][] rellenarArray(int[][] matriz) {
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                Random random = new Random();
                matriz[i][j]=random.nextInt(100);
            }
        }
        return matriz;
    }
}
