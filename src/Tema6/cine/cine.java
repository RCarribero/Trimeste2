package src.Tema6.cine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cine {
    static Scanner input = new Scanner(System.in);
    static int opcion = 0;
    static List<pelicula> peliculasList = new ArrayList<>();
    static List<cliente> clientesList = new ArrayList<>();
    static List<reserva> reservasList = new ArrayList<>();
    static boolean verificacion = true;

    public static void main(String[] args) {
        do {
            try {
                clear();
                menu();
                switch (opcion) {
                    case 1:
                        clear();
                        registrarPelicula();
                        break;
                    case 2:
                        clear();
                        registrarCliente();
                        break;
                    case 3:
                        clear();
                        registrarReserva();
                        break;
                    case 4:
                        clear();
                        cancelarReserva();
                        break;
                    case 5:
                        clear();
                        listarPeliculas();
                        break;
                    case 6:
                        clear();
                        listarClientes();
                        break;
                    case 7:
                        clear();
                        listarReserva();
                        break;
                    case 8:
                        clear();
                        System.out.println("Ciao");
                        break;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        } while (opcion != 8);
    }

    static void listarReserva() {
        for (reserva reserva : reservasList) {
            if (reserva.getEstadoReserva().equalsIgnoreCase("Activa")) {
                System.out.println(reserva.mostrarReserva());
            }
        }
        enter(input);
    }

    static void listarClientes() {
        for (cliente cliente : clientesList) {
            System.out.println(cliente.toString());
        }
        enter(input);
    }

    static void listarPeliculas() {
        for (pelicula pelicula : peliculasList) {
            System.out.println(pelicula.toString());
        }
        enter(input);
    }

    static void menu() {
        System.out.println("📋" + //
                " MENÚ PRINCIPAL\r\n" + //
                "1️⃣  Registrar una nueva película.\r\n" + //
                "2️⃣  Registrar un nuevo cliente.\r\n" + //
                "3️⃣  Reservar entradas para una película.\r\n" + //
                "4️⃣  Cancelar una reserva.\r\n" + //
                "5️⃣  Listar todas las películas disponibles.\r\n" + //
                "6️⃣  Listar todos los clientes registrados.\r\n" + //
                "7️⃣  Listar todas las reservas activas.\r\n" + //
                "8️⃣  Salir del programa.");
        opcion = input.nextInt();
        input.nextLine();
    }

    static void registrarPelicula() {
        peliculasList.add(new pelicula());
        do {
            try {
                verificacion = true;
                System.out.println("Indique el codigo de la pelicula (MOV-1234)");
                String codigoPelicula = input.nextLine();
                peliculasList.getLast().setCodigoPelicula(codigoPelicula);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println("Indique el titulo de la pelicula");
                String titulo = input.nextLine();
                peliculasList.getLast().setTituloPelicula(titulo);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println(
                        "Indique el genero de la pelicula ( Acción, Drama, Comedia, Terror, Ciencia Ficción, Animación)");
                String genero = input.nextLine();
                peliculasList.getLast().setGeneroPelicula(genero);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println("Indique la duracion de la pelicula");
                int duracionPelicula = input.nextInt();
                input.nextLine();
                peliculasList.getLast().setDuracionPelicula(duracionPelicula);
            } catch (IllegalArgumentException e) {
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println("Indique la clasificacion de la pelicula (ATP, +13, +16, +18)");
                String clasificacion = input.nextLine();
                peliculasList.getLast().setClasficacionPelicula(clasificacion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        enter(input);
    }

    static void registrarCliente() {
        clientesList.add(new cliente());
        do {
            try {
                verificacion = true;
                System.out.println("Indique el dni (12345678A)");
                String dni = input.nextLine();
                clientesList.getLast().setDniCliente(dni);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println("Indique nombre y apellido");
                String nombreApellido = input.nextLine();
                clientesList.getLast().setNombreApellidoCliente(nombreApellido);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Indique la edad");
                int edad = input.nextInt();
                input.nextLine();
                clientesList.getLast().setEdadCliente(edad);
            } catch (IllegalArgumentException e) {
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        enter(input);
    }

    static void registrarReserva() {
        reservasList.add(new reserva());
        cliente clienteDeseado = null;
        do {
            try {
                verificacion = true;
                for (cliente cliente : clientesList) {
                    System.out.println(cliente.getDniCliente() + " : " + cliente.getNombreApellidoCliente());
                }
                System.out.println("Indique que cliente es (dni)");
                String dniCliente = input.nextLine();
                clear();
                for (cliente cliente : clientesList) {
                    if (dniCliente.equalsIgnoreCase(cliente.getDniCliente())) {
                        clienteDeseado = cliente;
                    }
                }
                reservasList.getLast().setCliente(clienteDeseado);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        pelicula peliculaDeseada = null;
        do {
            try {
                verificacion = true;
                for (pelicula pelicula : peliculasList) {
                    System.out.println(pelicula.getCodigoPelicula() + " : " + pelicula.getTituloPelicula());
                }
                System.out.println("Indique la pelicula (codigo)");
                String codPelicula = input.nextLine();
                for (pelicula pelicula : peliculasList) {
                    if (codPelicula.equalsIgnoreCase(pelicula.getCodigoPelicula())) {
                        peliculaDeseada = pelicula;
                    }
                }
                reservasList.getLast().setPelicula(peliculaDeseada, clienteDeseado);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println("Indique la fecha en formato (2000-01-01T10:15:30)");
                String fechaHora = input.nextLine();
                reservasList.getLast().setFechaHora(LocalDateTime.parse(fechaHora));
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();

        do {
            try {
                verificacion = true;
                System.out.println("Indique la cantidad de entradas (no mayor a 5)");
                int entradas = input.nextInt();
                input.nextLine();
                reservasList.getLast().setNºEntradasReservadas(entradas);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clienteDeseado.setHistorialReservaCliente(reservasList.getLast());
        enter(input);
    }

    private static void cancelarReserva() {
        cliente clienteDeseado = null;
        int contador = 0;
        do {
            try {
                verificacion = true;
                for (cliente cliente : clientesList) {
                    System.out.println(cliente.getDniCliente() + cliente.getNombreApellidoCliente());
                }
                System.out.println("Indique que cliente es (dni)");
                String dniCliente = input.nextLine();
                for (cliente cliente : clientesList) {
                    if (dniCliente.equalsIgnoreCase(cliente.getDniCliente())) {
                        clienteDeseado = cliente;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                verificacion = false;
            }
            clear();

        } while (!verificacion);
        if (!clienteDeseado.getHistorialReservaCliente().isEmpty()) {
            for (reserva reserva : clienteDeseado.getHistorialReservaCliente()) {
                if (reserva.getEstadoReserva().equalsIgnoreCase("activa"))
                    System.out.println("id: " + contador + "\n" + reserva.toString() + "\n\n");
            }
            System.out.println("Seleccione el id de reserva para cancelar");
            int idReserva = input.nextInt();
            clienteDeseado.getHistorialReservaCliente().get(idReserva).setEstadoReserva("Cancelada");
        }
        enter(input);
    }

    public static void clear() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }

            processBuilder.inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }

    public static void enter(Scanner input) {
        System.out.println("Presiona ENTER para continuar...");
        input.nextLine();
        clear();
    }
}
