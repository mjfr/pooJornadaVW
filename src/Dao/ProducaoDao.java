package Dao;

import Model.Producao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducaoDao extends AbstractDao<Producao> {
    // Construtor que define a conexão com o DB
    public ProducaoDao(Connection connection) {
        super(connection);
    }

    // Sobrescreve o método para adicionar um registro de Producao ao DB
    @Override
    public void create(Producao producao) throws SQLException {
        // Define a query de inserção
        String sql = "INSERT INTO Producao (data_registro, " +
                "linha_producao, " +
                "producao_turno1, " +
                "producao_turno2, " +
                "producao_turno3) " +
                "VALUES (?, ?, ?, ?, ?)";

        // Pré-compila uma declaração SQL para o banco de dados conectado com a aplicação e
        // utiliza a query em String como modelo para inserção dos dados a serem registrados
        // advindos do atributo producao passado como parâmetro
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, producao.getData_registro());
            preparedStatement.setByte(2, producao.getLinha_producao());
            preparedStatement.setDouble(3, producao.getProducao_turno1());
            preparedStatement.setDouble(4, producao.getProducao_turno2());
            preparedStatement.setDouble(5, producao.getProducao_turno3());
            preparedStatement.execute();
        }
    }

    // Método extraído para evitar duplicação de código. (Utilizado em readAll e read)
    private void setProducao(Producao producao, ResultSet resultSet) throws SQLException {
        producao.setData_registro(resultSet.getDate("data_registro"));
        producao.setLinha_producao(resultSet.getByte("linha_producao"));
        producao.setProducao_turno1(resultSet.getDouble("producao_turno1"));
        producao.setProducao_turno2(resultSet.getDouble("producao_turno2"));
        producao.setProducao_turno3(resultSet.getDouble("producao_turno3"));
    }

    // Sobrescreve o método para ler todos os resultados de Producao
    @Override
    public List<Producao> readAll() throws SQLException {
        // Define a query da busca
        String sql = "SELECT * FROM Producao";
        // Cria uma lista de Producao que armazenará os resultados obtidos
        List<Producao> results = new ArrayList<>();

        // Tenta executar uma declaração SQL estática, se houver sucesso, retorna o resultado da query
        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            // Enquanto houver resultados da busca, itera sobre eles e os adiciona a lista de resultados
            while (resultSet.next()) {
                // Instancia-se um novo objeto para cada resultado obtido
                Producao producao = new Producao();
                // Insere por setters as informações do objeto vindos da busca no novo objeto instanciado
                setProducao(producao, resultSet);
                // Adiciona o objeto à lista
                results.add(producao);
            }
        }
        return results;
    }

    // Sobrescreve o método para ler um resultado específico de Producao
    @Override
    public Producao read(Date data_registro, byte linha_producao) throws SQLException {
        // Define a query da busca
        String sql = "SELECT * FROM Producao WHERE data_registro = ? AND linha_producao = ?";
        // Inicializando o objeto como nulo
        Producao producao = null;

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a busca
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, data_registro);
            preparedStatement.setByte(2, linha_producao);
            // Tenta executar a declaração pré-compilada
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                // Se houver resultados, instancia-se um novo objeto e insere-o o resultado
                if (resultSet.next()) {
                    producao = new Producao();
                    setProducao(producao, resultSet);
                }
            }
        }
        return producao;
    }

    // Sobrescreve o método para atualizar um resultado específico de Producao
    @Override
    public void update(Producao producao) throws SQLException {
        // Define a query da alteração
        String sql = "UPDATE Producao SET producao_turno1 = ?, " +
                "producao_turno2 = ?, " +
                "producao_turno3 = ? " +
                "WHERE data_registro = ? AND linha_producao = ?";

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a alteração
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, producao.getProducao_turno1());
            preparedStatement.setDouble(2, producao.getProducao_turno2());
            preparedStatement.setDouble(3, producao.getProducao_turno3());
            preparedStatement.setDate(4, producao.getData_registro());
            preparedStatement.setByte(5, producao.getLinha_producao());
            // Envia a query para ser executada
            preparedStatement.executeUpdate();
        }
    }

    // Sobrescreve o método da deleção de um resultado específico de ObjetivoConsumoMax
    @Override
    public void delete(Producao producao) throws SQLException {
        // Define a query da deleção
        String sql = "DELETE FROM Producao WHERE data_registro = ? AND linha_producao = ?";

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a deleção
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, producao.getData_registro());
            preparedStatement.setByte(2, producao.getLinha_producao());
            // Envia a query para ser executada
            preparedStatement.executeUpdate();
        }
    }
}
