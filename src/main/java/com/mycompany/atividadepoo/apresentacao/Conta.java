/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividadepoo.apresentacao;


import java.util.Objects;

/**
 * @author acsimoes
 */
public class Conta {
    private String nomeTitular;
    private String numeroConta;
    private double saldoConta;

    public Conta(String nomeTitular, String numeroConta, double saldoConta) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }


    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void sacarSaldo(double valorSacar) {
        if (this.getSaldoConta() >= valorSacar && valorSacar > 0) {
            this.setSaldoConta(this.getSaldoConta() - valorSacar);
        } else {
            System.out.println("O valor do saque é inválido ou o saldo é insuficiente!");
        }
    }

    public void depositarSaldo(double valorDepositar) {

        this.saldoConta += valorDepositar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Conta conta)) {
            return false;
        }
        return Objects.equals(this.numeroConta, ((Conta) o).numeroConta);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nomeTitular='" + nomeTitular + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", saldoConta=" + saldoConta +
                '}';
    }
}