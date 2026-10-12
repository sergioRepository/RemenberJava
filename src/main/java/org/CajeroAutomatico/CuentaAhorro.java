package org.CajeroAutomatico;

class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres; // 2% = 0.02

    public CuentaAhorro(String titular, double saldo, String pin) {
        super(titular, saldo, pin);
        this.tasaInteres = 0.02;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            double interes = monto * tasaInteres;
            saldo = saldo + monto + interes;
            registrarMovimiento("Deposito: +$" + monto + " (interes +$" + interes + ")");
        }
    }
}