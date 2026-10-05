package org.college;

public class Estudiante {
    private String nombre;
    private double [] notas;

    public Estudiante() {
    }
    public Estudiante(String nombre, double[] notas) {
        this.nombre = nombre;
        this.notas = notas;

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }


    public double averageNotas(){
      double plusNotas = 0;
     for(double nota :notas){
       plusNotas+=nota;
      }
     return plusNotas/notas.length;
    };
    public  boolean StudentPassed(){
     if(averageNotas()>6.0){
         return true;
     }else{
         return false;
     }
    }
}
