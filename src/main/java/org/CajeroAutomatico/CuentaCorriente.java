package org.CajeroAutomatico;

class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;

    public CuentaCorriente(String titular, double saldo, String pin, double limiteSobregiro) {
        super(titular, saldo, pin);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return false;
        }
        if (monto > saldo + limiteSobregiro) {
            System.out.println("El monto excede su limite de sobregiro.");
            return false;
        }
        saldo = saldo - monto;
        registrarMovimiento("Retiro: -$" + monto);
        return true;
    }
}