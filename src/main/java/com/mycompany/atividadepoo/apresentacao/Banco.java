/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadepoo.apresentacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author acsimoes
 */
public class Banco {

    public ArrayList<Conta> listaContas;

    public Banco() {
        this.listaContas = new ArrayList<>();
    }

    public ArrayList<Conta> getContas() {
        return listaContas;
    }

    public void setContas(ArrayList<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public void addConta(Conta conta) {
        listaContas.add((Conta) conta);
        System.out.println("Conta criada e adicionada!");
    }

    public void removeConta(Conta conta) {
        listaContas.remove(conta);
    }

    public void listarContas() {

        for (int i = 0; i < this.listaContas.size(); i++) {
            System.out.println(this.listaContas.get(i));

        }
    }


    public Conta buscarContaPorNumero(String numeroConta) throws ContaNaoEncontradaException {
        for (int i = 0; i < listaContas.size(); i++) {
            Conta conta = listaContas.get(i);
            if (Objects.equals(conta.getNumeroConta(), numeroConta)) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta não encontrada para o número: " + numeroConta);
    }

}

