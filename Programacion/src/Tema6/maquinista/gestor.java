package Tema6.maquinista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class gestor {
    public static void main(String[] args) {
        clear();
        int opcionMenu = 0;
        String dni;
        Scanner input = new Scanner(System.in);
        List<maquinista> maquinistaList = new ArrayList<>();
        List<mecanicos> mecanicoList = new ArrayList<>();
        List<jefeEstacion> jefeList = new ArrayList<>();
        List<locomotoras> locomotoraList = new ArrayList<>();
        List<trenes> trainList = new ArrayList<>();
        Set<vagon> vagonList = new HashSet();
        Set<vagon> vagonListSuplementario = new HashSet();
        vagonList.add(new vagon(458, 6000, 5000, "Granos"));
        vagonList.add(new vagon(459, 6000, 5000, "Pasajeros"));
        vagonList.add(new vagon(460, 9000, 8000, "Liquidos"));
        vagonList.add(new vagon(461, 5005, 5000, "Materiales pesados"));
        vagonList.add(new vagon(462, 7000, 6000, "Liquidos"));
        maquinistaList.add(new maquinista("Juan", "12345678A", 3000.0, "titular"));
        mecanicoList.add(new mecanicos("Pedro", "987654321", "frenos"));
        jefeList.add(new jefeEstacion("Luis", "87654321B", LocalDate.parse("2020-01-01")));
        locomotoraList.add(new locomotoras("AA1234", 2000, 2010, mecanicoList.get(0)));
        trainList.add(new trenes("TR-0001", locomotoraList.get(0), maquinistaList.get(0), vagonList));
        do {
            try {
                System.out.println(
                        "----------Elije una opcion del menu:----------\n1.Crear empleados\n2.Crear locomotora\n3.Crear trenes\n4.Visualizar informacion de un tren\n5.Modificar la carga de un vagon\n6.Listar los trenes\n7.Salir del programa");
                opcionMenu = input.nextInt();
                input.nextLine();
                clear();
                switch (opcionMenu) {
                    case 1:
                        try {
                            System.out.println(
                                    "Selecciona el tipo de empleado que desea crear (Maquinista, mecanico o jefe de estacion)");
                            String tipoEmpleado = input.nextLine();
                            clear();
                            System.out.print("Introduce el nombre:");
                            String nombreEmpleado = input.nextLine();
                            clear();
                            switch (tipoEmpleado.toLowerCase()) {
                                case "maquinista":
                                    System.out.print("Introduce dni (00000000A):");
                                    dni = input.nextLine();
                                    clear();
                                    System.out.print("Introduce sueldo (1200-5000):");
                                    double sueldo = input.nextDouble();
                                    input.nextLine();
                                    clear();
                                    System.out.print("Introduce rango (ayudante/titular/supervisor):");
                                    String rango = input.nextLine();
                                    maquinistaList.add(new maquinista(nombreEmpleado, dni, sueldo, rango));
                                    System.out.println();
                                    for (maquinista maquinista1 : maquinistaList) {
                                        System.out.println(maquinista1.toString());
                                    }
                                    Enter(input);
                                    break;
                                case "mecanico":
                                    System.out.print("Introduce telefono (000000000):");
                                    String telefono = input.nextLine();
                                    clear();
                                    System.out.print("Introduce especialidad (frenos/hidraulica/electricidad/motor):");
                                    String especialidad = input.nextLine();
                                    mecanicoList.add(new mecanicos(nombreEmpleado, telefono, especialidad));
                                    System.out.println();
                                    for (mecanicos mecanico : mecanicoList) {
                                        System.out.println(mecanico.toString());
                                    }
                                    Enter(input);
                                    break;
                                case "jefe de estacion":
                                    System.out.print("Introduce dni:");
                                    dni = input.nextLine();
                                    clear();
                                    System.out.print("Introduce fecha de nombramiento (YYYY-MM-DD):");
                                    String fechaNombramiento = input.nextLine();
                                    jefeList.add(
                                            new jefeEstacion(nombreEmpleado, dni, LocalDate.parse(fechaNombramiento)));
                                    System.out.println();
                                    for (jefeEstacion jefe : jefeList) {
                                        System.out.println(jefe.toString());
                                    }
                                    Enter(input);
                                    break;
                                default:
                                    System.out.println("Escoja un tipo de empleado correcto");
                                    break;
                            }
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 2:
                        try {
                            int i = 0;
                            for (mecanicos mecanico : mecanicoList) {
                                System.out.println("id  " + i + " :");
                                i++;
                                System.out.println(mecanico.toString());
                            }
                            System.out.println();
                            System.out.println("Seleccione su mecanico");
                            int mecanico = input.nextInt();
                            input.nextLine();
                            clear();
                            System.out.println("Introduce matricula (AA0000)");
                            String matricula = input.nextLine();
                            clear();
                            System.out.println("Introduce potencia (500-5000)");
                            int potencia = input.nextInt();
                            input.nextLine();
                            clear();
                            System.out.println("Introduce año de fabricacion(>1950)");
                            int añoFabricacion = input.nextInt();
                            input.nextLine();
                            clear();
                            locomotoraList.add(
                                    new locomotoras(matricula, potencia, añoFabricacion, mecanicoList.get(mecanico)));
                            for (locomotoras locomotoras : locomotoraList) {
                                System.out.println(locomotoras.toString());
                            }
                            Enter(input);
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 3:
                        try {
                            int opcion = 0;
                            do {
                                System.out.println("Que opcion desea: \n1.Crear vagones \n2.Crear tren");
                                opcion = input.nextInt();
                                clear();
                                switch (opcion) {
                                    case 1:
                                        System.out.println("Cuantos vagones desea crear?");
                                        int numeroVagones = input.nextInt();
                                        for (int i = 0; i < numeroVagones; i++) {
                                            System.out.println("Ingresa numero de identificacion");
                                            int numeroIdentificacion = input.nextInt();
                                            input.nextLine();
                                            System.out.println("Ingresa carga maxima 5000-50000");
                                            double cargaMaxima = input.nextDouble();
                                            input.nextLine();
                                            System.out.println("Ingresa carga actual >5000");
                                            double cargaActual = input.nextDouble();
                                            input.nextLine();
                                            System.out.println("Ingresa tipo de carga Pasajeros, Granos, Liquidos, Materiales pesados");
                                            String tipoCarga = input.nextLine();
                                            vagonList.add(new vagon(numeroIdentificacion, cargaMaxima, cargaActual, tipoCarga));
                                            clear();
                                        }
                                        break;
                                    case 2:
                                        int contador = 0;
                                        int contador2 = 0;
                                        for (locomotoras locomotora : locomotoraList) {
                                            System.out.print("id " + contador + " :");
                                            contador++;
                                            System.out.println(locomotora.toString());
                                        }
                                        System.out.println("Selecciona una locomotora: ");
                                        int locomotora = input.nextInt();
                                        input.nextLine();
                                        clear();
                                        for (maquinista maquinista : maquinistaList) {
                                            System.out.print("id " + contador2 + " :");
                                            contador2++;
                                            System.out.println(maquinista.toString());
                                        }
                                        System.out.println("Selecciona un maquinista: ");
                                        int maquinista = input.nextInt();
                                        input.nextLine();
                                        clear();
                                        System.out.println("Indica el identificador del tren (TR-0000)");
                                        String identificador = input.nextLine();
                                        System.out.println("Cuantos vagones quieres acoplar? 1-5");
                                        int nVagones = input.nextInt();
                                        for (vagon vagon : vagonList) {
                                            System.out.println(vagon.getNumeroIdentificacion());
                                        }
                                        if (nVagones > 0 && nVagones < 6) {
                                            for (int i = 0; i < nVagones; i++) {
                                                System.out.println("Indique el id del vagon que quiere acoplar");
                                                int id = input.nextInt();
                                                input.nextLine();
                                                for (vagon vagon : vagonList) {
                                                    if (id == vagon.getNumeroIdentificacion()) {
                                                        vagonListSuplementario.add(vagon);
                                                    }
                                                }
                                            }
                                            trainList.add(new trenes(identificador, locomotoraList.get(locomotora),maquinistaList.get(maquinista), vagonListSuplementario));
                                            System.out.println(trainList.getLast().toString());
                                        } else {
                                            System.out.println("La cantidad minima de vagones es 1 y la maxima 5");
                                        }
                                        Enter(input);
                                        break;
                                    default:
                                        break;
                                }
                            } while (opcion != 2);
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 4:
                        for (trenes tren : trainList) {
                            System.out.println(tren.getIdentificador());
                        }
                        System.out.println("Selecciona un id para visualizar su informacion");
                        String idTren = input.nextLine();
                        clear();
                        for (trenes tren : trainList) {
                            if (idTren.equals(tren.getIdentificador())) {
                                System.out.println(tren);
                            }
                        }
                        Enter(input);
                        break;
                    case 5:
                        try {
                            for (trenes tren : trainList) {
                                System.out.println(tren.getIdentificador());
                            }
                            System.out.println("Selecciona un id para visualizar su informacion");
                            idTren = input.nextLine();
                            clear();
                            for (trenes tren : trainList) {
                                if (idTren.equals(tren.getIdentificador())) {
                                    System.out.println(tren.getVagones().toString());
                                    System.out.println("Seleccione un vagon para modificar su carga");
                                    int numIdentificacion = input.nextInt();
                                    for (vagon vagon : tren.getVagones()) {
                                        if (vagon.getNumeroIdentificacion() == numIdentificacion) {
                                            System.out.println("Introduce una carga nueva para el vagon");
                                            int nuevaCarga = input.nextInt();
                                            clear();
                                            vagon.setCargaActual(nuevaCarga);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 6:
                        for (trenes tren : trainList) {
                            System.out.println(tren.toString());
                        }
                        Enter(input);
                        break;
                    case 7:
                        System.out.println("Gracias por usar el programa");
                        break;
                    default:
                        System.out.println("Escoja una opcion valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                input.nextLine();
            }
        } while (opcionMenu != 7);
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
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }

    public static void Enter(Scanner input) {
        System.out.println("Presiona ENTER para continuar...");
        input.nextLine();
        clear();
    }
}