package org.college;

public class EstudiantePregrado extends Estudiante{
    public EstudiantePregrado(String pNombre, double[] pNotas)
    {
        super(pNombre, pNotas);
    }



    @Override
    public String obtenerRol(){
        return "Pregrado";
    }
    @Override
    public boolean estaAprobado(){
        return (getPromedio()) >= 60;
    }

}
