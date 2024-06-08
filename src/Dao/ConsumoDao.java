package Dao;

import Model.Consumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDao extends AbstractDao<Consumo> {
    // Construtor que define a conexão com o DB
    public ConsumoDao(Connection connection) {
        super(connection);
    }

    // Sobrescreve o método para adicionar um registro de Consumo ao DB
    @Override
    public void create(Consumo consumo) throws SQLException {
        // Define a query de inserção
        String sql = "INSERT INTO Consumo (data_registro, " +
                "linha_producao, " +
                "consumo_turno1, " +
                "consumo_turno2, " +
                "consumo_turno3, " +
                "consumo_un_turno1, " +
                "consumo_un_turno2, " +
                "consumo_un_turno3) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Tenta pré-compilar uma declaração SQL para o banco de dados conectado com a aplicação e
        // utiliza a query em String como modelo para inserção dos dados a serem registrados
        // advindos do atributo consumo passado como parâmetro
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, consumo.getData_registro());
            preparedStatement.setByte(2, consumo.getLinha_producao());
            preparedStatement.setDouble(3, consumo.getConsumo_turno1());
            preparedStatement.setDouble(4, consumo.getConsumo_turno2());
            preparedStatement.setDouble(5, consumo.getConsumo_turno3());
            preparedStatement.setDouble(6, consumo.getConsumo_un_turno1());
            preparedStatement.setDouble(7, consumo.getConsumo_un_turno2());
            preparedStatement.setDouble(8, consumo.getConsumo_un_turno3());
            preparedStatement.execute();
        }
    }

    // Método extraído para evitar duplicação de código. (Utilizado em readAll e read)
    private void setConsumo(ResultSet resultSet, Consumo consumo) throws SQLException {
        consumo.setData_registro(resultSet.getDate("data_registro"));
        consumo.setLinha_producao(resultSet.getByte("linha_producao"));
        consumo.setConsumo_turno1(resultSet.getDouble("consumo_turno1"));
        consumo.setConsumo_turno2(resultSet.getDouble("consumo_turno2"));
        consumo.setConsumo_turno3(resultSet.getDouble("consumo_turno3"));
        consumo.setConsumo_un_turno1(resultSet.getDouble("consumo_un_turno1"));
        consumo.setConsumo_un_turno2(resultSet.getDouble("consumo_un_turno2"));
        consumo.setConsumo_un_turno3(resultSet.getDouble("consumo_un_turno3"));
    }

    // Sobrescreve o método para ler todos os resultados de Consumo
    @Override
    public List<Consumo> readAll() throws SQLException {
        // Define a query da busca
        String sql = "SELECT * FROM Consumo";
        // Cria uma lista de Consumo que armazenará os resultados obtidos
        List<Consumo> results = new ArrayList<>();

        // Tenta executar uma declaração SQL estática, se houver sucesso, retorna o resultado da query
        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            // Enquanto houver resultados da busca, itera sobre eles e os adiciona a lista de resultados
            while (resultSet.next()) {
                // Instancia-se um novo objeto para cada resultado obtido
                Consumo consumo = new Consumo();
                // Insere por setters as informações do objeto vindos da busca no novo objeto instanciado
                setConsumo(resultSet, consumo);
                // Adiciona o objeto à lista
                results.add(consumo);
            }
        }
        return results;
    }

    // Sobrescreve o método para ler um resultado específico de Consumo
    @Override
    public Consumo read(Date data_registro, byte linha_producao) throws SQLException {
        // Define a query da busca
        String sql = "SELECT * FROM Consumo WHERE data_registro = ? AND linha_producao = ?";
        // Inicializando o objeto como nulo
        Consumo consumo = null;

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a busca
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, data_registro);
            preparedStatement.setByte(2, linha_producao);
            // Tenta executar a declaração pré-compilada
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                // Se houver resultados, instancia-se um novo objeto e insere-o o resultado
                if (resultSet.next()) {
                    consumo = new Consumo();
                    setConsumo(resultSet, consumo);
                }
            }
        }
        return consumo;
    }

    // Sobrescreve o método para atualizar um resultado específico de Consumo
    @Override
    public void update(Consumo consumo) throws SQLException {
        // Define a query da alteração
        String sql = "UPDATE Consumo SET consumo_turno1 = ?, " +
                "consumo_turno2 = ?, " +
                "consumo_turno3 = ?, " +
                "consumo_un_turno1 = ?, " +
                "consumo_un_turno2 = ?, " +
                "consumo_un_turno3 = ? " +
                "WHERE data_registro = ? AND linha_producao = ?";

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a alteração
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, consumo.getConsumo_turno1());
            preparedStatement.setDouble(2, consumo.getConsumo_turno2());
            preparedStatement.setDouble(3, consumo.getConsumo_turno3());
            preparedStatement.setDouble(4, consumo.getConsumo_un_turno1());
            preparedStatement.setDouble(5, consumo.getConsumo_un_turno2());
            preparedStatement.setDouble(6, consumo.getConsumo_un_turno3());
            preparedStatement.setDate(7, consumo.getData_registro());
            preparedStatement.setByte(8, consumo.getLinha_producao());
            // Envia a query para ser executada
            preparedStatement.executeUpdate();
        }
    }

    // Sobrescreve o método da deleção de um resultado específico de ObjetivoConsumoMax
    @Override
    public void delete(Consumo consumo) throws SQLException {
        // Define a query da deleção
        String sql = "DELETE FROM Consumo WHERE data_registro = ? AND linha_producao = ?";

        // Tenta pré-compilar uma declaração SQL utilizando os atributos-chave do objeto para a deleção
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, consumo.getData_registro());
            preparedStatement.setByte(2, consumo.getLinha_producao());
            // Envia a query para ser executada
            preparedStatement.executeUpdate();
        }
    }
}
