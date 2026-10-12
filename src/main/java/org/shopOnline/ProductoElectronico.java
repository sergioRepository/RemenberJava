package org.shopOnline;

class ProductoElectronico extends Producto {
    private int mesesGarantia;

    public ProductoElectronico(String nombre, double precio, int stock,
                               String categoria, int mesesGarantia) {
        super(nombre, precio, stock, categoria);
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(getNombre() + " | $" + getPrecio() + " | stock: " + getStock()
                + " | categoria: " + getCategoria() + " | garantia: " + mesesGarantia + " meses");
    }
}