package src.Tema5.ED;

import java.util.Scanner;

public class SalarioEmpleado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Salario base (€): ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Número de horas extras trabajadas: ");
        int horasExtras = scanner.nextInt();

        System.out.print("Tasa por hora extra (€): ");
        double tasaHoraExtra = scanner.nextDouble();

        double pagoHorasExtras = horasExtras * tasaHoraExtra;
        double salarioBruto = salarioBase + pagoHorasExtras;

        double irpf;
        if (salarioBruto > 2000) {
            irpf = salarioBruto * 0.15;
        } else if (salarioBruto >= 1000) {
            irpf = salarioBruto * 0.10;
        } else {
            irpf = salarioBruto * 0.05;
        }

        double seguroSocial = salarioBruto * 0.065;
        double salarioNeto = salarioBruto - (irpf + seguroSocial);

        System.out.println("Resumen:");
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Salario base: " + salarioBase + "€");
        System.out.println("Pago por horas extras: " + pagoHorasExtras + "€");
        System.out.println("Salario bruto: " + salarioBruto + "€");
        System.out.println("IRPF aplicado: " + irpf + "€");
        System.out.println("Seguro Social: " + seguroSocial + "€");
        System.out.println("Salario neto: " + salarioNeto + "€");
    }
}
