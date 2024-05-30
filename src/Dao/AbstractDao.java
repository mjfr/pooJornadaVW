package Dao;

import java.sql.Connection;

public abstract class AbstractDao<T> implements GenericDao<T> {
    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

//    protected abstract T getEntityFromResultSet(ResultSet resultSet) throws SQLException;
//    protected abstract void setEntityToPreparedStatement(T entity, PreparedStatement preparedStatement) throws SQLException;


}
