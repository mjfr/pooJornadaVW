package Dao;

import Model.ObjetivoConsumoMax;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoConsumoMaxDao extends AbstractDao<ObjetivoConsumoMax> {
    // Construtor que define a conexão com o DB
    public ObjetivoConsumoMaxDao(Connection connection) {
        super(connection);
    }

    // Sobrescreve o método para adicionar um registro de ObjetivoConsumoMax ao DB
    @Override
    public void create(ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        // Define a query de inserção
        String sql = "INSERT INTO ObjetivoConsumoMax (data_registro, " +
                "linha_producao, " +
                "objetivo1, " +
                "objetivo2, " +
                "objetivo3, " +
                "desperdicio_turno1, " +
                "desperdicio_turno2, " +
                "desperdicio_turno3) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Pré-compila uma declaração SQL para o banco de dados conectado com a aplicação e
        // utiliza a query em String como modelo para inserção dos dados a serem registrados
        // advindos do atributo objetivoConsumoMax passado como parâmetro
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, objetivoConsumoMax.getData_registro());
            preparedStatement.setByte(2, objetivoConsumoMax.getLinha_producao());
            preparedStatement.setDouble(3, objetivoConsumoMax.getObjetivo1());
            preparedStatement.setDouble(4, objetivoConsumoMax.getObjetivo2());
            preparedStatement.setDouble(5, objetivoConsumoMax.getObjetivo3());
            preparedStatement.setDouble(6, objetivoConsumoMax.getDesperdicio_turno1());
            preparedStatement.setDouble(7, objetivoConsumoMax.getDesperdicio_turno2());
            preparedStatement.setDouble(8, objetivoConsumoMax.getDesperdicio_turno3());
            preparedStatement.execute();
        }
    }

    // Método extraído para evitar duplicação de código. (Utilizado em readAll e read)
    private void setObjetivoConsumoMax(ResultSet resultSet, ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        objetivoConsumoMax.setData_registro(resultSet.getDate("data_registro"));
        objetivoConsumoMax.setLinha_producao(resultSet.getByte("linha_producao"));
        objetivoConsumoMax.setObjetivo1(resultSet.getDouble("objetivo1"));
        objetivoConsumoMax.setObjetivo2(resultSet.getDouble("objetivo2"));
        objetivoConsumoMax.setObjetivo3(resultSet.getDouble("objetivo3"));
        objetivoConsumoMax.setDesperdicio_turno1(resultSet.getDouble("desperdicio_turno1"));
        objetivoConsumoMax.setDesperdicio_turno2(resultSet.getDouble("desperdicio_turno2"));
        objetivoConsumoMax.setDesperdicio_turno3(resultSet.getDouble("desperdicio_turno3"));
    }

    // Sobrescreve o método para ler todos os resultados de ObjetivoConsumoMax
    @Override
    public List<ObjetivoConsumoMax> readAll() throws SQLException {
        // Define a query da busca
        String sql = "SELECT * FROM ObjetivoConsumoMax";
        // Cria uma lista de ObjetivoConsumoMax que armazenará os resultados obtidos
        List<ObjetivoConsumoMax> results = new ArrayList<>();

        // Tenta executar uma declaração SQL estática, se houver sucesso, retorna o resultado da query
        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            // Enquanto houver resultados da busca, itera sobre eles e os adiciona a lista de resultados
            while (resultSet.next()) {
                // Instancia-se um novo objeto para cada resultado obtido
                ObjetivoConsumoMax objetivoConsumoMax = new ObjetivoConsumoMax();
                // Insere por setters as informações do objeto vindos da busca no novo objeto instanciado
                setObjetivoConsumoMax(resultSet, objetivoConsumoMax);
                // Adiciona o objeto à lista
                results.add(objetivoConsumoMax);
            }
        }
        return results;
    }

    // Sobrescreve o método para ler um resultado específico de ObjetivoConsumoMax
    @Override
    public ObjetivoConsumoMax read(Date data_registro, byte linha_producao) throws SQLException {
        // Define a query da busca
        String sql = "SELECT * FROM ObjetivoConsumoMax WHERE data_registro = ? AND linha_producao = ?";
        // Inicializando o objeto como nulo
        ObjetivoConsumoMax objetivoConsumoMax = null;

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a busca
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, data_registro);
            preparedStatement.setByte(2, linha_producao);
            // Tenta executar a declaração pré-compilada
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                // Se houver resultados, instancia-se um novo objeto e insere-o o resultado
                if (resultSet.next()) {
                    objetivoConsumoMax = new ObjetivoConsumoMax();
                    setObjetivoConsumoMax(resultSet, objetivoConsumoMax);
                }
            }
        }
        return objetivoConsumoMax;
    }

    // Sobrescreve o método para atualizar um resultado específico de ObjetivoConsumoMax
    @Override
    public void update(ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        // Define a query da alteração
        String sql = "UPDATE ObjetivoConsumoMax SET objetivo1 = ?, " +
                "objetivo2 = ?, " +
                "objetivo3 = ?, " +
                "desperdicio_turno1 = ?, " +
                "desperdicio_turno2 = ?, " +
                "desperdicio_turno3 = ? " +
                "WHERE data_registro = ? AND linha_producao = ?";

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a alteração
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, objetivoConsumoMax.getObjetivo1());
            preparedStatement.setDouble(2, objetivoConsumoMax.getObjetivo2());
            preparedStatement.setDouble(3, objetivoConsumoMax.getObjetivo3());
            preparedStatement.setDouble(4, objetivoConsumoMax.getDesperdicio_turno1());
            preparedStatement.setDouble(5, objetivoConsumoMax.getDesperdicio_turno2());
            preparedStatement.setDouble(6, objetivoConsumoMax.getDesperdicio_turno3());
            preparedStatement.setDate(7, objetivoConsumoMax.getData_registro());
            preparedStatement.setByte(8, objetivoConsumoMax.getLinha_producao());
            // Envia a query para ser executada
            preparedStatement.executeUpdate();
        }
    }

    // Sobrescreve o método da deleção de um resultado específico de ObjetivoConsumoMax
    @Override
    public void delete(ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        // Define a query da deleção
        String sql = "DELETE FROM ObjetivoConsumoMax WHERE data_registro = ? AND linha_producao = ?";

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a deleção
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, objetivoConsumoMax.getData_registro());
            preparedStatement.setByte(2, objetivoConsumoMax.getLinha_producao());
            // Envia a query para ser executada
            preparedStatement.executeUpdate();
        }
    }
}
