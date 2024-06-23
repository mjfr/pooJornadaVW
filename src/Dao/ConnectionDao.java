package Dao;

import DaoHelper.DbConfig;

import java.sql.*;

// Testando a implementação do "D" do "SOLID"
public class ConnectionDao {

    private DbConfig dbConfig;

    // Construtor que aceita uma configuração de banco de dados, seguindo o Princípio da Inversão de Dependências
    public ConnectionDao(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    // Método para obter uma conexão com o banco de dados ou retornar um erro caso contrário
    public Connection getConnection() {
        Connection connection = null;
        try {
            // Estabelecendo uma conexão com o banco de dados
            connection = DriverManager.getConnection(dbConfig.getUrl() + dbConfig.getDbName(), dbConfig.getUser(), dbConfig.getPassword());
            System.out.println("Conectado ao Banco de Dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        // Retorna a conexão se não houver erros
        return connection;
    }
}