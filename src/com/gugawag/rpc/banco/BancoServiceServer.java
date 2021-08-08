package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;

// @@@ Classe que receberá a chamada RMI (RPC)
public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    //private Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        this.contas = new ArrayList<>();
    }

    @Override
    public double saldo(String numeroConta) throws RemoteException {
        //@@@ might have a better way of doing it
        for (Conta conta: this.contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta.getSaldo();
            }
        }

        return -1;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta(Conta conta) throws RemoteException {
        if (conta != null)
            this.contas.add(conta);
    }

}
