package Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/*
* Uma interface é uma referência de tipo, ou seja, contém apenas assinaturas de métodos.
* Declara um conjunto de métodos fazendo com que todas as classes que use a interface, devem implementar seus métodos.
* Não pode conter construtores.
*/

public interface GenericDao<T> {
    void create(T entity) throws SQLException;
    List<T> readAll() throws SQLException;
    T read(Date data_registro, byte linha_producao) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(T entity) throws SQLException;

}
