package org.shopOnline;

import java.util.ArrayList;

class Inventario {
    private ArrayList<Producto> catalogo;

    public Inventario() {
        catalogo = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto p) {
        catalogo.add(p);
    }

    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return catalogo.get(i);
            }
        }
        return null;
    }

    // El stock siempre se valida a traves del Inventario
    public boolean hayStock(String nombre, int cantidad) {
        Producto p = buscarProducto(nombre);
        return p != null && p.hayStock(cantidad);
    }

    public boolean vender(String nombre, int cantidad) {
        Producto p = buscarProducto(nombre);
        if (p == null || !p.hayStock(cantidad)) {
            return false;
        }
        p.disminuirStock(cantidad);
        return true;
    }

    public void mostrarCatalogo() {
        System.out.println("--- Catalogo completo ---");
        for (int i = 0; i < catalogo.size(); i++) {
            catalogo.get(i).mostrarInfo();
        }
    }

    // Expansion 11: filtrar por categoria
    public void mostrarPorCategoria(String categoria) {
        System.out.println("--- Productos de " + categoria + " ---");
        boolean hay = false;
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                catalogo.get(i).mostrarInfo();
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay productos en esa categoria.");
        }
    }

    public void mostrarCategoriasDisponibles() {
        ArrayList<String> categorias = new ArrayList<String>();
        for (int i = 0; i < catalogo.size(); i++) {
            String cat = catalogo.get(i).getCategoria();
            if (!categorias.contains(cat)) {
                categorias.add(cat);
            }
        }
        System.out.println("Categorias disponibles: " + categorias);
    }
}