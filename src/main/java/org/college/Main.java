package org.college;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void menuPrincipal(){
        System.out.println("==========================");
        System.out.println("===========MENU===========");
        System.out.println("ELIGE UNA OPCION");
        System.out.println("1-imprimir Estudiantes");
        System.out.println("2-promedio General");
        System.out.println("3-Cantidad aprobados");
        System.out.println("4-Cantidad de desaprobados");
        System.out.println("5-Estudiante mayor promedio");
        System.out.println("6-Estudiante menor promedio");
        System.out.println("7-Salir");
        System.out.println("==========================");
    }


    static void main(String[] args) {
        System.out.println("portal de administracion de notas");
        GestionEstudiante Gest = new GestionEstudiante();
        Gest.InsertarEstudiantes();
        System.out.println("estudiantes agregados correctamnete");
        int opcion = 0;
        do {
        menuPrincipal();
            Scanner teclado = new Scanner(System.in);
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    Gest.imprimirEstudiantes();
                case 2:
                    System.out.println("Promedio General"+Gest.promedioGeneral());
                    break;
                case 3:
                    System.out.println("Cantidad Aprobados"+Gest.cantidadAprobados());
                    break;
                case 4:
                    System.out.println("Cantidad Desaprobados"+Gest.cantidadDesaprobados());
                    break;
                case 5:
                    Gest.imprimirOne(Gest.mayorEstudinate());
                    break;
                case 6:
                    Gest.imprimirOne(Gest.menorEstudinate());
                    break;
                case 7:
                    System.out.println("Saliendo...");

                default:
                    System.out.println("Opcion no Valida");
                    break;

            }

        }while (opcion != 7);

    }



}
