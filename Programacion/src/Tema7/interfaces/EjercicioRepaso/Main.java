package Tema7.interfaces.EjercicioRepaso;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Set<Vehiculo> ListaVehiculo = new HashSet<>();
    static Set<Persona> ListaConductores = new HashSet<>();
    public static void main(String[] args) {
        int resp = 0;
        int resp2 = 0;
        do {
            System.out.println("Dime que opcion quieres hacer");
            System.out.println("1. Autobus");
            System.out.println("2. Tren");
            System.out.println("3. Tranvia");
            System.out.println("4. Modificar matricula especifica");
            System.out.println("5. Modificar la capacidad");
            System.out.println("6. Eliimnar un vehiculo");
            System.out.println("7. Crear un conductor");
            resp = scanner.nextInt();
            scanner.nextLine();
            switch (resp) {
                case 1:
                try {
                    System.out.println("Dime la matricula del autobus");
                    String matricula=scanner.nextLine();
                    System.out.println("Dime la capacidad maxima del autobus");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine();
                    ListaVehiculo.add(new Autobus("Autobus",null,matricula, capacidad));
                } catch (Exception e) {
                    System.out.println(e);
                }
                    
                break;
                case 2:
                try {
                    System.out.println("Dime la matricula del autobus");
                    String matriculaT=scanner.nextLine();
                    System.out.println("Dime la capacidad maxima del autobus");
                    int capacidadT = scanner.nextInt();
                    scanner.nextLine();
                    ListaVehiculo.add(new Tren("Tren",null,matriculaT, capacidadT));
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                    break;
                case 3:
                try {
                    System.out.println("Dime la matricula del Tranvia");
                    String matriculaTr=scanner.nextLine();
                    System.out.println("Dime la capacidad maxima del Tranvia");
                    int capacidadTr = scanner.nextInt();
                    scanner.nextLine();
                    ListaVehiculo.add(new Tranvia("Tranvia",null,matriculaTr, capacidadTr));
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                    break;
                case 4:
                    modificarMatricula();
                    break;

                case 5:
                    modificarCapacidad();
                break;

                case 6:
                    EliminarVehiculo();
                break;

                case 7:
                try {
                    /*System.out.println("Dime el nombre del conductor");
                    String nombre=scanner.nextLine();
                    System.out.println("Dime el puesto del conductor: Autobusero Trenero Tranvianero");
                    String puesto = scanner.nextLine();
                    ListaConductores.add(new Persona(nombre, puesto));
                    System.out.println(ListaConductores.toString());*/
                    ListaConductores.add(new Persona("David Rodriguez", "Autobusero"));
                    ListaConductores.add(new Persona("Alejandro Vallin", "Trenero"));
                    ListaConductores.add(new Persona("Felix Venegas", "Tranvianero"));
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
                case 8:
                    asignarConductores();
                break;
                case 9:
                    ModificarPuesto();
                break;
                case 10:
                    ConducirAutobus();
                break;
                case 11:
                    ConducirTren();
                break;
                case 12:
                    ConducirTranvia();
                break;
                default:
                    break;
            }
        } while (resp != 99);

    }
    
    public static void modificarMatricula(){
        try {
            System.out.println("Dime la matricula que quieras modificar");
        for (Vehiculo vehiculo: ListaVehiculo) {
            System.out.println(vehiculo.getMatricula());
        }
        String matricula=scanner.nextLine();

        for (Vehiculo vehiculo : ListaVehiculo) {
            if(vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                System.out.println("Dime la nueva matricula");
                String nueva = scanner.nextLine();
                if(vehiculo.getMatricula().equalsIgnoreCase(nueva)){
                    throw new IllegalArgumentException("La nueva matricula no puede ser igual a la anterior");
                }else{
                    vehiculo.setMatricula(nueva);
                }
            }
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(ListaVehiculo.toString());
    }

    public static void modificarCapacidad(){
        try {
            System.out.println("Dime la matricula del vehiculo que quieras modificar su capacidad maxima");
        for (Vehiculo vehiculo : ListaVehiculo) {
            System.out.println(vehiculo.getMatricula());
        }
        String matricula = scanner.nextLine();
        for (Vehiculo vehiculo : ListaVehiculo) {
            if(vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                System.out.println("Dime la nueva capacidad del vehiculo");
                int numero=scanner.nextInt();
                if(vehiculo.getCapacidadMAX()==numero){
                    throw new IllegalArgumentException("El numero es el mismo que estaba antes, no se ha modificado");
                }else{
                    vehiculo.setCapacidadMAX(numero);
                }
            }
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(ListaVehiculo.toString());
    }

    public static void EliminarVehiculo(){
        Vehiculo ve=null;
        for (Vehiculo vehiculo : ListaVehiculo) {
            System.out.println(vehiculo.toString());
        }
        System.out.println("Dime la matricula del vehiculo que quieras eliminar");
        String matricula=scanner.nextLine();
        for (Vehiculo vehiculo : ListaVehiculo) {
            if(vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                ve=vehiculo;
            }
        }
        ListaVehiculo.remove(ve);
        ListaVehiculo.toString();
    }
    public static Vehiculo BuscarVehiculo(){
        Vehiculo vei=null;
        System.out.println("Dime la matricula del vehiculo que quieres buscar");
        String matricula=scanner.nextLine();
        for (Vehiculo vehiculo : ListaVehiculo) {
            if(vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                vei=vehiculo;
            }
        }
        return vei;
    }
    public static Persona BuscarConductor(){
        Persona per=null;
        System.out.println("Dime el nombre de la persona que quieres buscar");
        String matricula=scanner.nextLine();
        for (Persona persona : ListaConductores) {
            if(persona.getNombre().equalsIgnoreCase(matricula)){
                per=persona;
            }
        }
        return per;
    }
    public static void asignarConductores(){
        Vehiculo veiEncontrado = BuscarVehiculo();
        Persona perEncontrado = BuscarConductor();

        veiEncontrado.setConductor(perEncontrado);
        perEncontrado.setAsignado(true);

        System.out.println(veiEncontrado.toString());
    }
    public static void ModificarPuesto(){
        Persona perEncontrado = BuscarConductor();
        System.out.println("Dime la nueva funcion de conductor");
        String profesion = scanner.nextLine();
        perEncontrado.setPuesto(profesion);
        System.out.println(ListaConductores.toString());
    }

    public static void ConducirAutobus(){
        Vehiculo veiEncontrado = BuscarVehiculoPorTipo();
        veiEncontrado.arrancar();
        System.out.println("El autobus esta arrancado");
        System.out.println("---------------------------");
        veiEncontrado.detener();
        System.out.println("El autobus se ha detenido");
        System.out.println("---------------------------");
        veiEncontrado.MostrarInformacion();
        System.out.println("---------------------------");
        Ruta rut = new Ruta() {
            public void calcularRuta(){
                System.out.println("Calculando ruta...");
            }
            public void mostrarRuta(){
                System.out.println("Mostrando ruta...");
            }
        };
        rut.calcularRuta();
        rut.mostrarRuta();
    }
    public static Vehiculo BuscarVehiculoPorTipo(){
        Vehiculo vei=null;
        System.out.println("Dime el tipo del vehiculo que quieres buscar");
        String tipo=scanner.nextLine();
        for (Vehiculo vehiculo : ListaVehiculo) {
            if(vehiculo.getTipo().equalsIgnoreCase(tipo)){
                for (Vehiculo vehiculos : ListaVehiculo) {
                    if(vehiculos.getTipo().equalsIgnoreCase(tipo)){
                        System.out.println(vehiculos.toString());
                    }
                }
                System.out.println("Dime la matricula");
                String maitrcula=scanner.nextLine();
                for (Vehiculo vehiculos : ListaVehiculo) {
                    if(vehiculos.getMatricula().equalsIgnoreCase(maitrcula)){
                        vei=vehiculos;
                    }
                }
            }
        }
        return vei;
    }
    public static void ConducirTren(){
        Vehiculo veiEncontrado = BuscarVehiculoPorTipo();
        veiEncontrado.arrancar();
        System.out.println("El tren esta arrancado");
        System.out.println("---------------------------");
        veiEncontrado.detener();
        System.out.println("El tren se ha detenido");
        System.out.println("---------------------------");
        veiEncontrado.MostrarInformacion();
        System.out.println("---------------------------");
        Ruta rut = new Ruta() {
            public void calcularRuta(){
                System.out.println("Calculando ruta...");
            }
            public void mostrarRuta(){
                System.out.println("Mostrando ruta...");
            }
        };
        rut.calcularRuta();
        rut.mostrarRuta();
    }
    public static void ConducirTranvia(){
        Vehiculo veiEncontrado = BuscarVehiculoPorTipo();
        veiEncontrado.arrancar();
        System.out.println("El tranvia esta arrancado");
        System.out.println("---------------------------");
        veiEncontrado.detener();
        System.out.println("El tranvia se ha detenido");
        System.out.println("---------------------------");
        veiEncontrado.MostrarInformacion();
        System.out.println("---------------------------");
        Ruta rut = new Ruta() {
            public void calcularRuta(){
                System.out.println("Calculando ruta...");
            }
            public void mostrarRuta(){
                System.out.println("Mostrando ruta...");
            }
        };
        rut.calcularRuta();
        rut.mostrarRuta();
    }
}
