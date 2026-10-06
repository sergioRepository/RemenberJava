package org.college;
import org.clases.Caja;
import java.util.Scanner;

public class Main {
    public static void menuPrincipal(){
        System.out.println("==========================");
        System.out.println("===========MENU===========");
        System.out.println("ELIGE UNA OPCION");
        System.out.println("1- Imprimir Estudiantes");
        System.out.println("2- Promedio General");
        System.out.println("3- Cantidad aprobados");
        System.out.println("4- Cantidad de desaprobados");
        System.out.println("5- Estudiante mayor promedio");
        System.out.println("6- Estudiante menor promedio");
        System.out.println("7- Ver contenido de la Caja");
        System.out.println("8- Salir");
        System.out.println("==========================");
    }

    public static void main(String[] args) {
        System.out.println("portal de administracion de notas");
        GestionEstudiante Gest = new GestionEstudiante();
        Scanner teclado = new Scanner(System.in);


        Caja<Estudiante> cajaEstudiante = new Caja<>();

        int n = Gest.CantidadEstudiantesSolicitar();
        Gest.arrayEstudiantes = new Estudiante[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");
            System.out.println("Seleccione el tipo de estudiante:");
            System.out.println("1. Pregrado");
            System.out.println("2. Posgrado");
            int tipo = teclado.nextInt();

            System.out.println("Escribe el nombre del estudiante:");
            String nombreEstudiante = teclado.next();

            double[] notasEstudiante = new double[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("Ingrese la nota #" + (j + 1));
                notasEstudiante[j] = teclado.nextDouble();
            }

            Estudiante est;
            if (tipo == 1) {
                est = new EstudiantePregrado(nombreEstudiante, notasEstudiante);
            } else {
                est = new EstudiantePosgrado(nombreEstudiante, notasEstudiante);
            }


            est.averageNotas();
            Gest.arrayEstudiantes[i] = est;

            System.out.println("Deseas Guardarlos en una cajita Yes / marca 1");
            int opcionGuardarCaja = teclado.nextInt();
            if (opcionGuardarCaja == 1){
                cajaEstudiante.guardar(est);
                System.out.println("guardado en la cajita");
            }
            System.out.println("---------------------------------");

        }

        System.out.println("\nEstudiantes agregados correctamente.");
        int opcion = 0;

        do {
            menuPrincipal();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    Gest.imprimirEstudiantes();
                    break;
                case 2:
                    System.out.println("Promedio General: " + Gest.promedioGeneral());
                    break;
                case 3:
                    System.out.println("Cantidad Aprobados: " + Gest.cantidadAprobados());
                    break;
                case 4:
                    System.out.println("Cantidad Desaprobados: " + Gest.cantidadDesaprobados());
                    break;
                case 5:
                    Gest.imprimirOne(Gest.mayorEstudinate());
                    break;
                case 6:
                    Gest.imprimirOne(Gest.menorEstudinate());
                    break;
                case 7:
                    System.out.println("\n--- Contenido de la Caja Genérica ---");
                    Estudiante estEnCaja = cajaEstudiante.obtener();
                    if (estEnCaja != null) {
                        System.out.println("Rol: " + estEnCaja.obtenerRol());
                        Gest.imprimirOne(estEnCaja);
                    } else {
                        System.out.println("La caja está vacía.");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no Valida");
                    break;
            }
        } while (opcion != 8);
    }
}