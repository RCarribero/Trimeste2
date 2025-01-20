import java.util.Scanner;

public class Tarea_global_1_trimestre {
    public static void main(String[] args) {
        int opcion=0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Bienvenido al menu de opciones\n1: Número de Armstrong\n2: Potenciación mediante multiplicaciones sucesivas\n3: Dibujar Figuras con *\n4: Cálculo de Descuentos mediante Sobrecarga de Métodos\n5: Salir");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un numero para comprobar si es de Armstong");
                    int numero=input.nextInt();
                    if (!numeroArmstrong(numero)) {
                        System.out.println("El numero "+numero+" no es de Armstrong");
                    } else {
                        System.out.println("El numero "+numero+" es de Armstrong");
                        
                    }
                    break;
                    case 2:
                    System.out.println("Ingrese la base");
                    int base=input.nextInt();
                    System.out.println("Ingrese el exponente");
                    int exponente=input.nextInt();
                    System.out.println("El resultado de la potenciación iterativa es: "+potenciacion(base, exponente));
                    System.out.println("El resultado de la potenciación recursiva es: "+potenciacionRecursiva(base, exponente));
                    break;
                    case 3:
                    System.out.println("Seleccione la figura a dibujar:");
                    System.out.println("1. Cuadrado");
                    System.out.println("2. Triángulo");
                    System.out.println("3. Pirámide");
                    System.out.println("4. Rombo");
                    int figura = input.nextInt();
                    System.out.println("Ingrese el tamaño (n):");
                    int n = input.nextInt();
                    if (n <= 0 || figura == 4 && n % 2 == 0) {
                        System.out.println("El tamaño debe ser mayor que 0 y, si es un rombo, debe ser impar.");
                        break;
                    }
                    switch (figura) {
                        case 1:
                            dibujarCuadrado(n);
                            break;
                        case 2:
                            dibujarTriangulo(n);
                            break;
                        case 3:
                            dibujarPiramide(n);
                            break;
                        case 4:
                            dibujarRombo(n);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                    case 4:
                    System.out.println("Seleccione el tipo de descuento:");
                    System.out.println("1. Descuento basado en cantidad comprada");
                    System.out.println("2. Descuento con código promocional");
                    System.out.println("3. Descuento según tipo de cliente");
                    int tipoDescuento = input.nextInt();
                    switch (tipoDescuento) {
                        case 1:
                            System.out.println("Ingrese el precio unitario:");
                            double precioUnitario = input.nextDouble();
                            System.out.println("Ingrese la cantidad de unidades compradas:");
                            int cantidad = input.nextInt();
                            System.out.println("El precio final es: " + calcularDescuento(precioUnitario, cantidad) + "€");
                            break;
                        case 2:
                            System.out.println("Ingrese el precio original:");
                            double precioOriginal = input.nextDouble();
                            System.out.println("Ingrese el código promocional:");
                            String codigoPromocional = input.next();
                            System.out.println("El precio final es: " + calcularDescuento(precioOriginal, codigoPromocional) + "€");
                            break;
                        case 3:
                            System.out.println("Ingrese el precio original:");
                            double precioCliente = input.nextDouble();
                            System.out.println("¿Es cliente frecuente? (SI/NO):");
                            String esFrecuente = input.next();
                            System.out.println("¿Es estudiante? (SI/NO):");
                            String esEstudiante = input.next();
                            System.out.println("El precio final es: " + calcularDescuento(precioCliente, esFrecuente, esEstudiante) + "€");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                    case 5:
                    System.out.println("Gracias por usar el programa.");
                    break;
                default:
                    throw new AssertionError();
                }
            } while (opcion!=5);
    }
    public static boolean  numeroArmstrong(int numero) {
        int valor=numero,tem=1,tem2=0,contenedor=0;
        boolean resultado=false;
        String num=numero+"";
        for (int i = 0; i < num.length(); i++) {
            contenedor=numero%10;
            numero=numero/10;
            for (int j = 0; j < num.length(); j++) {
                tem*=contenedor;
            }
            tem2+=tem;
            tem=1;
        }
        if (tem2==valor)
            resultado=true;
        return resultado;
    }
    public static int potenciacion(int base, int exponente) {
        int resultado=1;
        for (int i = 0; i < exponente; i++) {
            resultado*=base;
        }
        return resultado;
    }
    public static int potenciacionRecursiva(int base, int exponente) {
    if (exponente==0) {
        return 1;
    }else{
        return base*potenciacionRecursiva(base, exponente-1);
    }
    }

    public static void dibujarCuadrado(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void dibujarTriangulo(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void dibujarPiramide(int n) {
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <=n; j++) {
                //No se mu difisi
            }
        }
    }

    public static void dibujarRombo(int n) {
    //No se mu difisi
    }

    public static double calcularDescuento(double precioUnitario, int cantidad) {
        double descuento = 0;
        if (cantidad == 1 || cantidad == 2) {
            descuento = 0.95;
        } else if (cantidad == 3 || cantidad == 4) {
            descuento = 0.90;
        } else if (cantidad >= 5) {
            descuento = 0.85;
        }
        return precioUnitario * cantidad * descuento;
    }

    public static double calcularDescuento(double precioOriginal, String codigoPromocional) {
        double descuento = 0;
        if (codigoPromocional.equals("PROMO10")) {
            descuento = 0.90;
        } else if (codigoPromocional.equals("PROMO20")) {
            descuento = 0.80;
        }
        return precioOriginal * descuento;
    }

    public static double calcularDescuento(double precioOriginal, String esFrecuente, String esEstudiante) {
        double descuento = 0;
        if (esFrecuente.equalsIgnoreCase("SI")) {
            descuento += 0.90;
        }
        if (esEstudiante.equalsIgnoreCase("SI")) {
            descuento += 0.95;
        }
        return precioOriginal * (1 - descuento);
    }
}
