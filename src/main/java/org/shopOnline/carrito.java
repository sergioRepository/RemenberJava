package org.shopOnline;

import java.util.ArrayList;

public class carrito {
    private ArrayList<DetailsProducto> arrayProductos = new ArrayList<>();
    private double total;

    public carrito(ArrayList<DetailsProducto> arrayProductos) {
        this.arrayProductos = arrayProductos;
        calcularTotalCarrito();
    }

    public carrito() {
    }

    public ArrayList<DetailsProducto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(ArrayList<DetailsProducto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void agregarProducto(producto productoP,int cant){
    DetailsProducto detailsVar = new DetailsProducto(cant,productoP);
    arrayProductos.add(detailsVar);
    }

    public void calcularTotalCarrito() {
        double counter = 0;
        for (DetailsProducto detailsProducto: arrayProductos){
            counter += detailsProducto.getTotalDetails();

        }
        this.total = counter;
    }



}
