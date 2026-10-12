package org.RegistroAcademico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Curso {
    private ArrayList<Estudiante> estudiantes;

    public Curso() {
        estudiantes = new ArrayList<Estudiante>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public double promedioGeneral() {
        if (estudiantes.size() == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            suma = suma + estudiantes.get(i).calcularPromedio();
        }
        return suma / estudiantes.size();
    }

    public int contarAprobados() {
        int cantidad = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).aprobo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarReprobados() {
        return estudiantes.size() - contarAprobados();
    }

    public Estudiante mejorEstudiante() {
        if (estudiantes.size() == 0) {
            return null;
        }
        Estudiante mejor = estudiantes.get(0);
        for (int i = 1; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).calcularPromedio() > mejor.calcularPromedio()) {
                mejor = estudiantes.get(i);
            }
        }
        return mejor;
    }

    public Estudiante peorEstudiante() {
        if (estudiantes.size() == 0) {
            return null;
        }
        Estudiante peor = estudiantes.get(0);
        for (int i = 1; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).calcularPromedio() < peor.calcularPromedio()) {
                peor = estudiantes.get(i);
            }
        }
        return peor;
    }

    // Expansion 10: busqueda y modificacion
    public Estudiante buscarEstudiante(String nombre) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return estudiantes.get(i);
            }
        }
        return null;
    }

    public boolean modificarNota(String nombreEstudiante, String nombreAsignatura, double nuevaNota) {
        Estudiante e = buscarEstudiante(nombreEstudiante);
        if (e == null) {
            return false;
        }
        for (int i = 0; i < e.getAsignaturas().size(); i++) {
            Asignatura a = e.getAsignaturas().get(i);
            if (a.getNombre().equalsIgnoreCase(nombreAsignatura)) {
                a.setNotaFinal(nuevaNota);
                return true;
            }
        }
        return false;
    }

    // Expansion 9: guardar reporte en archivo .txt
    public void guardarReporte(String nombreArchivo) {
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));
            salida.println("REPORTE DEL CURSO");
            salida.println("=================");
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante e = estudiantes.get(i);
                salida.println("Estudiante: " + e.getNombre() + " | Faltas: " + e.getFaltas());
                for (int j = 0; j < e.getAsignaturas().size(); j++) {
                    Asignatura a = e.getAsignaturas().get(j);
                    salida.println("   " + a.getNombre() + ": " + a.getNotaFinal());
                }
                salida.println("   Promedio: " + e.calcularPromedio()
                        + (e.aprobo() ? " (APROBADO)" : " (REPROBADO)"));
                salida.println();
            }
            salida.println("Promedio general del curso: " + promedioGeneral());
            salida.println("Aprobados: " + contarAprobados());
            salida.println("Reprobados: " + contarReprobados());
            if (mejorEstudiante() != null) {
                salida.println("Mejor estudiante: " + mejorEstudiante().getNombre());
                salida.println("Peor estudiante: " + peorEstudiante().getNombre());
            }
            salida.close();
            System.out.println("Reporte guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el reporte: " + e.getMessage());
        }
    }

    public void mostrarListado() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (int i = 0; i < estudiantes.size(); i++) {
            estudiantes.get(i).mostrarDatos();
            System.out.println();
        }
    }

    public boolean estaVacio() {
        return estudiantes.isEmpty();
    }
}