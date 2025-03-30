package Tema6.TorneoVideojuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class menuPrincipal {
    static Scanner input = new Scanner(System.in);
    static int opcion;
    static List<jugador> listJugadores = new ArrayList<>();
    static List<equipo> listEquipos = new ArrayList<>();
    static List<torneo> listTorneos = new ArrayList<>();
    static boolean verificacion = true;
    static Random random = new Random();
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
                        listarJugadores();
                        break;
                    case 10:
                        listarEquipos();
                        break;
                    case 11:
                        listarTorneos();
                        break;
                    case 12:
                        buscarJugadorId();
                        break;
                    case 13:
                        borrarJugador();
                        break;
                    case 14:
                        borrarEquipoVacio();
                        break;
                    case 15:
                        System.out.println("Gracias por usar nuestro programa");
                        break;
                    case 16:
                        tranferirJugadores();
                        break;
                    case 17:
                        clasificacionTorneo();
                        break;
                    case 18:
                        generarTorneo();
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (opcion != 15);
    }

    private static void generarTorneo() {
        torneo torneo = buscarTorneo();
        if (torneo.getListEquipos().size()<2)
        throw new IllegalArgumentException("Tiene que haber la menos 2 equipos");
        for (equipo equipo : torneo.getListEquipos()) {
            for (int i = 0; i < torneo.getListEquipos().size()-1; i++) {
                int num = random.nextInt(101); 
                torneo.aumentarPuntuacion(equipo, num);
            }
        }
    }

    private static void clasificacionTorneo() {
        torneo torneo = buscarTorneo();
        System.out.println(torneo.getPuntuaciones());
    }

    private static void tranferirJugadores() {
        equipo equipo = buscarEquipo();
        if (equipo.getListJugadores().size()>=equipo.getCapacidadMax()) 
        throw new IllegalArgumentException("El equipo esta lleno, busque otro equipo");
        jugador jugador = buscarJugador();
        if (jugador.getEquipo()==null)
        throw new IllegalArgumentException("EL jugador no puede ser transferido ya que no esta asignado a ningun equipo");
        jugador.getEquipo().borrarJugador(jugador);
        equipo.setListJugadores(jugador);
    }

    public static void borrarEquipoVacio() {
        equipo equipo = buscarEquipo();
        if (equipo.getListJugadores().isEmpty()) {
            listEquipos.remove(equipo);
            for (torneo torneo : listTorneos) {
                torneo.borrarEquipo(equipo);
            }
        } else {
            throw new IllegalArgumentException("El equipo no se puede borrar, contiene jugadores");
        }
    }

    public static void borrarJugador() {
        jugador jugador = buscarJugador();
        jugador.removeID(jugador);
        listJugadores.remove(jugador);
        jugador.getEquipo().borrarJugador(jugador);
        for (torneo torneo : listTorneos) {
            torneo.borrarJugador(jugador);
        }
    }

    public static void buscarJugadorId() {
        System.out.println(buscarJugador());
    }

    public static void listarEquipos() {
        System.out.println(listEquipos);
    }

    public static void listarTorneos() {
        System.out.println(listTorneos);
    }

    public static void listarJugadores() {
        System.out.println(listJugadores);
    }

    public static void listarJugadoreEquipo() {
        for (jugador jugador : buscarEquipo().getListJugadores()) {
            System.out.println(jugador);
        }
    }

    public static void registrarPuntuacionEquipo() {
        buscarTorneo().setPuntuaciones(buscarEquipo(), puntuacion());
    }

    public static int puntuacion() {
        System.out.println("Indica la puntuacion del equipo");
        return input.nextInt();
    }

    public static void asignarEquipoATorneo() {
        torneo torneo = buscarTorneo();
        torneo.setListEquipos(buscarEquipo());
        System.out.println(torneo);
    }

    public static void crearTorneo() {
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

    public static void cambiarRangoJugador() {
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
                    for (equipo equipo1 : listEquipos) {
                        System.out.println(equipo1.getCodigoEquipo());
                    }
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
                    for (torneo torneo1 : listTorneos) {
                        System.out.println(torneo1.getCodigoTorneo());
                    }
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
                    for (jugador jugador1 : listJugadores) {
                        System.out.println(jugador1.getIdJugador());
                    }
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
