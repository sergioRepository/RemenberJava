package org.RegistroAcademico;

import java.util.Scanner;

public class RegistroAcademico {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Curso curso = new Curso();
        cargarEstudiantes(curso);
        menu(curso);
    }

    private static void cargarEstudiantes(Curso curso) {
        int n = leerEntero("Cantidad de estudiantes: ");
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Estudiante " + i + " ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            int faltas = leerEntero("Numero de faltas: ");
            Estudiante e = new Estudiante(nombre, faltas);

            int cantAsignaturas = leerEntero("Cantidad de asignaturas: ");
            for (int j = 1; j <= cantAsignaturas; j++) {
                System.out.print("Nombre de la asignatura " + j + ": ");
                String nomAsig = scanner.nextLine();
                double nota = leerDouble("Nota final de " + nomAsig + ": ");
                e.agregarAsignatura(new Asignatura(nomAsig, nota));
            }
            curso.agregarEstudiante(e);
        }
    }

    private static void menu(Curso curso) {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println();
            System.out.println("1. Mostrar estadisticas");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Modificar nota");
            System.out.println("4. Mostrar listado completo");
            System.out.println("5. Guardar reporte en archivo");
            System.out.println("6. Salir");
            opcion = leerEntero("Elija una opcion: ");

            switch (opcion) {
                case 1: mostrarEstadisticas(curso); break;
                case 2: buscar(curso); break;
                case 3: modificarNota(curso); break;
                case 4: curso.mostrarListado(); break;
                case 5: curso.guardarReporte("reporte_curso.txt"); break;
                case 6: System.out.println("Fin del programa."); break;
                default: System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarEstadisticas(Curso curso) {
        if (curso.estaVacio()) {
            System.out.println("No hay datos.");
            return;
        }
        System.out.println("Promedio general del grupo: " + curso.promedioGeneral());
        System.out.println("Aprobados: " + curso.contarAprobados());
        System.out.println("Reprobados: " + curso.contarReprobados());
        System.out.println("Mejor estudiante: " + curso.mejorEstudiante().getNombre()
                + " (" + curso.mejorEstudiante().calcularPromedio() + ")");
        System.out.println("Peor estudiante: " + curso.peorEstudiante().getNombre()
                + " (" + curso.peorEstudiante().calcularPromedio() + ")");
    }

    private static void buscar(Curso curso) {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        Estudiante e = curso.buscarEstudiante(nombre);
        if (e == null) {
            System.out.println("Estudiante no encontrado.");
        } else {
            e.mostrarDatos();
        }
    }

    private static void modificarNota(Curso curso) {
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Nombre de la asignatura: ");
        String asignatura = scanner.nextLine();
        double nuevaNota = leerDouble("Nueva nota: ");
        if (curso.modificarNota(nombre, asignatura, nuevaNota)) {
            System.out.println("Nota actualizada.");
        } else {
            System.out.println("No se pudo modificar (verifique estudiante y asignatura).");
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

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero.");
            }
        }
    }
}