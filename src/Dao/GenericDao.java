package Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    public void create(T entity) throws SQLException;
    public List<T> readAll() throws SQLException;
    public T read(Date data_registro, byte linha_producao) throws SQLException;
    public void update(T entity) throws SQLException;
    public void delete(T entity) throws SQLException;

}
