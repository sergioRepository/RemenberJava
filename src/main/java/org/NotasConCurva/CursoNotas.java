package org.NotasConCurva;

import java.util.ArrayList;

class CursoNotas {
    private ArrayList<Alumno> alumnos;

    public CursoNotas() {
        alumnos = new ArrayList<Alumno>();
    }

    public void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    public boolean estaVacio() {
        return alumnos.isEmpty();
    }

    public int getCantidadAlumnos() {
        return alumnos.size();
    }

    public double calcularPromedioOriginal() {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            suma = suma + alumnos.get(i).calcularNotaOriginal();
        }
        return suma / alumnos.size();
    }


    public double notaMasAlta() {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double maxima = alumnos.get(0).calcularNotaOriginal();
        for (int i = 1; i < alumnos.size(); i++) {
            maxima = Math.max(maxima, alumnos.get(i).calcularNotaOriginal());
        }
        return maxima;
    }

    public void aplicarCurvaPorcentual(double porcentaje) {
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).aplicarCurvaPorcentual(porcentaje);
        }
    }

    public void aplicarCurvaPuntos(double puntos) {
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).aplicarCurvaPuntos(puntos);
        }
    }

    public void fijarNotasFinalesSinCurva() {
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).fijarNotaFinalSinCurva();
        }
    }


    public double calcularMediaFinal() {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            suma = suma + alumnos.get(i).getNotaFinal();
        }
        return suma / alumnos.size();
    }

    public double calcularDesviacionEstandar() {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double media = calcularMediaFinal();
        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            double diferencia = alumnos.get(i).getNotaFinal() - media;
            suma = suma + Math.pow(diferencia, 2);
        }
        return Math.sqrt(suma / alumnos.size());
    }

    public int contarAprobadosFinales() {
        int cantidad = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).aprobo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarSalvadosPorLaCurva() {
        int cantidad = 0;
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno a = alumnos.get(i);
            if (a.reproboAntesDeCurva() && a.aprobo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void mostrarListado() {
        System.out.println("--- Listado de alumnos ---");
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno a = alumnos.get(i);
            System.out.printf("%-20s Original: %-6.2f Final: %-6.2f %s%n",
                    a.getNombre(),
                    a.calcularNotaOriginal(),
                    a.getNotaFinal(),
                    (a.aprobo() ? "APROBADO" : "REPROBADO"));
        }
    }
}