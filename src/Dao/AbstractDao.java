package Dao;

import java.sql.Connection;

/*
 * Uma classe abstrata é uma classe que não pode ser instanciada.
 * Pode conter métodos abstratos como uma interface (métodos sem corpo, apenas sua assinatura) e métodos não abstratos.
 * É possível utilizar uma classe abstrata para fornecer implementações padrões dos métodos de uma interface, ou seja,
 * implementar os métodos da interface e preencher seu corpo como um padrão. Ao ser estendida para outra classe,
 * esse padrão pode ser mantido ou alterado.
*/
public abstract class AbstractDao<T> implements GenericDao<T> {
    protected Connection connection;

    // Construtor para definir a conexão com o banco de dados
    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

}
