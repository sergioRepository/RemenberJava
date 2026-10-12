package org.NotasConCurva;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaNotasCurva {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CursoNotas curso = new CursoNotas();
        cargarAlumnos(curso);

        double promedio = curso.calcularPromedioOriginal();
        System.out.println();
        System.out.println("Promedio original del curso: " + promedio);

        if (promedio < 6) {
            aplicarCurva(curso);
        } else {
            System.out.println("El promedio es suficiente, no se aplica curva.");
            curso.fijarNotasFinalesSinCurva();
        }

        curso.mostrarListado();
        mostrarEstadisticas(curso);
    }

    private static void cargarAlumnos(CursoNotas curso) {
        System.out.println("=== SISTEMA DE NOTAS CON CURVA ===");
        int n = leerEntero("Cantidad de alumnos: ");
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Alumno " + i + " ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            double p1 = leerNota("Nota parcial 1 (30%): ");
            double p2 = leerNota("Nota parcial 2 (30%): ");
            double ef = leerNota("Nota examen final (40%): ");
            Alumno a = new Alumno(nombre, p1, p2, ef);
            a.marcarReprobadoAntesDeCurva(a.calcularNotaOriginal() < 6);
            curso.agregarAlumno(a);
        }
    }

    private static void aplicarCurva(CursoNotas curso) {
        System.out.println("El promedio es menor a 6. Se debe aplicar curva.");
        System.out.println("1. Curva porcentual (ej: 0.10 suma 10%)");
        System.out.println("2. Curva basada en el mejor alumno (se sube a todos para llegar a 10)");
        int tipo = leerEntero("Elija el tipo de curva: ");

        if (tipo == 1) {
            double porcentaje = leerNota("Porcentaje de curva (ej: 0.10): ");
            curso.aplicarCurvaPorcentual(porcentaje);
            System.out.println("Curva aplicada: +" + (porcentaje * 100) + "%");
        } else if (tipo == 2) {
            double puntos = 10 - curso.notaMasAlta();
            curso.aplicarCurvaPuntos(puntos);
            System.out.println("Nota mas alta: " + curso.notaMasAlta()
                    + " -> curva de +" + puntos + " puntos para todos.");
        } else {
            System.out.println("Opcion invalida, no se aplica curva.");
            curso.fijarNotasFinalesSinCurva();
        }
    }

    private static void mostrarEstadisticas(CursoNotas curso) {
        System.out.println();
        System.out.println("--- Estadisticas finales ---");
        System.out.println("Media del curso (notas finales): " + curso.calcularMediaFinal());
        System.out.println("Desviacion estandar: " + curso.calcularDesviacionEstandar());
        System.out.println("Aprobados: " + curso.contarAprobadosFinales()
                + " de " + curso.getCantidadAlumnos());
        System.out.println("Salvados por la curva (reprobados que aprobaron): "
                + curso.contarSalvadosPorLaCurva());
    }

    // Expansion 24: try-catch para InputMismatchException, vuelve a pedir la nota
    private static double leerNota(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double nota = scanner.nextDouble();
                scanner.nextLine();
                if (nota < 0 || nota > 10) {
                    System.out.println("La nota debe estar entre 0 y 10.");
                    continue;
                }
                return nota;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                scanner.nextLine();
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }
}