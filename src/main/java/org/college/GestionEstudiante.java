package org.college;

import java.util.Scanner;

public class GestionEstudiante {

    Estudiante[] arrayEstudiantes;
    Scanner teclado = new Scanner(System.in);

    public int CantidadEstudiantesSolicitar(){
        System.out.println("digita la cantidad de estudinates a evaluar");
        return teclado.nextInt();
    }

    public void InsertarEstudiantes(){
        int n = CantidadEstudiantesSolicitar();
        arrayEstudiantes = new Estudiante[n];
        for (int i = 0 ;i<n;i++){
            arrayEstudiantes[i] = createEstudiante();

        }

    }
    private Estudiante createEstudiante(){
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

    public void imprimirEstudiantes(){
        System.out.println("datos del grupo");
       for( Estudiante est:arrayEstudiantes){
           System.out.println("================");
           System.out.println("nombre:"+est.getNombre());
           System.out.println("notas:");
           for (double nota:est.getNotas()){
               System.out.println("*"+nota);
           }
           System.out.println("================");
       }
    }

    public double promedioGeneral(){
      double counter = 0;
      for (Estudiante est:arrayEstudiantes){
          counter+=est.getPromedio();
      }
      return counter/ arrayEstudiantes.length;

    }
     public int cantidadAprobados(){
        int counter = 0;
         for (Estudiante est:arrayEstudiantes){
             if (est.StudentPassed()){
                 counter++;
             }
         }
         return counter;

     }

    public int cantidadDesaprobados(){
        int counter = 0;
        for (Estudiante est:arrayEstudiantes){
            if (!est.StudentPassed()){
                counter++;
            }
        }
        return counter;

    }
    public Estudiante mayorEstudinate(){
        Estudiante mayor = arrayEstudiantes[0];
        for (int i = 1; i < arrayEstudiantes.length; i++) {
            double estPromedio = arrayEstudiantes[i].getPromedio();
            if ( estPromedio> mayor.getPromedio()){
                mayor = arrayEstudiantes[i];
            }

        }
        return mayor;
    }

    public Estudiante menorEstudinate(){
        Estudiante menor = arrayEstudiantes[0];
        for (int i = 1; i < arrayEstudiantes.length; i++) {
            double estPromedio = arrayEstudiantes[i].getPromedio();
            if ( estPromedio< menor.getPromedio()){
                menor = arrayEstudiantes[i];
            }

        }
        return menor;
    }

    public void imprimirOne(Estudiante estudiante){
        System.out.println("Nombre:"+estudiante.getNombre());
        System.out.println("Notas:");
        for (double nota:estudiante.getNotas()){
            System.out.println("*"+nota);
        }
        System.out.println("Promedio:"+estudiante.getPromedio());
    }
}
