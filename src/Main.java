import Controller.ConsumoController;
import Controller.ObjetivoConsumoMaxController;
import Controller.ProducaoController;
import Dao.ConsumoDao;
import Dao.ObjetivoConsumoMaxDao;
import Dao.ProducaoDao;
import Dao.ConnectionFactory;
import View.Menu;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    // Método que cria instâncias dos DAOs e Controllers, estabelecendo uma conexão com o DB e retorna uma instância de Menu
    private static Menu getMenu(Connection connection) {
        ConsumoDao consumoDao = new ConsumoDao(connection);
        ProducaoDao producaoDao = new ProducaoDao(connection);
        ObjetivoConsumoMaxDao objetivoConsumoMaxDao = new ObjetivoConsumoMaxDao(connection);

        ConsumoController consumoController = new ConsumoController(consumoDao);
        ProducaoController producaoController = new ProducaoController(producaoDao, consumoController);
        ObjetivoConsumoMaxController objetivoConsumoMaxController = new ObjetivoConsumoMaxController(objetivoConsumoMaxDao, consumoController);

        return new Menu(consumoController, producaoController, objetivoConsumoMaxController);
    }

    // Método principal da aplicação, executa tudo o que foi criado
    public static void main(String[] args) throws SQLException {
        // Define a conexão do banco de dados
        Connection connection = ConnectionFactory.getConnection();

        // Define o menu com a conexão criada
        Menu menu = getMenu(connection);

        // Mostra o menu no terminal
        menu.showMainMenu();

        // Se a conexão não for nula, fecha após a finalização do usuário
        if (connection != null) {
            connection.close();
            System.out.println("Conexão com o banco de dados encerrada com sucesso!");
        }
    }
}