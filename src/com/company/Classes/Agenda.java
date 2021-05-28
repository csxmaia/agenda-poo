package com.company.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void inserir(String nome, String numero, String email) {
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setNumero(numero);
        contato.setEmail(email);

        List<Contato> contatos = this.contatos;
        contatos.add(contato);
        this.contatos = contatos;
    }

    public List<Contato> buscarPorNome(String nome) {
        List<Contato> contatosNome = new ArrayList<>();
        contatosNome = this.contatos.stream()
                .filter(contato -> contato.getNome().equals(nome))
                .collect(Collectors.toList());
        return contatosNome;
    }

    public void remover(Contato contato) {
        this.contatos.remove(contato);
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}
