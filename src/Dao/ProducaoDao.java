package Dao;

import Model.Consumo;
import Model.Producao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducaoDao extends AbstractDao<Producao> {

    public ProducaoDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Producao producao) throws SQLException {
        String sql = "INSERT INTO Producao (data_registro, " +
                "linha_producao, " +
                "producao_turno1, " +
                "producao_turno2, " +
                "producao_turno3) " +
                "VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, producao.getData_registro());
            preparedStatement.setByte(2, producao.getLinha_producao());
            preparedStatement.setDouble(3, producao.getProducao_turno1());
            preparedStatement.setDouble(4, producao.getProducao_turno2());
            preparedStatement.setDouble(5, producao.getProducao_turno3());
            preparedStatement.execute();
        }
    }

    @Override
    public List<Producao> readAll() throws SQLException {
        String sql = "SELECT * FROM Producao";
        List<Producao> results = new ArrayList<>();

        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                Producao producao = new Producao();
                producao.setData_registro(resultSet.getDate("data_registro"));
                producao.setLinha_producao(resultSet.getByte("linha_producao"));
                producao.setProducao_turno1(resultSet.getDouble("producao_turno1"));
                producao.setProducao_turno2(resultSet.getDouble("producao_turno2"));
                producao.setProducao_turno3(resultSet.getDouble("producao_turno3"));
                results.add(producao);
            }
        }
        return results;
    }

    @Override
    public Producao read(Date data_registro, byte linha_producao) throws SQLException {
        String sql = "SELECT * FROM Producao WHERE data_registro = ? AND linha_producao = ?";
        Producao producao = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, data_registro);
            preparedStatement.setByte(2, linha_producao);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    producao = new Producao();
                    producao.setData_registro(resultSet.getDate("data_registro"));
                    producao.setLinha_producao(resultSet.getByte("linha_producao"));
                    producao.setProducao_turno1(resultSet.getDouble("producao_turno1"));
                    producao.setProducao_turno2(resultSet.getDouble("producao_turno2"));
                    producao.setProducao_turno3(resultSet.getDouble("producao_turno3"));
                }
            }
        }
        return producao;
    }

    @Override
    public void update(Producao producao) throws SQLException {
        String sql = "UPDATE Producao SET producao_turno1 = ?, " +
                "producao_turno2 = ?, " +
                "producao_turno3 = ? " +
                "WHERE data_registro = ? AND linha_producao = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, producao.getProducao_turno1());
            preparedStatement.setDouble(2, producao.getProducao_turno2());
            preparedStatement.setDouble(3, producao.getProducao_turno3());
            preparedStatement.setDate(4, producao.getData_registro());
            preparedStatement.setByte(5, producao.getLinha_producao());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Producao producao) throws SQLException {
        String sql = "DELETE FROM Producao WHERE data_registro = ? AND linha_producao = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, producao.getData_registro());
            preparedStatement.setByte(2, producao.getLinha_producao());
            preparedStatement.executeUpdate();
        }
    }
}
