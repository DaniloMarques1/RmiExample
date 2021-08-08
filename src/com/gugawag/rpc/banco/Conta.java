package com.gugawag.rpc.banco;

import java.io.Serializable;

public class Conta implements Serializable {
    private String numero;
    private double saldo;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return this.numero;
    }
    public double getSaldo() {
        return this.saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // não pode sacar, só depositar rsrs
    public void deposito(double value) {
        if (value > 0) {
            this.saldo += value;
        }
    }
}
