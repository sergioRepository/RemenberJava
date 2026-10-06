package org.shopOnline;

import java.util.UUID;

public class producto {
    private String serial;
    private String nombreProducto;
    private double precioProducto;
    private int stock;

    public producto(double precioProducto, int stock, String nombreProducto) {
        this.serial = UUID.randomUUID().toString();
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.nombreProducto = nombreProducto;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public void  disminuirStock(int stock) {
        this.stock -= stock;
    }

    public boolean  HayStock(int stockP) {
       return stockP < this.stock;
    }


}
