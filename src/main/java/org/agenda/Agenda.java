package org.agenda;

import java.io.*;
import java.util.ArrayList;

class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<Contacto>();
    }

    // Expansion 17: valida telefono (9 digitos) y email (@ y .)
    public boolean agregarContacto(Contacto c) {
        if (!telefonoValido(c.getTelefono())) {
            System.out.println("Telefono invalido: debe tener 9 digitos numericos.");
            return false;
        }
        if (!emailValido(c.getEmail())) {
            System.out.println("Email invalido: debe contener '@' y '.'.");
            return false;
        }
        if (existeNombre(c.getNombre())) {
            System.out.println("Ya existe un contacto con ese nombre.");
            return false;
        }
        if (existeTelefono(c.getTelefono())) {
            System.out.println("Ya existe un contacto con ese telefono.");
            return false;
        }
        contactos.add(c);
        return true;
    }

    private boolean existeNombre(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeTelefono(String telefono) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getTelefono().equals(telefono)) {
                return true;
            }
        }
        return false;
    }

    private boolean telefonoValido(String telefono) {
        if (telefono.length() != 9) {
            return false;
        }
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean emailValido(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Expansion 18: busqueda parcial (devuelve todos los que contienen el texto)
    public ArrayList<Contacto> buscarContacto(String texto) {
        ArrayList<Contacto> resultado = new ArrayList<Contacto>();
        String busqueda = texto.toLowerCase();
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().toLowerCase().contains(busqueda)) {
                resultado.add(contactos.get(i));
            }
        }
        return resultado;
    }

    public boolean eliminarContacto(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void mostrarTodos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda esta vacia.");
            return;
        }
        System.out.println("--- Contactos ---");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i).getNombre()
                    + " | " + contactos.get(i).getTelefono()
                    + " | " + contactos.get(i).getEmail()
                    + " | Grupo: " + contactos.get(i).getGrupo());
        }
    }

    // Expansion 19
    public void mostrarContactosPorGrupo(String grupo) {
        boolean hay = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getGrupo().equalsIgnoreCase(grupo)) {
                contactos.get(i).mostrarInfo();
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay contactos en el grupo " + grupo + ".");
        }
    }

    // Expansion 20: guardar y cargar en archivo de texto
    public void guardarEnArchivo(String nombreArchivo) {
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));
            for (int i = 0; i < contactos.size(); i++) {
                Contacto c = contactos.get(i);
                salida.println(c.getNombre() + ";" + c.getTelefono() + ";"
                        + c.getEmail() + ";" + c.getGrupo());
            }
            salida.close();
            System.out.println("Agenda guardada en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(nombreArchivo));
            String linea = entrada.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    Contacto c = new Contacto(partes[0], partes[1], partes[2], partes[3]);
                    if (!existeNombre(c.getNombre()) && !existeTelefono(c.getTelefono())) {
                        contactos.add(c);
                    }
                }
                linea = entrada.readLine();
            }
            entrada.close();
            System.out.println("Agenda cargada desde " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo.");
        }
    }
}