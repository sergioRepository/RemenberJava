package org.shopOnline;

import java.util.UUID;

public class DetailsProducto {
    private String serialDetail;
    private  producto productoAtributo;
    private  int cantidad;
    private  double totalDetails;

    public DetailsProducto(int cantidad, producto productoAtributo) {
        this.serialDetail = UUID.randomUUID().toString();;
        this.cantidad = cantidad;
        this.productoAtributo = productoAtributo;
        calcularSubtotal();
        productoAtributo.disminuirStock(cantidad);
    }

    public String getSerialDetail() {
        return serialDetail;
    }

    public void setSerialDetail(String serialDetail) {
        this.serialDetail = serialDetail;
    }

    public double getTotalDetails() {
        return totalDetails;
    }

    public void setTotalDetails(double totalDetails) {
        this.totalDetails = totalDetails;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public producto getProductoAtributo() {
        return productoAtributo;
    }

    public void setProductoAtributo(producto productoAtributo) {
        this.productoAtributo = productoAtributo;
    }

    public void calcularSubtotal() {
        totalDetails = this.cantidad * productoAtributo.getPrecioProducto() ;
    }




}
