package org.college;

public class Estudiante {
    private String nombre;
    private double [] notas;
    private double promedio;


    public Estudiante() {
    }
    public Estudiante(String nombre, double[] notas) {
        this.nombre = nombre;
        this.notas = notas;

    }

    public String obtenerRol(){
        return "";
    }

    public boolean estaAprobado(){
        return (promedio) >= 70;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
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


    public void averageNotas(){
      double plusNotas = 0;
     for(double nota :notas){
       plusNotas+=nota;
      }
     promedio = plusNotas/notas.length;
    };
    public  boolean StudentPassed(){
        return promedio > 6.0;
    }
}

