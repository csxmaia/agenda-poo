package com.company.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Agenda {
    List<Contato> contatos;

    private static final String emailRegex = "^(.+)@(.+)$";

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void inserir(String nome, String numero, String email) {
        Contato contato = new Contato();
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher("");

        if (nome == null || nome.equals("")) {
            System.out.println("O Nome do contato não pode ser vazio");
            return;
        }

        if (numero == null || numero.equals("")) {
            System.out.println("O Numero do contato não pode ser vazio");
            return;
        }

        if (email == null || email.equals("")) {
            System.out.println("O Email do contato não pode ser vazio");
            return;
        } else if (!matcher.reset(email).matches()){
            System.out.println("O Email do contato deve ser um email válido");
            return;
        }

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

    public List<Contato> buscarPorNumero(String numero) {
        List<Contato> contatosNumero = new ArrayList<>();
        contatosNumero = this.contatos.stream()
                .filter(contato -> contato.getNumero().equals(numero))
                .collect(Collectors.toList());
        return contatosNumero;
    }

    public List<Contato> buscarPorEmail(String email) {
        List<Contato> contatosEmail = new ArrayList<>();
        contatosEmail = this.contatos.stream()
                .filter(contato -> contato.getEmail().equals(email))
                .collect(Collectors.toList());
        return contatosEmail;
    }

    public void remover(Contato contato) {
        this.contatos.remove(contato);
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}
