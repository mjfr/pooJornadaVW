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
    private static Menu getMenu(Connection connection) {
        ConsumoDao consumoDao = new ConsumoDao(connection);
        ProducaoDao producaoDao = new ProducaoDao(connection);
        ObjetivoConsumoMaxDao objetivoConsumoMaxDao = new ObjetivoConsumoMaxDao(connection);

        ConsumoController consumoController = new ConsumoController(consumoDao);
        ProducaoController producaoController = new ProducaoController(producaoDao, consumoController);
        ObjetivoConsumoMaxController objetivoConsumoMaxController = new ObjetivoConsumoMaxController(objetivoConsumoMaxDao, consumoController);

        return new Menu(consumoController, producaoController, objetivoConsumoMaxController);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        Menu menu = getMenu(connection);
        menu.showMainMenu();

        if (connection != null) {
            connection.close();
            System.out.println("Conexão com o banco de dados encerrada com sucesso!");
        }
    }
}