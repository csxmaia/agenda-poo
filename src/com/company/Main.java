package com.company;

import com.company.Classes.Agenda;
import com.company.Classes.Contato;
import com.company.database.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		ConnectDB.initDB();
		Agenda agenda = new Agenda();
		Scanner input = new Scanner(System.in);
		List<Contato> contatosSelecionados = new ArrayList<>();
		int opcao = 9999999;
	    while (opcao != 0) {
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("Escolha uma opcao");
			System.out.println("1. Inserir um Contato");
			System.out.println("2. Buscar contato pelo nome e seleciona-lo");
			System.out.println("3. Buscar contato pelo numero e seleciona-lo");
			System.out.println("4. Buscar contato pelo email e seleciona-lo");
			if(contatosSelecionados.size() >= 1) System.out.println("5. Remover os contatos selecionados");
			System.out.println("0. Sair do programa");
			opcao = input.nextInt();

			if (opcao == 1) {
				inserirContato(agenda);
			}
			if (opcao == 2) {
				contatosSelecionados.addAll(buscarContatoNome(agenda));
			}
			if (opcao == 3) {
				contatosSelecionados.addAll(buscarContatoNumero(agenda));
			}
			if (opcao == 4) {
				contatosSelecionados.addAll(buscarContatoEmail(agenda));
			}
			if (opcao == 5 && contatosSelecionados.size() >= 1) {
				for(Contato contato : contatosSelecionados) {
					agenda.remover(contato);
				}
				contatosSelecionados.clear();
			}
		}
    }

    private static void inserirContato(Agenda agenda) {
    	Scanner input = new Scanner(System.in);
		System.out.println("Insira o nome:");
		String nome = input.nextLine();
		System.out.println("Insira o numero:");
		String numero = input.nextLine();
		System.out.println("Insira o email:");
		String email = input.nextLine();

		agenda.inserir(nome, numero, email);

	}

	private static List<Contato> buscarContatoNome(Agenda agenda) {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome:");
		String nome = input.nextLine();
    	List<Contato> encontrados = agenda.buscarPorNome(nome);
		System.out.println(encontrados.size() + " Registros encontrados");
		return encontrados;
	}

	private static List<Contato> buscarContatoNumero(Agenda agenda) {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o numero:");
		String numero = input.nextLine();
		List<Contato> encontrados = agenda.buscarPorNumero(numero);
		System.out.println(encontrados.size() + " Registros encontrados");
		return encontrados;
	}

	private static List<Contato> buscarContatoEmail(Agenda agenda) {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o email:");
		String email = input.nextLine();
		List<Contato> encontrados = agenda.buscarPorNome(email);
		System.out.println(encontrados.size() + " Registros encontrados");
		return encontrados;
	}
}
//	    Contato contato1 = new Contato();
//	    contato1.setNome("Contato1");
//	    contato1.setNumero("numero1");
//	    contato1.setEmail("email1");
//	    Contato contato2 = new Contato();
//	    contato2.setNome("Contato2");
//	    contato2.setNumero("numero2");
//	    contato2.setEmail("email2@email.com");
//	    Contato contato3 = new Contato();
//	    contato3.setNome("Contato3");
//	    contato3.setNumero("numero3");
//	    contato3.setEmail("email3@email.com");
//
//	    agenda.inserir(contato1.getNome(), contato1.getNumero(), contato1.getEmail());
//	    agenda.inserir(contato2.getNome(), contato2.getNumero(), contato2.getEmail());
//	    agenda.inserir(contato2.getNome(), contato2.getNumero(), contato2.getEmail());
//	    agenda.inserir(contato3.getNome(), contato3.getNumero(), contato3.getEmail());
//
//	    agenda.buscarPorNome(contato2.getNome());
//
//	    List<Contato> removerContatos = agenda.buscarPorNome(contato2.getNome());
//
//	    for(Contato contato : removerContatos) {
//	    	agenda.remover(contato);
//		}
//
//		System.out.println(agenda.getContatos().toString());
