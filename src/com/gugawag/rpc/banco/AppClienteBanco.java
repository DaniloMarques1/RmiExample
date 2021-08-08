package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    // chama o método da interface, a mágica está no extends Remote?
                    System.out.printf("Saldo da conta de número %s é %.2f\n", conta, banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.printf("Quantidade de contas registradas: %d\n", banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Adicionando uma nova conta...\n");
                    System.out.print("Qual o número da conta? ");
                    String numeroConta = entrada.next();
                    System.out.print("Saldo inicial da conta? ");
                    double saldo = entrada.nextDouble();
                    Conta conta = new Conta(numeroConta, saldo);
                    banco.adicionarConta(conta);
                    break;
                }
                default:
                    break;
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== Danilo Marques de Oliveira ===");
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar uma nova conta");
        System.out.println("9 - Sair");
    }

}
