package Tema6.TorneoVideojuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuPrincipal {
    static Scanner input = new Scanner(System.in);
    static int opcion;
    static List<jugador> listJugadores = new ArrayList<>();
    static List<equipo> listEquipos = new ArrayList<>();
    static List<torneo> listTorneos = new ArrayList<>();
    static boolean verificacion = true;

    public static void main(String[] args) {
        do {
            try {
                mostrarMenu();
                try {
                    opcion = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println(e);
                }
                switch (opcion) {
                    case 1:
                        crearUnNuevoJugador();
                        break;
                    case 2:
                        crearUnNuevoEquipo();
                        break;
                    case 3:
                        asignarJugadorEquipo();
                        break;
                    case 4:
                        cambiarRangoJugador();
                        break;
                    case 5:
                        crearTorneo();
                        break;
                    case 6:
                        asignarEquipoATorneo();
                        break;
                    case 7:
                        registrarPuntuacionEquipo();
                        break;
                    case 8:
                        listarJugadoreEquipo();
                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:

                        break;
                    case 12:

                        break;
                    case 13:

                        break;
                    case 14:

                        break;
                    case 15:

                        break;
                    case 16:

                        break;
                    case 17:

                        break;
                    case 18:

                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (opcion != 15);
    }

    private static void listarJugadoreEquipo() {
        for (jugador jugador : buscarEquipo().getListJugadores()) {
            System.out.println(jugador);
        }
    }

    private static void registrarPuntuacionEquipo() {
        buscarTorneo().setPuntuaciones(buscarEquipo(), puntuacion());
    }

    private static int puntuacion() {
        System.out.println("Indica la puntuacion del equipo");
        return input.nextInt();
    }

    private static void asignarEquipoATorneo() {
        torneo torneo = buscarTorneo();
        torneo.setListEquipos(buscarEquipo());
        System.out.println(torneo);
    }

    private static void crearTorneo() {
        torneo torneo = new torneo();
        do {
            try {
                verificacion = true;
                System.out.println("Indica codigo de torneo");
                torneo.setCodigoTorneo(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Indica nombre de torneo");
                torneo.setNombreTorneo(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        listTorneos.add(torneo);
    }

    private static void cambiarRangoJugador() {
        jugador jugador = buscarJugador();
        System.out.println("Indica un nuevo rango");
        jugador.setRango(input.nextLine());
    }

    public static void asignarJugadorEquipo() {
        equipo equipo = buscarEquipo();
        jugador jugador = buscarJugador();
        jugador.setEquipo(equipo);
        equipo.setListJugadores(jugador);
    }

    public static equipo buscarEquipo() {
        if (listEquipos.isEmpty()) {
            throw new IllegalArgumentException("No existen equipos");
        } else {
            equipo equipo = new equipo();
            do {
                try {
                    verificacion = false;
                    System.out.println(listEquipos);
                    System.out.println("Indica el codigo de equipo");
                    String codigo = input.nextLine();
                    for (equipo equipo2 : listEquipos) {
                        if (codigo.equals(equipo2.getCodigoEquipo())) {
                            equipo = equipo2;
                            verificacion = true;
                        }
                    }
                    if (!verificacion) {
                        throw new IllegalArgumentException("Equipo no encontrado");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (!verificacion);
            return equipo;
        }
    }

    public static torneo buscarTorneo() {
        if (listTorneos.isEmpty()) {
            throw new IllegalArgumentException("No existen torneos");
        } else {
            torneo torneo = new torneo();
            do {
                try {
                    verificacion = false;
                    System.out.println(listTorneos);
                    System.out.println("Indica el codigo de torneo");
                    String codigo = input.nextLine();
                    for (torneo torneo2 : listTorneos) {
                        if (codigo.equals(torneo2.getCodigoTorneo())) {
                            torneo = torneo2;
                            verificacion = true;
                        }
                    }
                    if (!verificacion) {
                        throw new IllegalArgumentException("torneo no encontrado");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (!verificacion);
            return torneo;
        }
    }

    public static jugador buscarJugador() {
        if (listJugadores.isEmpty()) {
            throw new IllegalArgumentException("No existen jugadores");
        } else {
            jugador jugador = new jugador();
            do {
                try {
                    verificacion = false;
                    System.out.println(listJugadores);
                    System.out.println("Indica el id del jugador");
                    String codigo = input.nextLine();
                    for (jugador jugador2 : listJugadores) {
                        if (codigo.equals(jugador2.getIdJugador())) {
                            jugador = jugador2;
                            verificacion = true;
                        }
                    }
                    if (!verificacion) {
                        throw new IllegalArgumentException("jugador no encontrado");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (!verificacion);
            return jugador;
        }
    }

    public static void crearUnNuevoEquipo() {
        equipo equipo = new equipo();
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el codigo del equipo");
                equipo.setCodigoEquipo(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el nombre del equipo");
                equipo.setNombreEquipo(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);

        listEquipos.add(equipo);
    }

    public static void crearUnNuevoJugador() {
        jugador jugador = new jugador();
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el id del jugador");
                jugador.setIdJugador(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el nombre del jugador");
                jugador.setNombre(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce la edad del jugador");
                jugador.setEdad(input.nextInt());
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el rango del jugador");
                jugador.setRango(input.nextLine());
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
        listJugadores.add(jugador);
    }

    static void mostrarMenu() {
        System.out.println("MENÚ PRINCIPAL\r\n" + //
                "1.Crear un nuevo jugador.\r\n" + //
                "2.Crear un nuevo equipo.\r\n" + //
                "3.Asignar un jugador a un equipo.\r\n" + //
                "4.Cambiar el rango de un jugador.\r\n" + //
                "5.Crear un nuevo torneo.\r\n" + //
                "6.Asignar equipos a un torneo.\r\n" + //
                "7.Registrar puntuaciones en un torneo.\r\n" + //
                "8.Listar los jugadores de un equipo específico.\r\n" + //
                "9.Listar todos los jugadores.\r\n" + //
                "10.Listar todos los equipos.\r\n" + //
                "11.Listar todos los torneos.\r\n" + //
                "12.Buscar jugador por ID.\r\n" + //
                "13.Eliminar jugador.\r\n" + //
                "14.Eliminar equipo (solo si está vacío).\r\n" + //
                "15.Salir del programa.\r\n" + //
                " EXTRA\r\n" + //
                "16.Transferir jugador entre equipos.\r\n" + //
                "17.Generar clasificaciones de un torneo.\r\n" + //
                "18.Simular un torneo automáticamente.");
    }
}
