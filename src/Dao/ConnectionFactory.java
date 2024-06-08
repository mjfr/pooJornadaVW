package Dao;

import java.sql.*;

public class ConnectionFactory {

    // Informações do banco de dados como nome, driver, usuário e senha
    private static final String DB_NAME = "producaoconsumo";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Construtor vazio para impedir a instanciação de um objeto
    private ConnectionFactory() {
    }

    // Método para obter uma conexão com o banco de dados ou retornar um erro caso contrário
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Estabelecendo uma conexão com o banco de dados
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado ao Banco de Dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        // Retorna a conexão se não houver erros
        return connection;
    }
}