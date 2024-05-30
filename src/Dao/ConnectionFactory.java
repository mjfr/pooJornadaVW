package Dao;

import java.sql.*;

public class ConnectionFactory {
    private static final String DB_NAME = "producaoconsumo";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado ao Banco de Dados com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e);
        }
        return connection;
    }

//    public static void closeConnection(Connection connection) {
//        if (connection != null) {
//            try {
//                connection.close();
//                System.out.println("Conexão fechada");
//            } catch (SQLException e) {
//                System.out.println("Erro ao fechar a conexão: " + e);
//            }
//        }
//    }
}