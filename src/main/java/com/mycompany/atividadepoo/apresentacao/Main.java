package com.mycompany.atividadepoo.apresentacao;


import java.util.Scanner;

public class Main {
    public Banco banco = new Banco();
    public Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ContaNaoEncontradaException {
        Main programa = new Main();
        programa.menuPrincipal();
    }

    public void menuPrincipal() throws ContaNaoEncontradaException {
        int opcao;
        do {
            exibirMenu();
            opcao = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha
            switchCase(opcao);
        } while (opcao != 0);
    }

    public void exibirMenu() {
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Escolha uma ação para realizar:");
        System.out.println("Opção 1: Inserir");
        System.out.println("Opção 2: Buscar");
        System.out.println("Opção 3: Remover");
        System.out.println("Opção 4: Alterar");
        System.out.println("Opção 5: Verificar dados:");
        System.out.println("Opção 6: Exibir Contas");
        System.out.println("Opção 0: Encerrar Programa");
    }

    public void switchCase(int opcao) throws ContaNaoEncontradaException {
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do titular:");
                String titular = scan.nextLine();
                System.out.println("Digite o número da conta:");
                String numero = scan.nextLine();
                System.out.println("Digite o saldo inicial da conta:");
                double saldo = scan.nextDouble();
                scan.nextLine(); // Consumir a nova linha
                Conta c = new Conta(titular, numero, saldo);
                this.banco.addConta(c);
                break;
            case 2:
                System.out.println("Digite o número da conta que quer buscar:");
                String n = scan.nextLine();
                try{
                    Conta buscada = this.banco.buscarContaPorNumero(n);
                    System.out.println("Conta encontrada");
                }catch (ContaNaoEncontradaException e){
                    e.getMessage();
                }
                break;
            case 3:
                System.out.println("Digite o número da conta que quer remover:");
                String x = scan.nextLine();
                Conta remover = this.banco.buscarContaPorNumero(x);
                this.banco.removeConta(remover);
                break;
            case 4:
                System.out.println("Digite o número da conta que quer alterar:");
                String num = scan.nextLine();
                Conta conta = this.banco.buscarContaPorNumero(num);
                System.out.println("Você só pode alterar o nome do titular!");
                System.out.println("Digite o novo titular:");
                String tit = scan.nextLine();
                conta.setNomeTitular(tit);
                break;
            case 5:
                System.out.println("Digite o número da conta que quer consultar:");
                String number = scan.nextLine();
                Conta conta1 = this.banco.buscarContaPorNumero(number);
                System.out.println(conta1.toString()); // Adicionei a saída do método toString()
                break;
            case 6:
                System.out.println("As contas existentes são:");
                this.banco.listarContas();
                break;
            case 0:
                System.out.println("Encerrando Programa...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
