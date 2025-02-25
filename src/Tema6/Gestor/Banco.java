package src.Tema6.Gestor;
import java.util.Scanner;

public class Banco {
    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        gestor administrador = null;
        final cuenta cuentaCliente = new cuenta(0, 0);
        int opcion = 0;
        int telefono = 0;
        String nombre = "";
        do {
            System.out.println("Seleccione una opción:\n1. Registrar un nuevo gestor\n2. Abrir una cuenta bancaria\n3. Vincular un gestor a la cuenta\n4. Realizar una transacción\n5. Ver detalles de la cuenta\n6. Salir");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del gestor:");
                    nombre = input.next();
                    System.out.println("Ingrese el número de contacto:");
                    telefono = input.nextInt();
                    System.out.println("¿Desea establecer un límite de transacción?");
                    final String respuesta = input.next();
                    if (respuesta.equalsIgnoreCase("si")) {
                        System.out.println("Ingrese el límite máximo:");
                        final double limite = input.nextInt();
                        administrador = new gestor(nombre, telefono, limite);
                    } else {
                        administrador = new gestor(nombre, telefono);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el número de cuenta:");
                    final int numeroCuenta = input.nextInt();
                    System.out.println("Ingrese el saldo inicial:");
                    final int saldo = input.nextInt();
                    cuentaCliente.setNumeroCuenta(numeroCuenta);
                    cuentaCliente.setSaldo(saldo);
                    System.out.println("Número de cuenta asignado: " + cuentaCliente.getNumeroCuenta());
                    System.out.println("Saldo disponible: " + cuentaCliente.getSaldo());
                    break;
                case 3:
                    cuentaCliente.asignarGestor(administrador);
                    break;
                case 4:
                    System.out.println("¿Desea realizar una transacción?");
                    final String confirmacion = input.next();
                    if (confirmacion.equalsIgnoreCase("si")) {
                        System.out.println("¿Desea depositar o retirar fondos?");
                        final String tipoTransaccion = input.next();
                        System.out.println("Ingrese el monto de la transacción:");
                        final int monto = input.nextInt();
                        cuentaCliente.realizarOperacion(monto, tipoTransaccion);
                    } else {
                        System.out.println("Saldo actual: " + cuentaCliente.getSaldo());
                    }
                    break;
                case 5:
                    cuentaCliente.mostrarinformacion(); // no va esto
                    break;
                default:
                    break;
            }
        } while (opcion != 6);
    }
}