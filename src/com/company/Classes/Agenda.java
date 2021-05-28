package com.company.Classes;

import com.company.database.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        try {
            Connection con = ConnectDB.getDB();
            Statement statement = con.createStatement();

            String sql = "INSERT INTO contato(nome, numero, email, agenda_id) VALUES (\"" +nome+ "\",\"" +numero+ "\", \"" +email+ "\", " +1+ ");";

            statement.execute(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> buscarPorNome(String nome) {
        List<Contato> contatoList = new ArrayList<>();

        try {
            Connection con = ConnectDB.getDB();
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM contato WHERE nome LIKE \"%"+ nome +"%\";";

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                factoryContato(result, contatoList);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contatoList;
    }

    public List<Contato> buscarPorNumero(String numero) {
        List<Contato> contatoList = new ArrayList<>();

        try {
            Connection con = ConnectDB.getDB();
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM contato WHERE numero LIKE \"%"+ numero +"%\";";

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                factoryContato(result, contatoList);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contatoList;
    }

    public List<Contato> buscarPorEmail(String email) {
        List<Contato> contatoList = new ArrayList<>();

        try {
            Connection con = ConnectDB.getDB();
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM contato WHERE email LIKE \"%"+ email +"%\";";

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                factoryContato(result, contatoList);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contatoList;
    }

    public void remover(Contato contato) {
        try {
            Connection con = ConnectDB.getDB();
            Statement statement = con.createStatement();

            String sql = "DELETE FROM contato WHERE id = " + contato.getId() + ";";

            statement.execute(sql);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    private void factoryContato(ResultSet result, List<Contato> contatoList) throws SQLException {
        Contato contato = new Contato();
        contato.setId(result.getInt("id"));
        contato.setNome(result.getString("nome"));
        contato.setNumero(result.getString("numero"));
        contato.setEmail(result.getString("email"));
        contatoList.add(contato);
    }
}
