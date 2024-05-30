package Dao;

import Model.Consumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDao extends AbstractDao<Consumo> {
    public ConsumoDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Consumo consumo) throws SQLException {
        String sql = "INSERT INTO Consumo (data_registro, " +
                "linha_producao, " +
                "consumo_turno1, " +
                "consumo_turno2, " +
                "consumo_turno3, " +
                "consumo_un_turno1, " +
                "consumo_un_turno2, " +
                "consumo_un_turno3) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Consumo> readAll() throws SQLException {
        String sql = "SELECT * FROM Consumo";
        List<Consumo> results = new ArrayList<>();

        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                Consumo consumo = new Consumo();
                consumo.setData_registro(resultSet.getDate("data_registro"));
                consumo.setLinha_producao(resultSet.getByte("linha_producao"));
                consumo.setConsumo_turno1(resultSet.getDouble("consumo_turno1"));
                consumo.setConsumo_turno2(resultSet.getDouble("consumo_turno2"));
                consumo.setConsumo_turno3(resultSet.getDouble("consumo_turno3"));
                consumo.setConsumo_un_turno1(resultSet.getDouble("consumo_un_turno1"));
                consumo.setConsumo_un_turno2(resultSet.getDouble("consumo_un_turno2"));
                consumo.setConsumo_un_turno3(resultSet.getDouble("consumo_un_turno3"));
                results.add(consumo);
            }
        }
        return results;
    }

    @Override
    public Consumo read(Date data_registro, byte linha_producao) throws SQLException {
        String sql = "SELECT * FROM Consumo WHERE data_registro = ? AND linha_producao = ?";
        Consumo consumo = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, data_registro);
            preparedStatement.setByte(2, linha_producao);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    consumo = new Consumo();
                    consumo.setData_registro(resultSet.getDate("data_registro"));
                    consumo.setLinha_producao(resultSet.getByte("linha_producao"));
                    consumo.setConsumo_turno1(resultSet.getDouble("consumo_turno1"));
                    consumo.setConsumo_turno2(resultSet.getDouble("consumo_turno2"));
                    consumo.setConsumo_turno3(resultSet.getDouble("consumo_turno3"));
                    consumo.setConsumo_un_turno1(resultSet.getDouble("consumo_un_turno1"));
                    consumo.setConsumo_un_turno2(resultSet.getDouble("consumo_un_turno2"));
                    consumo.setConsumo_un_turno3(resultSet.getDouble("consumo_un_turno3"));
                }
            }
        }
        return consumo;
    }

    @Override
    public void update(Consumo consumo) throws SQLException {
        String sql = "UPDATE Consumo SET consumo_turno1 = ?, " +
                "consumo_turno2 = ?, " +
                "consumo_turno3 = ?, " +
                "consumo_un_turno1 = ?, " +
                "consumo_un_turno2 = ?, " +
                "consumo_un_turno3 = ? " +
                "WHERE data_registro = ? AND linha_producao = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, consumo.getConsumo_turno1());
            preparedStatement.setDouble(2, consumo.getConsumo_turno2());
            preparedStatement.setDouble(3, consumo.getConsumo_turno3());
            preparedStatement.setDouble(4, consumo.getConsumo_un_turno1());
            preparedStatement.setDouble(5, consumo.getConsumo_un_turno2());
            preparedStatement.setDouble(6, consumo.getConsumo_un_turno3());
            preparedStatement.setDate(7, consumo.getData_registro());
            preparedStatement.setByte(8, consumo.getLinha_producao());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Consumo consumo) throws SQLException {
        String sql = "DELETE FROM Consumo WHERE data_registro = ? AND linha_producao = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, consumo.getData_registro());
            preparedStatement.setByte(2, consumo.getLinha_producao());
            preparedStatement.executeUpdate();
        }
    }
}
