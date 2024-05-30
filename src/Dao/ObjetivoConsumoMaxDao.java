package Dao;

import Model.ObjetivoConsumoMax;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoConsumoMaxDao extends AbstractDao<ObjetivoConsumoMax> {
    ConnectionFactory connectionFactory;
    public ObjetivoConsumoMaxDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        String sql = "INSERT INTO ObjetivoConsumoMax (data_registro, " +
                "linha_producao, " +
                "objetivo1, " +
                "objetivo2, " +
                "objetivo3, " +
                "desperdicio_turno1, " +
                "desperdicio_turno2, " +
                "desperdicio_turno3) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ObjetivoConsumoMax> readAll() throws SQLException {
        String sql = "SELECT * FROM ObjetivoConsumoMax";
        List<ObjetivoConsumoMax> results = new ArrayList<>();

        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                ObjetivoConsumoMax objetivoConsumoMax = new ObjetivoConsumoMax();
                objetivoConsumoMax.setData_registro(resultSet.getDate("data_registro"));
                objetivoConsumoMax.setLinha_producao(resultSet.getByte("linha_producao"));
                objetivoConsumoMax.setObjetivo1(resultSet.getDouble("objetivo1"));
                objetivoConsumoMax.setObjetivo2(resultSet.getDouble("objetivo2"));
                objetivoConsumoMax.setObjetivo3(resultSet.getDouble("objetivo3"));
                objetivoConsumoMax.setDesperdicio_turno1(resultSet.getDouble("desperdicio_turno1"));
                objetivoConsumoMax.setDesperdicio_turno2(resultSet.getDouble("desperdicio_turno2"));
                objetivoConsumoMax.setDesperdicio_turno3(resultSet.getDouble("desperdicio_turno3"));
                results.add(objetivoConsumoMax);
            }
        }
        return results;
    }

    @Override
    public ObjetivoConsumoMax read(Date data_registro, byte linha_producao) throws SQLException {
        String sql = "SELECT * FROM ObjetivoConsumoMax WHERE data_registro = ? AND linha_producao = ?";
        ObjetivoConsumoMax objetivoConsumoMax = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, data_registro);
            preparedStatement.setByte(2, linha_producao);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    objetivoConsumoMax = new ObjetivoConsumoMax();
                    objetivoConsumoMax.setData_registro(resultSet.getDate("data_registro"));
                    objetivoConsumoMax.setLinha_producao(resultSet.getByte("linha_producao"));
                    objetivoConsumoMax.setObjetivo1(resultSet.getDouble("objetivo1"));
                    objetivoConsumoMax.setObjetivo2(resultSet.getDouble("objetivo2"));
                    objetivoConsumoMax.setObjetivo3(resultSet.getDouble("objetivo3"));
                    objetivoConsumoMax.setDesperdicio_turno1(resultSet.getDouble("desperdicio_turno1"));
                    objetivoConsumoMax.setDesperdicio_turno2(resultSet.getDouble("desperdicio_turno2"));
                    objetivoConsumoMax.setDesperdicio_turno3(resultSet.getDouble("desperdicio_turno3"));
                }
            }
        }
        return objetivoConsumoMax;
    }

    @Override
    public void update(ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        String sql = "UPDATE ObjetivoConsumoMax SET objetivo1 = ?, " +
                "objetivo2 = ?, " +
                "objetivo3 = ?, " +
                "desperdicio_turno1 = ?, " +
                "desperdicio_turno2 = ?, " +
                "desperdicio_turno3 = ? " +
                "WHERE data_registro = ? AND linha_producao = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, objetivoConsumoMax.getObjetivo1());
            preparedStatement.setDouble(2, objetivoConsumoMax.getObjetivo2());
            preparedStatement.setDouble(3, objetivoConsumoMax.getObjetivo3());
            preparedStatement.setDouble(4, objetivoConsumoMax.getDesperdicio_turno1());
            preparedStatement.setDouble(5, objetivoConsumoMax.getDesperdicio_turno2());
            preparedStatement.setDouble(6, objetivoConsumoMax.getDesperdicio_turno3());
            preparedStatement.setDate(7, objetivoConsumoMax.getData_registro());
            preparedStatement.setByte(8, objetivoConsumoMax.getLinha_producao());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(ObjetivoConsumoMax objetivoConsumoMax) throws SQLException {
        String sql = "DELETE FROM ObjetivoConsumoMax WHERE data_registro = ? AND linha_producao = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, objetivoConsumoMax.getData_registro());
            preparedStatement.setByte(2, objetivoConsumoMax.getLinha_producao());
            preparedStatement.executeUpdate();
        }
    }
}
