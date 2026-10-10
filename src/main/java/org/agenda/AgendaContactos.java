package org.agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContactos {
    private static Scanner scanner = new Scanner(System.in);
    private static final String ARCHIVO = "agenda.txt";

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        int opcion = 0;
        while (opcion != 8) {
            mostrarMenu();
            opcion = leerEntero("Elija una opcion: ");
            switch (opcion) {
                case 1: agregarContacto(agenda); break;
                case 2: buscarContacto(agenda); break;
                case 3: agenda.mostrarTodos(); break;
                case 4: eliminarContacto(agenda); break;
                case 5: mostrarPorGrupo(agenda); break;
                case 6: agenda.guardarEnArchivo(ARCHIVO); break;
                case 7: agenda.cargarDesdeArchivo(ARCHIVO); break;
                case 8: System.out.println("Hasta luego."); break;
                default: System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Mostrar todos");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Mostrar por grupo");
        System.out.println("6. Guardar agenda en archivo");
        System.out.println("7. Cargar agenda desde archivo");
        System.out.println("8. Salir");
    }

    private static void agregarContacto(Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono (9 digitos): ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Grupo (Familia/Trabajo/Amigos/Otro): ");
        String grupo = scanner.nextLine();
        Contacto c = new Contacto(nombre, telefono, email, grupo);
        if (agenda.agregarContacto(c)) {
            System.out.println("Contacto agregado.");
        }
    }

    private static void buscarContacto(Agenda agenda) {
        System.out.print("Texto a buscar: ");
        String texto = scanner.nextLine();
        ArrayList<Contacto> resultado = agenda.buscarContacto(texto);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron contactos.");
        } else {
            System.out.println("Resultados (" + resultado.size() + "):");
            for (int i = 0; i < resultado.size(); i++) {
                resultado.get(i).mostrarInfo();
            }
        }
    }

    private static void eliminarContacto(Agenda agenda) {
        System.out.print("Nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();
        if (agenda.eliminarContacto(nombre)) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void mostrarPorGrupo(Agenda agenda) {
        System.out.print("Grupo: ");
        String grupo = scanner.nextLine();
        agenda.mostrarContactosPorGrupo(grupo);
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
