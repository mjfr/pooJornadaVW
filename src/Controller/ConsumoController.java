package Controller;

import Dao.GenericDao;
import Model.Consumo;

import java.sql.Date;
import java.util.Scanner;

public class ConsumoController extends AbstractController<Consumo> {
    // Construtor para definir o DAO que está sendo utilizado
    public ConsumoController(GenericDao<Consumo> dao) {
        super(dao);
    }

    // Método personalizado para imitar um ON CASCADE DELETE
    public void unsafeCascadeDelete(Date data_registro, byte linha_producao, ProducaoController producaoController, ObjetivoConsumoMaxController objetivoConsumoMaxController, ConsumoController consumoController) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("MÉTODO EXTREMAMENTE INSEGURO! ANTES DE PROSSEGUIR, TENHA CERTEZA QUE A ENTIDADE CONSUMO SERÁ O ÚLTIMO PARÂMETRO A SER PASSADO!!!");
            System.out.print("Para deletar um registro de consumo, não pode haver referências sobre si nos registros de \"Producao\" e/ou \"ObjetivoConsumoMax\"\nDeseja realmente excluir o consumo:\n" + consumoController.read(data_registro, linha_producao) + "\nDigite \"S\" para confirmar ou \"N\" para cancelar: ");
            // Se houver correspondência no input do usuário, prossegue
            if (scanner.nextLine().toLowerCase().startsWith("s")) {
                // Inicia a deleção a partir das tabelas que utilizam as chaves primárias de consumo, para assim deletar o consumo por fim.
                producaoController.delete(producaoController.read(data_registro, linha_producao));
                objetivoConsumoMaxController.delete(objetivoConsumoMaxController.read(data_registro, linha_producao));
                consumoController.delete(consumoController.read(data_registro, linha_producao));
                System.out.println("Método que tenta imitar um \"cascade delete\" realizado com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
