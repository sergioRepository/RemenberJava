package org.NotasConCurva;

class Alumno {
    private String nombre;
    private double notaParcial1;
    private double notaParcial2;
    private double examenFinal;
    private double notaFinal;
    private boolean reprobadoAntesDeCurva;

    public Alumno(String nombre, double notaParcial1, double notaParcial2, double examenFinal) {
        this.nombre = nombre;
        this.notaParcial1 = notaParcial1;
        this.notaParcial2 = notaParcial2;
        this.examenFinal = examenFinal;
        this.reprobadoAntesDeCurva = false;
    }


    public double calcularNotaOriginal() {
        return notaParcial1 * 0.30 + notaParcial2 * 0.30 + examenFinal * 0.40;
    }


    public void aplicarCurvaPorcentual(double porcentaje) {
        double conCurva = calcularNotaOriginal() * (1 + porcentaje);
        notaFinal = Math.min(conCurva, 10);
    }


    public void aplicarCurvaPuntos(double puntos) {
        notaFinal = Math.min(calcularNotaOriginal() + puntos, 10);
    }

    public void fijarNotaFinalSinCurva() {
        notaFinal = calcularNotaOriginal();
    }

    public boolean aprobo() {
        return notaFinal >= 6;
    }

    public String getNombre() { return nombre; }
    public double getNotaFinal() { return notaFinal; }

    public boolean reproboAntesDeCurva() { return reprobadoAntesDeCurva; }
    public void marcarReprobadoAntesDeCurva(boolean valor) { reprobadoAntesDeCurva = valor; }
}
