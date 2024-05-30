package View;

import Controller.ConsumoController;
import Controller.ObjetivoConsumoMaxController;
import Controller.ProducaoController;
import Model.Consumo;
import Model.ObjetivoConsumoMax;
import Model.Producao;
import ViewHelper.ObjectViewHelper;
import ViewHelper.ScannerValidation;

import java.sql.Date;
import java.text.MessageFormat;
import java.util.List;

public class Menu {
    private final ScannerValidation scannerValidation = new ScannerValidation();
    private final ConsumoController consumoController;
    private final ProducaoController producaoController;
    private final ObjetivoConsumoMaxController objetivoConsumoMaxController;

    public Menu(ConsumoController consumoController, ProducaoController producaoController, ObjetivoConsumoMaxController objetivoConsumoMaxController) {
        this.consumoController = consumoController;
        this.producaoController = producaoController;
        this.objetivoConsumoMaxController = objetivoConsumoMaxController;
    }

    public void showMainMenu() {
        System.out.print(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                         Menu Principal                        =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) Cadastrar informações                                     =
                = 2-) Buscar informações                                        =
                = 3-) Alterar informações                                       =
                = 4-) Deletar informações                                       =
                = 0-) Sair                                                      =
                =================================================================
                """
        );
        int input = scannerValidation.validateByteScanner(0, 4, "Sua Escolha: ");

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> this.showCreateMenu();
            case 2 -> this.showReadMenu();
            case 3 -> this.showUpdateMenu();
            case 4 -> this.showDeleteMenu();
        }

    }

    public void showCreateMenu() {
        System.out.print(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                       Menu de Cadastros                       =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) Cadastrar Consumo                                         =
                = 2-) Cadastrar Produção                                        =
                = 3-) Cadastrar Objetivo/Desperdício                            =
                = 4-) Cadastrar Fluxo Completo                                  =
                = 5-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );

        int input = scannerValidation.validateByteScanner(0, 5, "Sua Escolha: ");
        ObjectViewHelper object = new ObjectViewHelper();

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                consumoController.create(object.createConsumoObject(reqDate, reqLinha_producao));
                this.showCreateMenu();
            }
            case 2 -> {
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                producaoController.create(object.createProducaoObject(reqDate, reqLinha_producao));
                this.showCreateMenu();
            }
            case 3 -> {
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                objetivoConsumoMaxController.create(object.createObjetivoConsumoMaxObject(reqDate, reqLinha_producao));
                this.showCreateMenu();
            }
            case 4 -> {
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                consumoController.create(object.createConsumoObject(reqDate, reqLinha_producao));
                producaoController.create(object.createProducaoObject(reqDate, reqLinha_producao));
                objetivoConsumoMaxController.create(object.createObjetivoConsumoMaxObject(reqDate, reqLinha_producao));
                this.showCreateMenu();
            }
            case 5 -> this.showMainMenu();
        }
    }

    public void showReadMenu() {
        System.out.print(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                       Menu de Buscas                          =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) Buscar Consumo por Identificador                          =
                = 2-) Buscar Todos Consumos                                     =
                = 3-) Buscar Produção por Identificador                         =
                = 4-) Buscar Todas Produções                                    =
                = 5-) Buscar Objetivo/Desperdício por Identificador             =
                = 6-) Buscar Todos Objetivos/Desperdícios                       =
                = 7-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );

        int input = scannerValidation.validateByteScanner(0, 7, "Sua Escolha: ");

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                Consumo consumo = consumoController.read(scannerValidation.validateSqlDateScanner("Digite a Data: "), scannerValidation.validateByteScanner(0, 100, "Digite a Linha de Produção: "));
                System.out.println(consumo);
                this.showReadMenu();
            }
            case 2 -> {
                List<Consumo> consumoList = consumoController.readAll();
                System.out.println(consumoList);
                this.showReadMenu();
            }
            case 3 -> {
                Producao producao = producaoController.read(scannerValidation.validateSqlDateScanner("Digite a Data: "), scannerValidation.validateByteScanner(0, 100, "Digite a Linha de Produção: "));
                System.out.println(producao);
                this.showReadMenu();
            }
            case 4 -> {
                List<Producao> producaoList = producaoController.readAll();
                System.out.println(producaoList);
                this.showReadMenu();
            }
            case 5 -> {
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(scannerValidation.validateSqlDateScanner("Digite a Data: "), scannerValidation.validateByteScanner(0, 100, "Digite a Linha de Produção: "));
                System.out.println(objetivoConsumoMax);
                this.showReadMenu();
            }
            case 6 -> {
                List<ObjetivoConsumoMax> objetivoConsumoMaxList = objetivoConsumoMaxController.readAll();
                System.out.println(objetivoConsumoMaxList);
                this.showReadMenu();
            }
            case 7 -> this.showMainMenu();
        }
    }

    public void showConsumo(Consumo consumo) {
        MessageFormat messageFormat = new MessageFormat(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                   Menu de Buscas (Consumo)                    =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) consumo_turno1: {0}                                       =
                = 2-) consumo_turno2: {1}                                       =
                = 3-) consumo_turno3: {2}                                       =
                = 4-) consumo_un_turno1: {3}                                    =
                = 5-) consumo_un_turno2: {4}                                    =
                = 6-) consumo_un_turno3: {5}                                    =
                = 7-) Confirmar alterações                                      =
                = 8-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );
        Object[] args = {consumo.getConsumo_turno1(),
                consumo.getConsumo_turno2(),
                consumo.getConsumo_turno3(),
                consumo.getConsumo_un_turno1(),
                consumo.getConsumo_un_turno2(),
                consumo.getConsumo_un_turno3()};
        System.out.print(messageFormat.format(args));
    }

    public void showUpdateConsumo(Consumo consumo) {
        this.showConsumo(consumo);

//        int input = -1;
//        while (input != 7) {
        int input = scannerValidation.validateByteScanner(0, 9, "Sua Escolha: ");

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                consumo.setConsumo_turno1(scannerValidation.validateDoubleScanner("O novo valor de consumo_turno1 será: "));
                this.showUpdateConsumo(consumo);
            }
            case 2 -> {
                consumo.setConsumo_turno2(scannerValidation.validateDoubleScanner("O novo valor de consumo_turno2 será: "));
                this.showUpdateConsumo(consumo);
            }
            case 3 -> {
                consumo.setConsumo_turno3(scannerValidation.validateDoubleScanner("O novo valor de consumo_turno3 será: "));
                this.showUpdateConsumo(consumo);
            }
            case 4 -> {
                consumo.setConsumo_un_turno1(scannerValidation.validateDoubleScanner("O novo valor de consumo_un_turno1 será: "));
                this.showUpdateConsumo(consumo);
            }
            case 5 -> {
                consumo.setConsumo_un_turno2(scannerValidation.validateDoubleScanner("O novo valor de consumo_un_turno2 será: "));
                this.showUpdateConsumo(consumo);
            }
            case 6 -> {
                consumo.setConsumo_un_turno3(scannerValidation.validateDoubleScanner("O novo valor de consumo_un_turno3 será: "));
                this.showUpdateConsumo(consumo);
            }
            case 7 -> {
                consumoController.update(consumo);
                this.showUpdateMenu();
            }
            case 8 -> this.showMainMenu();
        }
//        }
    }

    public void showProducao(Producao producao) {
        MessageFormat messageFormat = new MessageFormat(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                  Menu de Buscas (Producao)                    =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) producao_turno1: {0}                                      =
                = 2-) producao_turno2: {1}                                      =
                = 3-) producao_turno3: {2}                                      =
                = 4-) Confirmar alterações                                      =
                = 5-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );
        Object[] args = {producao.getProducao_turno1(),
                producao.getProducao_turno2(),
                producao.getProducao_turno3()};
        System.out.print(messageFormat.format(args));
    }

    public void showUpdateProducao(Producao producao) {
        this.showProducao(producao);

//        int input = -1;
//        while (input != 4) {
        int input = scannerValidation.validateByteScanner(0, 5, "Sua Escolha: ");

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                producao.setProducao_turno1(scannerValidation.validateDoubleScanner("O novo valor de producao_turno1 será: "));
                this.showUpdateProducao(producao);
            }
            case 2 -> {
                producao.setProducao_turno2(scannerValidation.validateDoubleScanner("O novo valor de producao_turno2 será: "));
                this.showUpdateProducao(producao);
            }
            case 3 -> {
                producao.setProducao_turno3(scannerValidation.validateDoubleScanner("O novo valor de producao_turno3 será: "));
                this.showUpdateProducao(producao);
            }
            case 4 -> {
                producaoController.update(producao);
                this.showUpdateMenu();
            }
            case 8 -> this.showMainMenu();
        }
//        }
    }

    public void showObjetivoConsumoMax(ObjetivoConsumoMax objetivoConsumoMax) {
        MessageFormat messageFormat = new MessageFormat(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =              Menu de Buscas (ObjetivoConsumoMax)              =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) objetivo1: {0}                                            =
                = 2-) objetivo2: {1}                                            =
                = 3-) objetivo3: {2}                                            =
                = 4-) desperdicio_turno1: {3}                                   =
                = 5-) desperdicio_turno2: {4}                                   =
                = 6-) desperdicio_turno3: {5}                                   =
                = 7-) Confirmar alterações                                      =
                = 8-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );
        Object[] args = {objetivoConsumoMax.getObjetivo1(),
                objetivoConsumoMax.getObjetivo2(),
                objetivoConsumoMax.getObjetivo3(),
                objetivoConsumoMax.getDesperdicio_turno1(),
                objetivoConsumoMax.getDesperdicio_turno2(),
                objetivoConsumoMax.getDesperdicio_turno3()};
        System.out.print(messageFormat.format(args));
    }

    public void showUpdateObjetivoConsumoMax(ObjetivoConsumoMax objetivoConsumoMax) {
        this.showObjetivoConsumoMax(objetivoConsumoMax);

//        int input = -1;
//        while (input != 7) {
        int input = scannerValidation.validateByteScanner(0, 9, "Sua Escolha: ");

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                objetivoConsumoMax.setObjetivo1(scannerValidation.validateDoubleScanner("O novo valor de objetivo1 será: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 2 -> {
                objetivoConsumoMax.setObjetivo2(scannerValidation.validateDoubleScanner("O novo valor de objetivo2 será: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 3 -> {
                objetivoConsumoMax.setObjetivo3(scannerValidation.validateDoubleScanner("O novo valor de objetivo3 será: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 4 -> {
                objetivoConsumoMax.setDesperdicio_turno1(scannerValidation.validateDoubleScanner("O novo valor de desperdicio_turno1 será: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 5 -> {
                objetivoConsumoMax.setDesperdicio_turno2(scannerValidation.validateDoubleScanner("O novo valor de desperdicio_turno2 será: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 6 -> {
                objetivoConsumoMax.setDesperdicio_turno3(scannerValidation.validateDoubleScanner("O novo valor de desperdicio_turno3 será: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 7 -> {
                objetivoConsumoMaxController.update(objetivoConsumoMax);
                this.showUpdateMenu();
            }
            case 8 -> this.showMainMenu();
        }
//        }
    }

    public void showUpdateMenu() {
        System.out.print(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                      Menu de Alterações                       =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) Alterar Registro de Consumo                               =
                = 2-) Alterar Registro de Produção                              =
                = 3-) Alterar Registro de Objetivo/Desperdício                  =
                = 4-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );

        int input = scannerValidation.validateByteScanner(0, 4, "Sua Escolha: ");


        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                Consumo consumo = consumoController.read(scannerValidation.validateSqlDateScanner("Data do consumo que deseja alterar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja alterar: "));
                this.showUpdateConsumo(consumo);
                this.showUpdateMenu();
            }
            case 2 -> {
                Producao producao = producaoController.read(scannerValidation.validateSqlDateScanner("Data da producao que deseja alterar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja alterar: "));
                this.showUpdateProducao(producao);
                this.showUpdateMenu();
            }
            case 3 -> {
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(scannerValidation.validateSqlDateScanner("Data do objetivoConsumoMax que deseja alterar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja alterar: "));
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
                this.showUpdateMenu();
            }
            case 4 -> this.showMainMenu();
        }
    }

    public void showDeleteMenu() {
        System.out.print(
                """
                =================================================================
                =               Volkswagen - Cadastro de Métricas               =
                =                       Menu de Deleções                        =
                =================================================================
                =                Opções - Utilize apenas números                =
                =================================================================
                = 1-) Deletar Registro de Consumo Sem Relacionamentos           =
                = 2-) Deletar Registro de Consumo e Tabelas Relacionadas        =
                = 3-) Deletar Registro de Produção                              =
                = 4-) Deletar Registro de Objetivo/Desperdício                  =
                = 5-) Retornar ao Menu Principal                                =
                = 0-) Sair                                                      =
                =================================================================
                """
        );

        int input = scannerValidation.validateByteScanner(0, 5, "Sua Escolha: ");

        switch (input) {
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            case 1 -> {
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja deletar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: ");
                Consumo consumo = consumoController.read(reqDate, reqLinha_producao);
                Producao producao = producaoController.read(reqDate, reqLinha_producao);
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(reqDate, reqLinha_producao);
                if (consumo != null && producao == null && objetivoConsumoMax == null)
                    this.consumoController.delete(consumo);
                this.showDeleteMenu();
            }
            case 2 -> {
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja deletar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: ");
                Consumo consumo = consumoController.read(reqDate, reqLinha_producao);
                if (consumo != null)
                    this.consumoController.unsafeCascadeDelete(reqDate, reqLinha_producao, producaoController, objetivoConsumoMaxController, consumoController);
                this.showDeleteMenu();
            }
            case 3 -> {
                Producao producao = producaoController.read(scannerValidation.validateSqlDateScanner("Data da producao que deseja deletar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: "));
                if (producao != null)
                    producaoController.delete(producao);
                this.showDeleteMenu();
            }
            case 4 -> {
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(scannerValidation.validateSqlDateScanner("Data do objetivoConsumoMax que deseja deletar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: "));
                if (objetivoConsumoMax != null)
                    objetivoConsumoMaxController.delete(objetivoConsumoMax);
                this.showDeleteMenu();
            }
            case 5 -> this.showMainMenu();
        }

    }
}
