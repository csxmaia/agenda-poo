package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    private static final String url = "jdbc:mysql://localhost:3306/agenda";
    private static final String userName = "root";
    private static final String password = "QWE123QWEbighorse0420";

    public static Connection getDB() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    public static void initDB() {
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(false);

            String sqlAgenda = "CREATE TABLE IF NOT EXISTS agenda" +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " nome VARCHAR(255), " +
                    " PRIMARY KEY ( id ));";

            String sqlContato = "CREATE TABLE IF NOT EXISTS contato " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " nome VARCHAR(255), " +
                    " numero VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " agenda_id INTEGER, " +
                    " PRIMARY KEY ( id ), " +
                    " FOREIGN KEY ( agenda_id ) REFERENCES agenda(id));";

            String sqlAgendaRegistro = "INSERT INTO agenda(id, nome) VALUES (1, 'Agenda1');";

            Statement statement = con.createStatement();

            boolean resultAgenda = statement.execute(sqlAgenda);
            if(resultAgenda) System.out.println("Sucesso ao criar a tabela agenda");
            con.commit();
            boolean resultContato = statement.execute(sqlContato);
            if(resultContato) System.out.println("Sucesso ao criar a tabela agenda");
            con.commit();
            boolean resultAgendaRegistro = statement.execute(sqlAgendaRegistro);
            con.commit();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
