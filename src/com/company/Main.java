package com.company;

import com.company.Classes.Agenda;
import com.company.Classes.Contato;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Agenda agenda = new Agenda();

	    Contato contato1 = new Contato();
	    contato1.setNome("Contato1");
	    contato1.setNumero("numero1");
	    contato1.setEmail("email1");
	    Contato contato2 = new Contato();
	    contato2.setNome("Contato2");
	    contato2.setNumero("numero2");
	    contato2.setEmail("email2@email.com");
	    Contato contato3 = new Contato();
	    contato3.setNome("Contato3");
	    contato3.setNumero("numero3");
	    contato3.setEmail("email3@email.com");

	    agenda.inserir(contato1.getNome(), contato1.getNumero(), contato1.getEmail());
	    agenda.inserir(contato2.getNome(), contato2.getNumero(), contato2.getEmail());
	    agenda.inserir(contato2.getNome(), contato2.getNumero(), contato2.getEmail());
	    agenda.inserir(contato3.getNome(), contato3.getNumero(), contato3.getEmail());

	    agenda.buscarPorNome(contato2.getNome());

	    List<Contato> removerContatos = agenda.buscarPorNome(contato2.getNome());

	    for(Contato contato : removerContatos) {
	    	agenda.remover(contato);
		}

		System.out.println(agenda.getContatos().toString());
    }
}
