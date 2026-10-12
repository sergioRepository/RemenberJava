package org;
import org.CajeroAutomatico.CajeroAutomatico;
import org.NotasConCurva.SistemaNotasCurva;
import org.RegistroAcademico.RegistroAcademico;
import org.agenda.AgendaContactos;
import org.shopOnline.TiendaOnline;

import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 6) {
            mostrarMenu();
            opcion = leerEntero("Elija una opcion: ");

            switch (opcion) {
                case 1: CajeroAutomatico.main(new String[0]); break;
                case 2: RegistroAcademico.main(new String[0]); break;
                case 3: TiendaOnline.main(new String[0]); break;
                case 4: AgendaContactos.main(new String[0]); break;
                case 5: SistemaNotasCurva.main(new String[0]); break;
                case 6: System.out.println("Hasta luego."); break;
                default: System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("================================");
        System.out.println("   MENU PRINCIPAL - PRACTICA 1");
        System.out.println("================================");
        System.out.println("1. Cajero Automatico");
        System.out.println("2. Registro Academico");
        System.out.println("3. Tienda Online");
        System.out.println("4. Agenda de Contactos");
        System.out.println("5. Sistema de Notas con Curva");
        System.out.println("6. Salir");
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
}