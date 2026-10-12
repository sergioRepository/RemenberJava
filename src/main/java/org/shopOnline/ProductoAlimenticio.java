package org.shopOnline;
class ProductoAlimenticio extends Producto {
    private String fechaCaducidad;

    public ProductoAlimenticio(String nombre, double precio, int stock,
                               String categoria, String fechaCaducidad) {
        super(nombre, precio, stock, categoria);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(getNombre() + " | $" + getPrecio() + " | stock: " + getStock()
                + " | categoria: " + getCategoria() + " | caduca: " + fechaCaducidad);
    }
}