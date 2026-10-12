package org.RegistroAcademico;

import java.util.ArrayList;

class Estudiante {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;
    private int faltas; // Expansion 8

    public Estudiante(String nombre, int faltas) {
        this.nombre = nombre;
        this.faltas = faltas;
        this.asignaturas = new ArrayList<Asignatura>();
    }

    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public double calcularPromedio() {
        if (asignaturas.size() == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < asignaturas.size(); i++) {
            suma = suma + asignaturas.get(i).getNotaFinal();
        }
        return suma / asignaturas.size();
    }

    // Expansion 8: aprueba solo si promedio >= 6 Y faltas < 10
    public boolean aprobo() {
        return calcularPromedio() >= 6 && faltas < 10;
    }

    public String getNombre() { return nombre; }
    public int getFaltas() { return faltas; }
    public ArrayList<Asignatura> getAsignaturas() { return asignaturas; }

    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + " | Faltas: " + faltas);
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura a = asignaturas.get(i);
            System.out.println("   " + a.getNombre() + ": " + a.getNotaFinal());
        }
        System.out.println("   Promedio: " + calcularPromedio()
                + (aprobo() ? " (APROBADO)" : " (REPROBADO)"));
    }
}