package org.shopOnline;

import java.util.ArrayList;
class Carrito {

private static final double MONTO_DESCUENTO = 1000;
private static final double PORCENTAJE_DESCUENTO = 0.10;

private Cliente cliente;
private Inventario inventario;
private ArrayList<ItemCarrito> items;

public Carrito(Cliente cliente, Inventario inventario) {
    this.cliente = cliente;
    this.inventario = inventario;
    this.items = new ArrayList<ItemCarrito>();
}

// El carrito valida y disminuye el stock consultando al Inventario
public void agregarProducto(String nombreProducto, int cantidad) {
    if (!inventario.hayStock(nombreProducto, cantidad)) {
        System.out.println("No hay stock suficiente de " + nombreProducto + ".");
        return;
    }
    ItemCarrito item = buscarItem(nombreProducto);
    if (item == null) {
        items.add(new ItemCarrito(inventario.buscarProducto(nombreProducto), cantidad));
    } else {
        item.aumentarCantidad(cantidad);
    }
    inventario.vender(nombreProducto, cantidad);
    System.out.println("Agregado al carrito: " + nombreProducto + " x" + cantidad);
}

private ItemCarrito buscarItem(String nombreProducto) {
    for (int i = 0; i < items.size(); i++) {
        if (items.get(i).getProducto().getNombre().equalsIgnoreCase(nombreProducto)) {
            return items.get(i);
        }
    }
    return null;
}

public double calcularSubtotal() {
    double subtotal = 0;
    for (int i = 0; i < items.size(); i++) {
        subtotal = subtotal + items.get(i).calcularSubtotal();
    }
    return subtotal;
}

// Expansion 12: descuento del 10% si el subtotal supera $1000
public double calcularDescuento() {
    double subtotal = calcularSubtotal();
    if (subtotal > MONTO_DESCUENTO) {
        return subtotal * PORCENTAJE_DESCUENTO;
    }
    return 0;
}

public double calcularTotal() {
    return calcularSubtotal() - calcularDescuento();
}

public boolean estaVacio() {
    return items.isEmpty();
}

public void mostrarFactura() {
    if (estaVacio()) {
        System.out.println("El carrito esta vacio.");
        return;
    }
    System.out.println("=========== FACTURA ===========");
    System.out.println("Cliente: " + cliente.getNombre() + " (" + cliente.getEmail() + ")");
    System.out.println("-------------------------------");
    for (int i = 0; i < items.size(); i++) {
        ItemCarrito item = items.get(i);
        System.out.println(item.getProducto().getNombre() + " x" + item.getCantidad()
                + "  $" + item.calcularSubtotal());
    }
    System.out.println("-------------------------------");
    System.out.println("Subtotal: $" + calcularSubtotal());
    System.out.println("Descuento (10% si supera $1000): -$" + calcularDescuento());
    System.out.println("TOTAL: $" + calcularTotal());
    System.out.println("===============================");
}
}