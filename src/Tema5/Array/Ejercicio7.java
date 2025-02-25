package src.Tema5.Array;

public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] matrizA={{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrizB={{1,2,3},{4,5,6},{7,8,9}};
        sumaMatriz(matrizA, matrizB);
    }
    public static void sumaMatriz(int[][] matrizA, int[][] matrizB) {
        boolean comprobacion=true;
        if (matrizA.length==matrizB.length) {
            for(int i=0;i<matrizA.length;i++){
                if (matrizA[i].length!=matrizB[i].length) {
                    comprobacion=false;
                }
            }
        }else{
            comprobacion=false;
        }
            System.out.println("Matriz A:");
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[i].length; j++) {
                    System.out.print(matrizA[i][j]+"|");
                }
                System.out.println();
            }
            System.out.println("Matriz B:");
            for (int i = 0; i < matrizB.length; i++) {
                for (int j = 0; j < matrizB[i].length; j++) {
                    System.out.print(matrizB[i][j]+"|");
                }
                System.out.println();
            }
        if (comprobacion){
            System.out.println("Matriz A+B:");
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA.length; j++) {
                    System.out.print(matrizA[i][j]+matrizB[i][j]+"|");
                }
                System.out.println();
            }
        }
    }
}
