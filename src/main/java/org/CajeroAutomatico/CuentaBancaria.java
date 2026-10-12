package org.CajeroAutomatico;

import java.util.ArrayList;

class CuentaBancaria extends Cuenta {
    private String pin;
    private ArrayList<String> historial; // Expansion 2: ultimas 5 transacciones

    public CuentaBancaria(String titular, double saldo, String pin) {
        super(titular, saldo);
        this.pin = pin;
        this.historial = new ArrayList<String>();
    }

    public boolean validarPin(String pinIngresado) {
        return pin.equals(pinIngresado);
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
            registrarMovimiento("Deposito: +$" + monto);
        } else {
            System.out.println("El monto debe ser positivo.");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return false;
        }
        if (monto > saldo) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        saldo = saldo - monto;
        registrarMovimiento("Retiro: -$" + monto);
        return true;
    }

    // Expansion 1: transferencias bancarias
    public boolean transferir(CuentaBancaria cuentaDestino, double monto) {
        if (monto <= 0 || monto > saldo) {
            System.out.println("No se puede transferir ese monto.");
            return false;
        }
        saldo = saldo - monto;
        registrarMovimiento("Transferencia enviada a " + cuentaDestino.getTitular() + ": -$" + monto);
        cuentaDestino.recibirTransferencia(monto, titular);
        return true;
    }

    public void recibirTransferencia(double monto, String titularOrigen) {
        saldo = saldo + monto;
        registrarMovimiento("Transferencia recibida de " + titularOrigen + ": +$" + monto);
    }

    // Expansion 2: guardar solo las ultimas 5 transacciones
    protected void registrarMovimiento(String movimiento) {
        historial.add(movimiento);
        if (historial.size() > 5) {
            historial.remove(0);
        }
    }

    public void mostrarHistorial() {
        System.out.println("--- Ultimos movimientos de " + titular + " ---");
        if (historial.isEmpty()) {
            System.out.println("Sin movimientos registrados.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }
}
