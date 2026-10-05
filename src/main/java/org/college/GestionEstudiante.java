package org.college;

import java.util.Scanner;

public class GestionEstudiante {
    // pedir la cantidad de n estudinate y sus 3 notas
    //guardarlos en un array
    // mostrar
    //promedio general del grupo
    // cantidad de aprobados y desaprobados
    // estudinate con mayor y menor promedio


    Scanner teclado = new Scanner(System.in);
    public int CantidadEstudiantesSolicitar(){

        System.out.println("digita la cantidad de estudinates a evaluar");
        int amount = teclado.nextInt();
        return amount;
    }
    public void InsertarEstudiantes(){
        int n = CantidadEstudiantesSolicitar();
        Estudiante[] arrayEstudinates = new Estudiante[n];
        for (int i = 0 ;i<n;i++){
            arrayEstudinates[i] = createEstudiante();



        }

    }
    public Estudiante createEstudiante(){
        System.out.println("escribe el nombre del estudiante");
        String nombreEstudinate = teclado.next();
        double [] notasEstudiante = new double[3];
        for(int i = 0;i<3;i++){
            System.out.println("ingrese la nota #"+(i+1));
            double notaInsert = teclado.nextDouble();
            notasEstudiante[i] = notaInsert;
        }
        return new Estudiante(nombreEstudinate,notasEstudiante);
    }
}
