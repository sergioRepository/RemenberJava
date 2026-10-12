package org.shopOnline;

import java.util.Scanner;

public class TiendaOnline {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        cargarCatalogo(inventario);

        // Expansion 14: login pidiendo el email del cliente
        System.out.println("=== TIENDA ONLINE ===");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        String email = pedirEmailValido();
        Cliente cliente = new Cliente(nombre, email);
        System.out.println("Bienvenido/a, " + cliente.getNombre() + "!");

        Carrito carrito = new Carrito(cliente, inventario);
        menu(inventario, carrito);
    }

    private static void cargarCatalogo(Inventario inventario) {
        inventario.agregarProducto(new ProductoAlimenticio("Leche", 25, 20, "Alimentos", "2026-12-01"));
        inventario.agregarProducto(new ProductoAlimenticio("Pan", 15, 30, "Alimentos", "2026-10-20"));
        inventario.agregarProducto(new ProductoElectronico("Mouse", 120, 10, "Electronica", 12));
        inventario.agregarProducto(new ProductoElectronico("Teclado", 250, 8, "Electronica", 24));
        inventario.agregarProducto(new Producto("Cuaderno", 40, 50, "Papeleria"));
        inventario.agregarProducto(new Producto("Lapicero", 10, 100, "Papeleria"));
    }

    private static String pedirEmailValido() {
        while (true) {
            System.out.print("Ingrese su email: ");
            String email = scanner.nextLine();
            if (email.contains("@") && email.contains(".")) {
                return email;
            }
            System.out.println("Email invalido. Debe contener '@' y '.'.");
        }
    }

    private static void menu(Inventario inventario, Carrito carrito) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println();
            System.out.println("1. Ver catalogo completo");
            System.out.println("2. Ver catalogo por categoria");
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Ver factura");
            System.out.println("5. Salir");
            opcion = leerEntero("Elija una opcion: ");

            switch (opcion) {
                case 1: inventario.mostrarCatalogo(); break;
                case 2:
                    inventario.mostrarCategoriasDisponibles();
                    System.out.print("Categoria: ");
                    String cat = scanner.nextLine();
                    inventario.mostrarPorCategoria(cat);
                    break;
                case 3:
                    System.out.print("Nombre del producto: ");
                    String nom = scanner.nextLine();
                    int cant = leerEntero("Cantidad: ");
                    carrito.agregarProducto(nom, cant);
                    break;
                case 4: carrito.mostrarFactura(); break;
                case 5: System.out.println("Gracias por su compra."); break;
                default: System.out.println("Opcion invalida.");
            }
        }
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