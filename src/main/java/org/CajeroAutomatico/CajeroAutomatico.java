package org.CajeroAutomatico;

import java.util.Scanner;

public class CajeroAutomatico {
    private static Scanner scanner = new Scanner(System.in);
    private static Banco banco = new Banco();

    public static void main(String[] args) {
        cargarCuentasDePrueba();

        System.out.println("=== CAJERO AUTOMATICO ===");
        System.out.print("Ingrese su nombre (titular / ID de cliente): ");
        String titular = scanner.nextLine();

        CuentaBancaria cuenta = banco.buscarCuenta(titular);
        if (cuenta == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        if (!ingresarPin(titular)) {
            System.out.println("Cuenta bloqueada por 3 intentos fallidos.");
            return;
        }

        menuPrincipal(cuenta);
    }

    private static void cargarCuentasDePrueba() {
        banco.agregarCuenta(new CuentaBancaria("Ana", 500, "1234"));
        banco.agregarCuenta(new CuentaAhorro("Luis", 1000, "1111"));
        banco.agregarCuenta(new CuentaCorriente("Marta", 300, "2222", 200));
    }

    private static boolean ingresarPin(String titular) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            if (banco.validarPin(titular, pin)) {
                return true;
            }
            intentos++;
            System.out.println("PIN incorrecto. Intentos restantes: " + (3 - intentos));
        }
        return false;
    }

    private static void menuPrincipal(CuentaBancaria cuenta) {
        int opcion = 0;
        while (opcion != 6) {
            mostrarMenu();
            opcion = leerEntero("Elija una opcion: ");
            switch (opcion) {
                case 1: consultarSaldo(cuenta); break;
                case 2: retirar(cuenta); break;
                case 3: depositar(cuenta); break;
                case 4: transferir(cuenta); break;
                case 5: cuenta.mostrarHistorial(); break;
                case 6: System.out.println("Gracias por usar el cajero."); break;
                default: System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Transferir a otra cuenta");
        System.out.println("5. Consultar historial de movimientos");
        System.out.println("6. Salir");
    }

    private static void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
    }

    private static void retirar(CuentaBancaria cuenta) {
        double monto = leerDouble("Monto a retirar: ");
        cuenta.retirar(monto);
    }

    private static void depositar(CuentaBancaria cuenta) {
        double monto = leerDouble("Monto a depositar: ");
        cuenta.depositar(monto);
    }

    private static void transferir(CuentaBancaria cuenta) {
        banco.mostrarTitulares();
        System.out.print("Titular de la cuenta destino: ");
        String titularDestino = scanner.nextLine();
        CuentaBancaria destino = banco.buscarCuenta(titularDestino);
        if (destino == null) {
            System.out.println("Cuenta destino no encontrada.");
            return;
        }
        if (destino == cuenta) {
            System.out.println("No puede transferirse a si mismo.");
            return;
        }
        double monto = leerDouble("Monto a transferir: ");
        cuenta.transferir(destino, monto);
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero.");
            }
        }
    }
}