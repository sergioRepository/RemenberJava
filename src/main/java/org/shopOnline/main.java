package org.shopOnline;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;


public class main {
    static producto[] catalogo;
    static carrito carShop;
    static Scanner teclado = new Scanner(System.in);



    static void main() {
     iniciar();
     menuPrincipalTienda();
    }

    private static void menuPrincipalTienda() {
       int opcion;
        do {
            viewOpciones();
            opcion = teclado.nextInt();
            routeAction(opcion);

        }while (opcion !=4);
    }

    private static void routeAction(int opcion) {
        switch (opcion){
            case 1:
                verCatalogo();
                break;
            case 2:
                comprarProducto();
                break;
            case 3:
                mostrarFactura();
            case 4:
                System.out.println("Saliendo....");

        }
    }

    private static void mostrarFactura() {


    }

    private static void comprarProducto() {
        carShop = new carrito();
        System.out.println("escribe el codigo del producto");
        String codigo = teclado.next();
        System.out.println("cantidad:");
        int cantidad = teclado.nextInt();
        for (producto product : catalogo){
            if (Objects.equals(product.getSerial(), codigo)){
                carShop.agregarProducto(product,cantidad);
            }
        }
    }

    private static void verCatalogo() {
        for (producto producto : catalogo){
            System.out.println("=========================");
            System.out.println("serial:"+producto.getSerial()+"  nombre:"+producto.getNombreProducto());
            System.out.println("=========================");
        }
    }

    private static void viewOpciones() {
        System.out.println("===========MENU===========");
        System.out.println("ELIGE UNA OPCION");
        System.out.println("1- Ver Catalogo");
        System.out.println("2- Comprar Producto");
        System.out.println("3- Mostrar factura (Pendientes)");
        System.out.println("4- Terminar Compra(salir)");
        System.out.println("==========================");
    }

    public static  void  iniciar(){
        System.out.println(" BIENVENIDOS PORTAL  Simulación de Tienda Online ");
        System.out.println("Cuantos productos vas a añadir al catalogo");
        int cantidadProductos = teclado.nextInt();
        catalogo = generarCatologoProductos(cantidadProductos);
    }

    private static producto[] generarCatologoProductos(int cantidadProductos) {
        producto[] catalogo = new producto[cantidadProductos];
        producto productonew;

        String nombreProducto;
        int stock;
        double precioProducto;
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("=====================");
            System.out.println("Producto #"+i);
            System.out.println("nombre:");
            nombreProducto = teclado.next();
            System.out.println("stock:");
            stock = teclado.nextInt();
            System.out.println("precio producto");
            precioProducto = teclado.nextDouble();
            System.out.println("=====================");

            productonew = new producto(precioProducto,stock,nombreProducto);

            catalogo[i] = productonew;







        }
        return catalogo;

    }
}
