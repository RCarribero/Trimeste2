package ProyectoProgramacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        String repetir = "";
        do {
            Libreria.clear(); // Limpiar consola
            ArrayList<Barco> barcos1 = new ArrayList<>(); // Lista de barcos del jugador 1
            ArrayList<Barco> barcos2 = new ArrayList<>();// Lista de barcos del jugador 2
            ArrayList<Integer> Jugador1X = new ArrayList<>();// Lista de barcos del jugador 1
            ArrayList<Integer> Jugador1Y = new ArrayList<>();// Lista de barcos del jugador 1
            ArrayList<Integer> Jugador2X = new ArrayList<>();// Lista de barcos del jugador 2
            ArrayList<Integer> Jugador2Y = new ArrayList<>();// Lista de barcos del jugador 2
            Scanner input = new Scanner(System.in);
            int dificultad = 0, n = 0;
            String opcion = "";
            while (!opcion.equals("1")) {
                    opcion = Libreria.mostrarMenuOpciones(input);
            }
            do {
                Libreria.clear(); // Limpiar consola
                Libreria.dificultad(); // Menú de dificultad
                try {
                    dificultad = input.nextInt();
                } catch (Exception e) {
                    Libreria.clear();
                    System.out.println("Introduce una opcion valida");
                    Libreria.Esperar(2000);
                    Libreria.clear();
                }
                input.nextLine();
            } while (dificultad > 3 || dificultad < 1);
            n = (dificultad == 1) ? 10 : (dificultad == 2) ? 15 : 20;
            String[][] tablero1 = new String[n][n]; // Tablero del jugador 1
            String[][] tablero2 = new String[n][n]; // Tablero del jugador 2
            Barco[][] operador1 = new Barco[n][n]; // Tablero para operaciones del jugador 1
            Barco[][] operador2 = new Barco[n][n]; // Tablero para operaciones del jugador 2
            Libreria.clear();
            Libreria.rellenarTablero(tablero1, "⬜"); // Rellenar tablero del jugador 1
            Libreria.rellenarTablero(tablero2, "⬜"); // Rellenar tablero del jugador 2
            Libreria.rellenarTableroOperacion(operador1); // Rellenar tablero de operaciones del jugador 1
            Libreria.rellenarTableroOperacion(operador2); // Rellenar tablero de operaciones del jugador 2
            // tipos barco
            for (int i = 1; i <= 5; i++) {
                barcos1.add(new Jugador1()); // Crear barcos del jugador 1
                barcos2.add(new Jugador2()); // Crear barcos del jugador 2
            }
            // jugador 1
            Libreria.infoTipoFlota(); // tipo flota informacion
            System.out.println("Turno jugador 1");
            Libreria.tipoFlotaMenu(input, barcos1);// menu que elije cada flota con distintos barcos
            Libreria.asiganacionBarcoMenu(tablero1, operador1, barcos1, input);
            Libreria.repetirAleatorio(tablero1, operador1, barcos1, input);
            Libreria.imprimirTablero(tablero1);
            Libreria.Enter(input);
            Libreria.clear();
            // jugador 2
            Libreria.infoTipoFlota(); // tipo flota informacion
            System.out.println("Turno jugador 2");
            Libreria.tipoFlotaMenu(input, barcos2);// menu que elije cada flota con distintos barcos
            Libreria.asiganacionBarcoMenu(tablero2, operador2, barcos2, input);
            Libreria.repetirAleatorio(tablero2, operador2, barcos2, input);
            Libreria.imprimirTablero(tablero2);
            Libreria.Enter(input);
            Libreria.clear();
            Libreria.Turnos(input, Jugador1X, Jugador1Y, Jugador2X, Jugador2Y, tablero1, tablero2, operador1, operador2);
            if (Jugador1.getContadorBarcos()==0){
                System.out.println("Jugador2 ha ganado");
                Libreria.Destroyer();
            }else{
                System.out.println("Jugador1 ha ganado");
                Libreria.Titan();
            }
            System.out.println("¿Quieres jugar de nuevo?");
            repetir = input.nextLine();
            input.close();
        } while (repetir.equalsIgnoreCase("si"));
        Libreria.clear();
        Libreria.Esperar(500);
        Libreria.adios();
        Libreria.Destroyer();
    }
}
