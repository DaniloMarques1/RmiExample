package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

// @@@ ao extender de remote, quando tentar executar
// um método da interface, já saberá que irá executar
// um método remoto
public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void adicionarConta(Conta conta) throws RemoteException;
}
