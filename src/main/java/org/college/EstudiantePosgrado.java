package org.college;

public class EstudiantePosgrado extends  Estudiante{
    public EstudiantePosgrado(String pNombre, double[] pNotas)
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
