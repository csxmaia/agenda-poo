package com.company.Classes;

public class Contato {
    private int id;
    private String nome;
    private String numero;
    private String email;

    public Contato() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNumero() {
        return numero;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
