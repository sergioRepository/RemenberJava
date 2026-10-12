package org.CajeroAutomatico;

abstract class Cuenta {
    protected String titular;
    protected double saldo;

    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public abstract void depositar(double monto);
    public abstract boolean retirar(double monto);
}