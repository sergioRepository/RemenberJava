package org.CajeroAutomatico;

import java.util.ArrayList;

class Banco {
    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        cuentas = new ArrayList<CuentaBancaria>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public CuentaBancaria buscarCuenta(String titular) {
        for (int i = 0; i < cuentas.size(); i++) {
            CuentaBancaria cuenta = cuentas.get(i);
            if (cuenta.getTitular().equalsIgnoreCase(titular)) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean validarPin(String titular, String pin) {
        CuentaBancaria cuenta = buscarCuenta(titular);
        if (cuenta == null) {
            return false;
        }
        return cuenta.validarPin(pin);
    }

    public void mostrarTitulares() {
        System.out.println("--- Cuentas disponibles ---");
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println("- " + cuentas.get(i).getTitular());
        }
    }
}