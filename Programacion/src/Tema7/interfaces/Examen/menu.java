package Tema7.interfaces.Examen;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class menu {
    static boolean verificacion;
    static int nivelAutonomia, capacidad;
    static Set<VehiculoInteligente> listVehiculos = new HashSet<>();
    static String matricula, tipo, estacion, opcion;
    static Scanner input = new Scanner(System.in);
    static AutobusElectrico autovus = new AutobusElectrico("AAAA-001", 2);

    public static void main(String[] args) {
        do {
            try {
                System.out.println("1.Registrar un nuevo vehículo\r\n" + //
                        "2.Arrancar un vehículo por matrícula\r\n" + //
                        "3.Detener un vehículo por matrícula\r\n" + //
                        "4.Mostrar estado de todos los vehículos\r\n" + //
                        "5.Mostrar historial de un vehículo por matrícula\r\n" + //
                        "6.Programar trayecto (inicio/parada) por matrícula\r\n" + //
                        "7.Salir del programa");
                opcion = input.nextLine();
                switch (opcion) {
                    case "1":
                        registrarVehiculoNuevo();
                        break;
                    case "2":
                        arrancarUnVehiculo();
                        break;
                    case "3":
                        pararUnVehiculo();
                        break;
                    case "4":
                        mostrarEstado();
                        break;
                    case "5":
                        mostrarHistorial();
                        break;
                    case "6":
                        programarTrayecto();
                        break;
                    case "7":
                        System.out.println("Gracias por usar nuestro programa");
                        break;
                    default:
                        System.out.println("Por favor eliga una opcion valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (!opcion.equals("7"));
    }

    public static void programarTrayecto() {
        System.out.println("Indique la matricula del vehiculo que desea buscar");
        matricula = input.nextLine();
        VehiculoInteligente vehiculoTemporal = null;
        for (VehiculoInteligente vehiculo : listVehiculos) {
            if (matricula.equals(vehiculo.getMatricula()))
                vehiculoTemporal = vehiculo;
        }
        System.out.println("Indique una accion i/iniciar p/parar");
        String accion = input.nextLine();
        System.out.println("Indicame la hora");
        String hora = input.nextLine();
        if (vehiculoTemporal instanceof Programable) {
            Programable p = (Programable) vehiculoTemporal;
            if (accion.equals("i")) {
                p.programarInicio(hora);

            } else if (accion.equals("p")) {
                p.programarParada(hora);
            }
        } else {
            Programable horario = new Programable() {
                @Override
                public void programarInicio(String hora) {
                    System.out.println("Hora inicio:" + hora);
                }

                @Override
                public void programarParada(String hora) {
                    System.out.println("Hora parada:" + hora);
                }
            };
            if (accion.equals("i")) {
                horario.programarInicio(hora);
            } else if (accion.equals("p")) {
                horario.programarParada(hora);
            }
        }
    }

    public static void mostrarEstado() {
        for (VehiculoInteligente vehiculoInteligente : listVehiculos) {
            vehiculoInteligente.mostrarEstado();
            System.out.println();
        }
    }

    public static void arrancarUnVehiculo() {
        System.out.println("Indique la matricula del vehiculo que desea buscar");
        matricula = input.nextLine();
        for (VehiculoInteligente vehiculo : listVehiculos) {
            if (matricula.equals(vehiculo.getMatricula()))
                vehiculo.arrancar();
        }
    }

    public static void mostrarHistorial() {
        System.out.println("Indique la matricula del vehiculo que desea buscar");
        matricula = input.nextLine();
        for (VehiculoInteligente vehiculo : listVehiculos) {
            if (matricula.equals(vehiculo.getMatricula()))
                vehiculo.mostrarHistorial();
        }
    }

    public static void pararUnVehiculo() {
        System.out.println("Indique la matricula del vehiculo que desea buscar");
        matricula = input.nextLine();
        for (VehiculoInteligente vehiculo : listVehiculos) {
            if (matricula.equals(vehiculo.getMatricula()))
                vehiculo.detener();
        }
    }

    public static void registrarVehiculoNuevo() {
        System.out.println("Indique el tipo de vehiculo Coche/Autobus/Bicicleta");
        tipo = input.nextLine().toLowerCase();
        System.out.println("Indique matricula");
        matricula = input.nextLine();
        switch (tipo) {
            case "coche":
                System.out.println("Indique el nivel de autonomia");
                nivelAutonomia = input.nextInt();
                input.nextLine();
                boolean verificaciones = listVehiculos.add(new CocheAutonomo(matricula, nivelAutonomia));
                if (verificaciones) {
                    System.out.println("Coche autónomo añadido correctamente.");
                } else {
                    System.out.println(
                            "No se pudo añadir el vehículo. Quizás ya existe un vehículo con la misma matrícula.");
                }
                break;
            case "autobus":
                System.out.println("Indique capacidad");
                capacidad = input.nextInt();
                input.nextLine();
                verificaciones = listVehiculos.add(new AutobusElectrico(matricula, capacidad));
                if (verificaciones) {
                    System.out.println("Autobus añadido correctamente.");
                } else {
                    System.out.println(
                            "No se pudo añadir el vehículo. Quizás ya existe un vehículo con la misma matrícula.");
                }
                break;
            case "bicicleta":
                System.out.println("Indique estacion");
                estacion = input.nextLine();
                verificaciones = listVehiculos.add(new BicicletaCompartida(matricula, estacion));
                if (verificaciones) {
                    System.out.println("Bicicleta añadido correctamente.");
                } else {
                    System.out.println(
                            "No se pudo añadir el vehículo. Quizás ya existe un vehículo con la misma matrícula.");
                }
                break;
            default:
        }
    }
}