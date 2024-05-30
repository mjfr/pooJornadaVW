package Controller;

import Dao.GenericDao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<T> {
    protected GenericDao<T> dao;

    public AbstractController(GenericDao<T> dao) {
        this.dao = dao;
    }

    // Métodos abaixo

    public void create(T entity) {
        try {
            dao.create(entity);
            System.out.println("Inserção realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public List<T> readAll() {
        List<T> result = null;
        try {
            result = dao.readAll();
            System.out.println("A busca retornou resultados!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return result;
    }

    public T read(Date data_registro, byte linha_producao) {
        T result = null;
        try {
            result = dao.read(data_registro, linha_producao);
            System.out.println("Busca realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return result;
    }

    public void update(T entity) {
        try {
            dao.update(entity);
            System.out.println("Atualização realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public void delete(T entity) {
        try {
            dao.delete(entity);
            System.out.println("Deleção realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

}
