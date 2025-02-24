package src.Tema6.empresaFerroviaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class central {
    static boolean verificacion = true;
    static String nombre = "", dni = "", telefono = "", matricula = "", codigoRuta = "", codigoConductor = "";
    static int años = 0, opcion = 0, capacidadMaxima = 0, parada = 0;
    static double kilometros = 0.00;
    static List<conductor> conductorList = new ArrayList<>();
    static List<autobus> autobusList = new ArrayList<>();
    static List<ruta> rutalist = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        inicializarDatos();
        do {
            clear();
            menu();
            try {
                switch (opcion) {
                    case 1:
                        case1();
                        break;
                    case 2:
                        case2();
                        break;
                    case 3:
                        case3();
                        break;
                    case 4:
                        case4();
                        break;
                    case 5:
                        case5();
                        break;
                    case 6:
                        case6();
                        break;
                    case 7:
                        case7();
                        break;
                    case 8:
                        case8();
                        break;
                    case 9:
                        case9();
                        break;
                    case 10:
                        System.out.println("Gracias por usar nuestro programa");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                clear();
                System.out.println(e);
                input.nextLine();
            }
        } while (opcion != 10);
        input.close();
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
            clear();
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }

    public static void enter(Scanner input) {
        System.out.println("Presiona ENTER para continuar...");
        input.nextLine();
        clear();
    }
    static void menu() {
        System.out.println(
                "-----------------------------------------Elije-una-opcion----------------------------------------\n"
                        +
                        "  1.Registrar un nuevo conductor, ingresando todos sus datos y verificando que no esté repetido.\n"
                        +
                        "  2.Registrar una nueva ruta, asegurando que el código sea único y tenga al menos dos paradas.\n"
                        +
                        "  3.Registrar un nuevo autobús, seleccionando un conductor y una ruta disponibles.\n" +
                        "  4.Consultar la información de un autobús, mostrando detalles de su conductor y la ruta en la que opera.\n"
                        +
                        "  5.Listar todos los autobuses registrados, junto con sus asignaciones actuales.\n" +
                        "  6.Modificar la ruta de un autobús, asegurando que la anterior quede libre si el cambio se realiza.\n"
                        +
                        "  7.Cambiar el conductor de un autobús, liberando al conductor anterior y asignando uno nuevo.\n"
                        +
                        "  8.Listar todos los conductores, mostrando si están asignados o no a un autobús.\n" +
                        "  9.Listar todas las rutas registradas, indicando cuáles están disponibles y cuáles tienen autobuses en operación.\n"
                        +
                        "  10.Salir del sistema, finalizando la ejecución del programa");
        opcion = input.nextInt();
        input.nextLine();
    }

    static void case1() {
        clear();
        conductorList.add(new conductor());
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa nombre");
                nombre = input.nextLine();
                conductorList.getLast().setNombre(nombre);
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa dni");
                dni = input.nextLine();
                conductorList.getLast().setDni(dni);
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa nº de años de experiencia");
                años = input.nextInt();
                input.nextLine();
                conductorList.getLast().setAñoExperiencia(años);
            } catch (Exception e) {
                clear();
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa telefono");
                telefono = input.nextLine();
                conductorList.getLast().setTelefono(telefono);
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        System.out.println("Conductor creado con existo");
        System.out.println(conductorList.getLast().toString());
        enter(input);
    }

    static void case2() {
        clear();
        rutalist.add(new ruta());
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa codigo de ruta");
                codigoRuta = input.nextLine();
                rutalist.getLast().setCodigoRuta(codigoRuta);
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa numero de paradas");
                parada = input.nextInt();
                input.nextLine();
                rutalist.getLast().setParadas(parada);
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa kilometros");
                kilometros = input.nextDouble();
                input.nextLine();
                rutalist.getLast().setKilometros(kilometros);
                ;
            } catch (Exception e) {
                clear();
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        System.out.println("ruta creado con existo");
        System.out.println(rutalist.getLast().toString());
        enter(input);
    }

    static void case3() {
        autobusList.add(new autobus());
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa matricula");
                matricula = input.nextLine();
                autobusList.getLast().setMatricula(matricula);
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = true;
                System.out.println("Ingresa capacidad maxima");
                capacidadMaxima = input.nextInt();
                input.nextLine();
                autobusList.getLast().setCapacidadMaxima(capacidadMaxima);
            } catch (Exception e) {
                clear();
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = false;
                for (conductor conductor : conductorList) {
                    System.out.println(conductor);
                }
                System.out.println("Ingrese el conductor del autobus");
                nombre = input.nextLine();
                for (conductor conductor : conductorList) {
                    if (conductor.getNombre().equalsIgnoreCase(nombre)) {
                        autobusList.getLast().setConductor(conductor);
                        verificacion = true;
                    }
                }
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        clear();
        do {
            try {
                verificacion = false;
                for (ruta ruta : rutalist) {
                    System.out.println(ruta);
                }
                System.out.println("Ingrese una ruta");
                codigoRuta = input.nextLine();
                for (ruta ruta : rutalist) {
                    if (ruta.getCodigoRuta().equalsIgnoreCase(codigoRuta)) {
                        autobusList.getLast().setRuta(ruta);
                        verificacion = true;
                    }
                }
            } catch (Exception e) {
                clear();
                System.out.println(e);
                verificacion = false;
            }
            clear();
            System.out.println("Autobus creado con exito");
            System.out.println(autobusList.getLast().toString());
        } while (!verificacion);
    }

    static void case4() {
        clear();
        for (autobus autobus : autobusList) {
            System.out.println(autobus.getMatricula());
            System.out.println();
        }
        System.out.println("Selecciona el autobus que desea consultar ");
        matricula = input.nextLine();
        for (autobus autobus : autobusList) {
            if (autobus.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println(autobus.toString());
            }
        }
        enter(input);
    }

    static void case5() {
        clear();
        for (autobus autobus : autobusList) {
            System.out.println(autobus.toString());
        }
        enter(input);
    }

    static void case6() {
        clear();
        for (autobus autobus : autobusList) {
            System.out.println(autobus.getMatricula());
        }
        try {
            System.out.println("Selecciona el autobus que desea cambiar su ruta ");
            matricula = input.nextLine();
            clear();
            for (autobus autobus : autobusList) {
                if (autobus.getMatricula().equalsIgnoreCase(matricula)) {
                    System.out.println("Ruta actual");
                    System.out.println(autobus.getRuta());
                    System.out.println("Ingrese una nueva ruta\nRutas disponibles: ");
                    for (ruta ruta : rutalist) {
                        if (!ruta.isRutaAsignada()) {
                            System.out.println(ruta.toString());
                        }
                    }
                    System.out.print("Ingrese el identificador: ");
                    codigoRuta = input.nextLine();
                    for (ruta ruta : rutalist) {
                        if (ruta.getCodigoRuta().equalsIgnoreCase(codigoRuta)) {
                            autobus.modificarRuta(ruta);
                        }
                    }
                }
                clear();
            }
        } catch (Exception e) {
            clear();
            System.out.println(e);
        }
    }

    static void case7() {
        try {
            clear();
            for (autobus autobus : autobusList) {
                System.out.println(autobus.getMatricula());
            }
            System.out.println("Selecciona el autobus que desea cambiar su conductor ");
            nombre = input.nextLine();
            clear();
            for (autobus autobus : autobusList) {
                if (autobus.getMatricula().equalsIgnoreCase(nombre)) {
                    System.out.println("conductor actual");
                    System.out.println(autobus.getConductor());
                    System.out.println("Ingrese un nueva conductor\nConductores disponibles: ");
                    for (conductor conductor : conductorList) {
                        if (!conductor.isAsignado()) {
                            System.out.println(conductor.toString());
                        }
                    }
                    System.out.print("Ingrese el nombre del conductor: ");
                    codigoConductor = input.nextLine();
                    for (conductor conductor : conductorList) {
                        if (conductor.getNombre().equalsIgnoreCase(codigoConductor)) {
                            autobus.modificarConductor(conductor);
                        }
                    }
                }
                clear();
            }
        } catch (Exception e) {
            clear();
            System.out.println(e);
        }
    }

    static void case8() {
        for (conductor conductor : conductorList) {
            System.out.println(conductor.toString());
            if (conductor.isAsignado()) {
                System.out.println("El conductor esta asignado");
            } else {
                System.out.println("El conductor esta libre");
            }
        }
        enter(input);
    }

    static void case9() {
        for (ruta ruta : rutalist) {
            System.out.println(ruta.toString());
            if (ruta.isRutaAsignada()) {
                System.out.println("La ruta esta asignado");
            } else {
                System.out.println("La ruta esta libre");
            }
        }
        enter(input);
    }
    static void inicializarDatos() {
        conductorList.add(new conductor("Juan Perez", "12345678A", 5, "123456789", verificacion));
        conductorList.add(new conductor("Maria Lopez", "87654321B", 3, "987654321", verificacion));

        rutalist.add(new ruta("R001", 5, 10.5, verificacion));
        rutalist.add(new ruta("R002", 3, 7.2, verificacion));

        autobusList.add(new autobus("ABC123", 50, conductorList.get(0), rutalist.get(0), verificacion));
        autobusList.add(new autobus("XYZ789", 40, conductorList.get(1), rutalist.get(1), verificacion));
    }
}
