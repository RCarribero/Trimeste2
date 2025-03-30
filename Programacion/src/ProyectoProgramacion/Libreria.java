package ProyectoProgramacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
     static void Bienvenido() { // Mensaje de bienvenida
        System.out.println("  ____        _        _ _            _   _                  _ \n" +
                " | __ )  __ _| |_ __ _| | | __ _     | \\ | | __ ___   ____ _| |\n" +
                " |  _ \\ / _` | __/ _` | | |/ _` |    |  \\| |/ _` \\ \\ / / _` | |\n" +
                " | |_) | (_| | || (_| | | | (_| |    | |\\  | (_| |\\ V / (_| | |\n" +
                " |____/ \\__,_|\\__\\__,_|_|_|\\__,_|    |_| \\_|\\__,_| \\_/ \\__,_|_|\n");
    }

    static String mostrarMenuOpciones(Scanner input) {
        String opcion;
        do {
            Libreria.Bienvenido(); // Mensaje de bienvenida
            Libreria.opcion(); // Menú de opciones
            opcion = input.nextLine();
            if (opcion.equals("2")) {
                Libreria.clear(); // Limpiar consola
                Libreria.instrucciones(); // Instrucciones del juego
                Libreria.Esperar(3000);
                Libreria.Enter(input);
                Libreria.clear(); // Limpiar consola
            }
        } while (!opcion.equals("1"));
        return opcion;
    }

    static void opcion() { // Opciones a elegir al principio del programa
        System.out.println("Elije una opción:");
        System.out.println("1.Jugar");
        System.out.println("2.Instrucciones");
    }

    static void adios() { // Despedida
        System.out.println("   ____                _                                  _                        \n" +
                "  / ___|_ __ __ _  ___(_) __ _ ___   _ __   ___  _ __    (_)_   _  __ _  __ _ _ __ \n" +
                " | |  _| '__/ _` |/ __| |/ _` / __| | '_ \\ / _ \\| '__|   | | | | |/ _` |/ _` | '__|\n" +
                " | |_| | | | (_| | (__| | (_| \\__ \\ | |_) | (_) | |      | | |_| | (_| | (_| | |   \n" +
                "  \\____|_|  \\__,_|\\___|_|\\__,_|___/ | .__/ \\___/|_|     _/ |\\__,_|\\__, |\\__,_|_|   \n" +
                "                                    |_|                |__/       |___/            ");

    }

    static void instrucciones() { // Instrucciones del juego
        System.out.println("  ___           _                       _                       \n" +
                " |_ _|_ __  ___| |_ _ __ _   _  ___ ___(_) ___  _ __   ___  ___ \n" +
                "  | || '_ \\/ __| __| '__| | | |/ __/ __| |/ _ \\| '_ \\ / _ \\/ __|\n" +
                "  | || | | \\__ \\ |_| |  | |_| | (_| (__| | (_) | | | |  __/\\__ \\\n" +
                " |___|_| |_|___/\\__|_|   \\__,_|\\___\\___|_|\\___/|_| |_|\\___||___/\n ");

        System.out.println("El juego consiste en hundir los barcos del oponente");
        System.out.println("El tablero se compone de casillas");
        System.out.println("Cada jugador pertenece a una flota de barcos");
        System.out.println("Tamaño total de las flotas es 20");
        System.out.println("Cada jugador tiene 5 barcos");
        System.out.println("El jugador que hunda los 5 barcos del oponente gana");
    }

    static void dificultad() { // Dificultad del juego
        System.out.println("  ____  _  __ _            _ _            _ \n" +
                " |  _ \\(_)/ _(_) ___ _   _| | |_ __ _  __| |\n" +
                " | | | | | |_| |/ __| | | | | __/ _` |/ _` |\n" +
                " | |_| | |  _| | (__| |_| | | || (_| | (_| |\n" +
                " |____/|_|_| |_|\\___|\\__,_|_|\\__\\__,_|\\__,_|\n");
        System.out.println("");
        System.out.println("¿Qué dificultad desea jugar?");
        System.out.println("1.Principiante 10x10");
        System.out.println("2.Modo Experto 15x15");
        System.out.println("3.Modo Maestro 20x20");
    }

     static void rellenarTablero(String[][] tablero, String caracter) { // Te rellena el tablero con el caracter
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = caracter;
            }
        }
    }

     static void rellenarTableroOperacion(Barco[][] tablero) { // Rellena el tablero de operaciones con valores
                                                                     // NULL
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = null;
            }
        }
    }

     static void imprimirTablero(String[][] tablero) { // Te imprime el tablero visual del jugador
        for (int i = 0; i < tablero.length + 1; i++) {
            if (i == 0) {
                System.out.print("    X   ");
            } else {
                System.out.print(" " + (i - 1) + "\t");
            }
        }
        System.out.println();
        System.out.println(" Y");
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length + 1; j++) {
                if (j == 0) {
                    System.out.print(" " + i + "\t");
                } else {
                    System.out.print(tablero[i][j - 1] + "\t");
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

     static void infoTipoFlota() { // Diferentes tipos de flotas
        System.out.println(
                "  _   _                       _         __ _       _          \n" +
                        " | |_(_)_ __   ___  ___    __| | ___   / _| | ___ | |_ __ _ _ \n" +
                        " | __| | '_ \\ / _ \\ __|   / _` |/ _ \\ | |_| |/ _ \\| __/ _` (_)\n" +
                        " | |_| | |_) | (_) \\__ \\ | (_| |  __/ |  _| | (_) | || (_| |_ \n" +
                        "  \\__|_| .__/ \\___/|___/  \\__,_|\\___| |_| |_|\\___/ \\__\\__,_(_)\n" +
                        "       |_|                                                     \n");
        System.out.println("1-Flota Leviatán🪼");
        System.out.println("Portaaviones🛩️/6, Acorazado⛴️/5, Destructor🚢/4, Buque de Carga🛳️/3, Fragata🚤/2");
        System.out.println();

        System.out.println("2-Flota Fantasma👻");
        System.out.println("Lanzamisiles🚀/6, Destructor🚢/5, Buque de Carga🛳️/4, Submarino/3, Fragata🚤/2");
        System.out.println();

        System.out.println("3-Flota Titan⚓");
        System.out.println("Portaaviones🛩️/6, Buque de Carga🛳️/5, Destructor🚢/4, Submarino/3, Fragata🚤/2");
        System.out.println();

        System.out.println("4-Flota Tempestad⛈️");
        System.out.println("Acorazado⛴️/6, Lanzamisiles🚀/5, Destructor🚢/4, Buque de Carga🛳️/3, Submarino🚗/2");
        System.out.println();

        System.out.println("5-Flota Centurión🦈");
        System.out.println("Portaaviones🛩️/6, Acorazado⛴️/5, Lanzamisiles🚀/4, Submarino/3, Fragata🚤/2");
        System.out.println();

    }

     static void tipoFlotaMenu(Scanner input, ArrayList<Barco> barcos) { // Diferentes tipos de flotas
        boolean verificacionTflota = true;
        do {
            System.out.println("Que flota quieres ejercer");
            String tflota = input.nextLine();
            switch (tflota) {
                case "1": // Flota Leviatán
                    barcos.get(4).setNombre("Portaaviones🛩️");
                    barcos.get(3).setNombre("Acorazado⛴️");
                    barcos.get(2).setNombre("Destructor🚢");
                    barcos.get(1).setNombre("Buque de Carga🛳️");
                    barcos.get(0).setNombre("Fragata🚤");
                    barcos.get(0).setTamano(2);
                    barcos.get(1).setTamano(3);
                    barcos.get(2).setTamano(4);
                    barcos.get(3).setTamano(5);
                    barcos.get(4).setTamano(6);
                    verificacionTflota = false;
                    break;
                case "2": // Flota Fantasma
                    barcos.get(4).setNombre("Lanzamisiles🚀");
                    barcos.get(3).setNombre("Destructor🚢");
                    barcos.get(2).setNombre("Buque de Carga🛳️");
                    barcos.get(1).setNombre("Submarino");
                    barcos.get(0).setNombre("Fragata🚤");
                    barcos.get(0).setTamano(2);
                    barcos.get(1).setTamano(3);
                    barcos.get(2).setTamano(4);
                    barcos.get(3).setTamano(5);
                    barcos.get(4).setTamano(6);
                    verificacionTflota = false;
                    break;
                case "3": // Flota Titan
                    barcos.get(4).setNombre("Portaaviones🛩️");
                    barcos.get(3).setNombre("Buque de Carga🛳️");
                    barcos.get(2).setNombre("Destructor🚢");
                    barcos.get(1).setNombre("Submarino");
                    barcos.get(0).setNombre("Fragata🚤");
                    barcos.get(0).setTamano(2);
                    barcos.get(1).setTamano(3);
                    barcos.get(2).setTamano(4);
                    barcos.get(3).setTamano(5);
                    barcos.get(4).setTamano(6);
                    verificacionTflota = false;
                    break;
                case "4": // Flota Tempestad
                    barcos.get(4).setNombre("Acorazado⛴️");
                    barcos.get(3).setNombre("Lanzamisiles🚀");
                    barcos.get(2).setNombre("Destructor🚢");
                    barcos.get(1).setNombre("Buque de Carga🛳️");
                    barcos.get(0).setNombre("Submarino🚗");
                    barcos.get(0).setTamano(2);
                    barcos.get(1).setTamano(3);
                    barcos.get(2).setTamano(4);
                    barcos.get(3).setTamano(5);
                    barcos.get(4).setTamano(6);
                    verificacionTflota = false;
                    break;
                case "5": // Flota Centurión
                    barcos.get(4).setNombre("Portaaviones🛩️");
                    barcos.get(3).setNombre("Acorazado⛴️");
                    barcos.get(2).setNombre("Lanzamisiles🚀");
                    barcos.get(1).setNombre("Submarino");
                    barcos.get(0).setNombre("Fragata🚤");
                    barcos.get(0).setTamano(2);
                    barcos.get(1).setTamano(3);
                    barcos.get(2).setTamano(4);
                    barcos.get(3).setTamano(5);
                    barcos.get(4).setTamano(6);
                    verificacionTflota = false;
                    break;
                default:
                    clear();
                    System.out.println("Flota no existente, indique una de las que hay");
                    Esperar(2000);
                    clear();
                    infoTipoFlota();
                    break;
            }
        } while (verificacionTflota == true);
    }

     static void clear() { // Te borra el contenido de la consola pero se sigue ejecutando el programa
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

     static void Esperar(int n) { // Te borra el contenido de la consola pero se sigue ejecutando el programa
        try {
            // Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(n);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     static void Destroyer() {
        System.out.println(
                "                        |\\                                         \n" +
                        "                        | \\       (])                            \n" +
                        "                  ______|__\\_______|\\___                           \n" +
                        "                 /----==== DESTROYER MAX ====----\\                  \n" +
                        "      \\=========|  ⚫   ⚫      ⚫   ⚫   🚀  |=========/         \n" +
                        "       \\       |______⚫______⚫______⚫______|       /          \n" +
                        "        \\_____/                                  \\_____/       \n" +
                        "   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   \n" +
                        "     \\    []    []    []    []    []    []    []    []    /    \n" +
                        "   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   \n");
    }

     static void Titan() {
        System.out.println(
                "                        |\\    \n" +
                        "                        | \\       (])    \n" +
                        "                  ______|__\\_______|\\___    \n" +
                        "        /========/----==== WARSHIP TITAN ====----\\========\\    \n" +
                        "       | ⚫   🚀  ⚫   🚀   ⚫   🚀   ⚫   🚀   ⚫  |    \n" +
                        "       |______⚫______⚫______⚫______⚫______⚫______|    \n" +
                        "      /=========|  🔥 MEGA CANNONS 🔥  |=========\\    \n" +
                        "      \\        |______⚫______⚫______⚫______|        /    \n" +
                        "       \\_____/        ⚡ NUCLEAR CORE ⚡        \\_____/    \n" +
                        "   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    \n" +
                        "     \\  [][][][]  [][][][]  [][][][]  [][][][]  /    \n" +
                        "   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    \n");
    }

     static void rellenaBarcos(String[][] tablero, Barco[][] operador, ArrayList<Barco> barcos1, int X, int Y,
            String orientacion, int tamano, int posicion) { // Funcion que permite rellenar ambos tableros, uno con
                                                            // emojis de forma visual y otro con los objetos
        // String tablero es el tablero que se le muestra al jugador
        // Barco operador1[][] es el tablero que se opera por detras
        if (orientacion.equalsIgnoreCase("H")) {// Posicion Horizontal
            for (int i = X; i < X + tamano; i++) {
                operador[Y][i] = barcos1.get(posicion);// rellena el operador con el objeto barco
                tablero[Y][i] = "🚤";// rellena el tablero con los emojis de barcos
            }
        } else if (orientacion.equalsIgnoreCase("V")) {// Posicion vertical
            for (int i = Y; i < Y + tamano; i++) {
                operador[i][X] = barcos1.get(posicion);// rellena el operador con el objeto barco
                tablero[i][X] = "🚤";// rellena el tablero con los emojis de barcos
            }
        }
    }

     static boolean verificacionTablero(Barco[][] operador, int X, int Y, String orientacion, int tamano) {
        boolean verificacion = true;
        if (orientacion.equalsIgnoreCase("v")) {
            verificacion = verificacionTableroVertical(operador, X, Y, orientacion, tamano);
        } else if (orientacion.equalsIgnoreCase("h")) {
            verificacion = verificacionTableroHorizontal(operador, X, Y, orientacion, tamano);
        }
        return verificacion;
    }

     static boolean verificacionTableroA(Barco[][] operador, int X, int Y, String orientacion, int tamano) {
        boolean verificacion = true;
        if (orientacion.equalsIgnoreCase("v")) {
            verificacion = verificacionTableroVerticalA(operador, X, Y, orientacion, tamano);
        } else if (orientacion.equalsIgnoreCase("h")) {
            verificacion = verificacionTableroHorizontalA(operador, X, Y, orientacion, tamano);
        }
        return verificacion;
    }

     static boolean verificacionTablero() {
        boolean verificacion = true;
        Math.random();

        return verificacion;
    }

     static void Enter(Scanner input) {
        System.out.println("Presiona ENTER para continuar...");
        input.nextLine(); // Esperar entrada del usuario
    }

     static boolean verificacionTableroVertical(Barco[][] operador, int X, int Y, String orientacion,
            int tamano) {
        boolean verificacion = true;
        if (X >= operador.length) { // Mira si las posiciones del barco se van fuera del tablero por el eje X
            clear();// en el caso de que entre te limpia la consola
            System.out.println("El barco esta fuera del tablero por el eje X");
            verificacion = false;
            Esperar(2000);// espera 2 segundos para volver a empezar
        } else if (Y + tamano >= operador[0].length) { // Mira si las posiciones del barco se van fuera del tablero por
                                                       // el eje Y
            clear();
            System.out.println("El barco esta fuera del tablero por el eje Y");
            verificacion = false;
            Esperar(2000);
        } else {
            for (int i = Y; i < Y + tamano + 1; i++) {// Mira si hay un barco en alguna de las posiciones que va a
                                                      // ocupar le barco
                if (operador[i][X] != null) {
                    clear();
                    verificacion = false;
                    System.out.println("Hay un barco en esa posición");
                    i = operador.length;
                    Esperar(2000);
                }
            }
        }
        return verificacion;
    }

     static boolean verificacionTableroHorizontal(Barco[][] operador, int X, int Y, String orientacion,
            int tamano) {// Funcion que verificar si una posicion del tablero es valida para poner un
                         // barco, ya sea por que este fuera del tablero o pq ya hay un barco
        boolean verificacion = true;
        if (X + tamano >= operador.length) { // Mira si las posiciones del barco se van fuera del tablero por el eje x
            clear();
            System.out.println("El barco esta fuera del tablero por el eje X");
            verificacion = false;
            Esperar(2000);
        } else if (Y >= operador[0].length) {// Mira si las posiciones del barco se van fuera del tablero por el eje Y
            clear();
            System.out.println("El barco esta fuera del tablero por el eje Y");
            verificacion = false;
            Esperar(2000);
        } else {
            for (int i = X; i < X + tamano + 1; i++) {// Mira si hay un barco en alguna de las posiciones que va a
                                                      // ocupar le barco
                if (operador[Y][i] != null) {
                    clear();
                    verificacion = false;
                    System.out.println("Hay un barco en esa posición");
                    i = operador.length;
                    Esperar(2000);
                }
            }
        }
        return verificacion;
    }

     static boolean verificacionTableroVerticalA(Barco[][] operador, int X, int Y, String orientacion,
            int tamano) {
        boolean verificacion = true;
        if (X >= operador.length) { // Mira si las posiciones del barco se van fuera del tablero por el eje X
            clear();// en el caso de que entre te limpia la consola
            verificacion = false;
        } else if (Y + tamano >= operador[0].length) { // Mira si las posiciones del barco se van fuera del tablero por
                                                       // el eje Y
            clear();
            verificacion = false;
        } else {
            for (int i = Y; i < Y + tamano + 1; i++) {// Mira si hay un barco en alguna de las posiciones que va a
                                                      // ocupar le barco
                if (operador[i][X] != null) {
                    clear();
                    verificacion = false;
                    i = operador.length;
                }
            }
        }
        return verificacion;
    }

     static boolean verificacionTableroHorizontalA(Barco[][] operador, int X, int Y, String orientacion,
            int tamano) {// Funcion que verificar si una posicion del tablero es valida para poner un
                         // barco, ya sea por que este fuera del tablero o pq ya hay un barco
        boolean verificacion = true;
        if (X + tamano >= operador.length) { // Mira si las posiciones del barco se van fuera del tablero por el eje x
            clear();
            verificacion = false;
        } else if (Y >= operador[0].length) {// Mira si las posiciones del barco se van fuera del tablero por el eje Y
            clear();
            verificacion = false;
        } else {
            for (int i = X; i < X + tamano + 1; i++) {// Mira si hay un barco en alguna de las posiciones que va a
                                                      // ocupar le barco
                if (operador[Y][i] != null) {
                    clear();
                    verificacion = false;
                    i = operador.length;
                }
            }
        }
        return verificacion;
    }

     static void asiganacionBarco(String[][] tablero, Barco[][] operador, ArrayList<Barco> barcos,
            Scanner input) { // funcion en la que asignamos las coordenadar de los barcos
        int X;
        int Y;
        int tamano;
        String orientacion;
        boolean verificacion = true;
        for (int i = 0; i < 5; i++) {
            tamano = barcos.get(i).getTamano();
            do {
                imprimirTablero(tablero);// te imprime le tablero al principio del bucle
                verificacion = true;
                System.out.println("Dime la posicion X para el barco de tamaño: " + (i + 1));// te pide la posicion X
                                                                                             // del jugador
                X = input.nextInt();
                input.nextLine(); // lo utilizamos para limpiar el buffer del input
                System.out.println("Dime la posicion Y para el barco de tamaño: " + (i + 1));// te pide la posicion Y
                                                                                             // del jugador
                Y = input.nextInt();
                input.nextLine();
                System.out.println("Dime si lo quieres en Horizontal(H) o Vertical(V)");// te pide la posicion del barco
                                                                                        // dentro del los tableros
                orientacion = input.nextLine();
                if (!orientacion.equalsIgnoreCase("h") && !orientacion.equalsIgnoreCase("V")) { // te mira si en la
                                                                                                // horientacion es H o
                                                                                                // Ven el caso de que no
                                                                                                // sea te salga error
                    verificacion = false;
                    System.out.println("Introduce un valor valido de orientacion");
                } else {
                    verificacion = verificacionTablero(operador, X, Y, orientacion, tamano);// En el caso de que todo
                                                                                            // sea valido verificamos el
                                                                                            // tablero
                }
                clear();
            } while (!verificacion);// el bucle se cierra cuando la verificacion se quede en TRUE en el caso de que
                                    // no se que en falso
            rellenaBarcos(tablero, operador, barcos, X, Y, orientacion, tamano, i);// llamamos a la funcion que te
                                                                                   // rellana los barcos si todo ha
                                                                                   // salido correctamente
            clear();
        }
    }

     static void asiganacionBarcoAleatorio(String[][] tablero, Barco[][] operador, ArrayList<Barco> barcos,
            Scanner input, int n) { // utilizamos este metodo para asgianar los barcos de manera aleatoria
        int X;
        int Y;
        int tamano;
        String orientacion;
        boolean verificacion = true;
        for (int i = 0; i < 5; i++) {
            tamano = barcos.get(i).getTamano();
            do {
                verificacion = true;

                X = (int) (Math.random() * n); // Genera una coordenada X entre 0 y n-1
                Y = (int) (Math.random() * n); // Genera una coordenada Y entre 0 y n-1

                // Genera aleatoriamente entre 0.0 y 1.0 si <0.5 "h" (horizontal) sino "v"
                // (vertical)
                orientacion = Math.random() < 0.5 ? "h" : "v";

                // Verifica si la posición es válida
                verificacion = verificacionTableroA(operador, X, Y, orientacion, tamano);

                clear();
            } while (!verificacion); // Se repite hasta encontrar una posición válida

            // Coloca el barco en el tablero
            rellenaBarcos(tablero, operador, barcos, X, Y, orientacion, tamano, i);
            clear();
        }
    }

     static void repetirAleatorio(String[][] tablero, Barco[][] operador, ArrayList<Barco> barcos,
            Scanner input) {
        String OpcAleatorio = "";
        boolean salida = true;
        do {
            imprimirTablero(tablero);
            System.out.println("¿Quieres volver a formar las flotas de tus barcos aleatorio(1) o continuar(2)?");
            OpcAleatorio = input.nextLine();
            switch (OpcAleatorio) {
                case "1":
                    rellenarTablero(tablero, "⬜");
                    for (int i = 0; i < operador.length; i++) {
                        for (int j = 0; j < operador.length; j++) {
                            operador[i][j] = null;
                        }
                    }
                    asiganacionBarcoAleatorio(tablero, operador, barcos, input, tablero.length);
                    break;
                case "2":
                    clear();
                    salida = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (salida == true);
    }

     static void asiganacionBarcoMenu(String[][] tablero, Barco[][] operador, ArrayList<Barco> barcos,
            Scanner input) {// Utilizamos este metodo con un menu para darle a alegir a los jugadores si
                            // quieren que la asignacio
        // sea aleatoria o no
        String OpcAleatorio = "";
        boolean salida = true;
        do {
            System.out.println("¿Formar las flotas de tus barcos manualmente(1) o aleatorio(2)?");
            OpcAleatorio = input.nextLine();
            switch (OpcAleatorio) {
                case "1":
                    asiganacionBarco(tablero, operador, barcos, input);
                    salida = false;
                    break;
                case "2":
                    asiganacionBarcoAleatorio(tablero, operador, barcos, input, tablero.length);
                    salida = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (salida == true);
    }

     static void verificacionDisparo(Scanner input, ArrayList<Integer> X, ArrayList<Integer> Y, Barco[][] operador, String[][] tablero, boolean jugador) {
        int[] coordenadas = obtenerCoordenadasDisparo(input, operador);
        int x = coordenadas[0];
        int y = coordenadas[1];

        while (coordenadasRepetidas(X, Y, x, y)) {
            System.out.println("Ya disparaste alli");
            Esperar(1000);
            coordenadas = obtenerCoordenadasDisparo(input, operador);
            x = coordenadas[0];
            y = coordenadas[1];
        }

        X.add(x);
        Y.add(y);
        input.nextLine();
        disparo(operador, tablero, x, y, jugador);
    }

    private static int[] obtenerCoordenadasDisparo(Scanner input, Barco[][] operador) {
        int x, y;
        do {
            System.out.println("Indica eje X para el disparo");
            x = input.nextInt();
            System.out.println("Indica eje Y para el disparo");
            y = input.nextInt();
            if (x >= operador.length || x < 0 || y >= operador.length || y < 0) {
                System.out.println("Esa posicion esta fuera del tablero");
                Esperar(2000);
            }
        } while (x >= operador.length || x < 0 || y >= operador.length || y < 0);
        return new int[]{x, y};
    }

    private static boolean coordenadasRepetidas(ArrayList<Integer> X, ArrayList<Integer> Y, int x, int y) {
        for (int i = 0; i < X.size(); i++) {
            if (x == X.get(i) && y == Y.get(i)) {
                return true;
            }
        }
        return false;
    }

     static void disparo(Barco[][] operador, String[][] tablero, int x, int y, boolean jugador) {// Utilizamos este metodo para ver sihemosimpactado en
                                                                                                       // un barco o en
                                                                                                       // agua
        if (operador[y][x] != null) {
            System.out.println(operador[y][x].getNombre() + " ha sido impactado");
            operador[y][x].decrementarTamaño();
            if (operador[y][x].getTamano() == 0) {// En el caso de que la vida sea 0 llamamos a la funcion hundir barco
                hundirBarco(operador, tablero, x, y, jugador);
                Esperar(2000);
                clear();
            } else {
                tablero[y][x] = "💥";
                Esperar(2000);
                clear();
            }
        } else {
            System.out.println("¡Agua!💧");
            tablero[y][x] = "🟥";
            Esperar(2000);
            clear();
        }
    }

     static void animacionExplosion() {
        clear();
        System.out.println("🚢💥");
        Esperar(500);
        clear();
        System.out.println("🚢🔥");
        Esperar(500);
        clear();
        System.out.println("🚢💨");
        Esperar(500);
        clear();
        System.out.println("💥💥");
        Esperar(500);
        clear();
        System.out.println("🔥🔥");
        Esperar(500);
        clear();
        System.out.println("💨💨");
        Esperar(500);
    }

     static void hundirBarco(Barco[][] operador, String[][] tablero, int x, int y, boolean jugador) {
        animacionExplosion(); // Llamada a la animación de explosión
        System.out.println(operador[y][x].getNombre() + " ha sido hundido🛟🚩");
        if (jugador) {
            Jugador1.contadorBarcos--;
            System.out.println("Quedan " + Jugador1.contadorBarcos + " por eliminar");
        } else if (!jugador) {
            Jugador2.contadorBarcos--;
            System.out.println("Quedan " + Jugador2.contadorBarcos + " por eliminar");
        }
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (operador[i][j] == operador[y][x] && operador[i][j] != null) {
                    tablero[i][j] = "❌";
                    operador[i][j] = null;
                }
            }
        }
    }
     static void Turnos (Scanner input, ArrayList<Integer> Jugador1X, ArrayList<Integer> Jugador1Y, ArrayList<Integer> Jugador2X, ArrayList<Integer> Jugador2Y, String[][] tablero1, String[][] tablero2, Barco[][] operador1, Barco[][] operador2){
        boolean verificacion1 = true, verificacion2=true;
        do {
            verificacion2=true;
            if (verificacion1) {
                    try {
                    Libreria.imprimirTablero(tablero1);
                    System.out.println("Jugador 1");
                    Libreria.verificacionDisparo(input, Jugador1X, Jugador1Y, operador2, tablero2,true);
                    verificacion2=true;
                    if (Jugador2.getContadorBarcos() == 0) {
                        verificacion2=false;
                    }
                } catch (Exception e) {
                    System.out.println("Indica una posicion de disparo valida");
                    Libreria.Esperar(2000);
                    Libreria.clear();
                    input.nextLine();
                    verificacion2 = false;
                }
            }
            verificacion1=true;
            Libreria.Esperar(1000);
            Libreria.clear();
            if (verificacion2) {
                try {
                    Libreria.imprimirTablero(tablero2);
                    System.out.println("Jugador 2");
                    Libreria.verificacionDisparo(input, Jugador2X, Jugador2Y, operador1, tablero1,false);
                    verificacion1=true;
                    if (Jugador1.getContadorBarcos() == 0) {
                        verificacion1=false;
                    }
                } catch (Exception e) {
                    System.out.println("Indica una posicion de disparo valida");
                    Libreria.Esperar(2000);
                    Libreria.clear();
                    input.nextLine();
                    verificacion1=false;
                }
            }
        } while (Jugador1.getContadorBarcos() != 0 && Jugador2.getContadorBarcos() != 0);// Se termina el juego cuando alguno de los dos llegan a 0 en contar barcos
    }
}