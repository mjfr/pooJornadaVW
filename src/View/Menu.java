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

    // Construtor que define os controllers que serão utilizados no menu
    public Menu(ConsumoController consumoController, ProducaoController producaoController, ObjetivoConsumoMaxController objetivoConsumoMaxController) {
        this.consumoController = consumoController;
        this.producaoController = producaoController;
        this.objetivoConsumoMaxController = objetivoConsumoMaxController;
    }

    // Mostra o menu principal
    public void showMainMenu() {
        // Menu
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
        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 4, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Leva aos outros menus
            case 1 -> this.showCreateMenu();
            case 2 -> this.showReadMenu();
            case 3 -> this.showUpdateMenu();
            case 4 -> this.showDeleteMenu();
        }

    }

    // Mostra o menu de cadastros
    public void showCreateMenu() {
        // Menu
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

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 5, "Sua Escolha: ");
        // Instancia um novo objeto de ObjectViewHelper
        ObjectViewHelper object = new ObjectViewHelper();

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Cadastra as entidades escolhidas
            case 1 -> {
                // Valida o formato do tipo de dado digitado
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                // Valida os limites e o tipo de dados recebido do input
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                // Passa ao controller o objeto que será criado com as chaves primárias definidas previamente
                consumoController.create(object.createConsumoObject(reqDate, reqLinha_producao));
                // Mostra o mesmo menu novamente
                this.showCreateMenu();
            }
            case 2 -> {
                // Valida o formato do tipo de dado digitado
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                // Valida os limites e o tipo de dados recebido do input
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                // Passa ao controller o objeto que será criado com as chaves primárias definidas previamente
                producaoController.create(object.createProducaoObject(reqDate, reqLinha_producao));
                // Mostra o mesmo menu novamente
                this.showCreateMenu();
            }
            case 3 -> {
                // Valida o formato do tipo de dado digitado
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                // Valida os limites e o tipo de dados recebido do input
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                // Passa ao controller o objeto que será criado com as chaves primárias definidas previamente
                objetivoConsumoMaxController.create(object.createObjetivoConsumoMaxObject(reqDate, reqLinha_producao));
                // Mostra o mesmo menu novamente
                this.showCreateMenu();
            }
            // Cadastra todos os dados de todas as entidades em um fluxo único
            case 4 -> {
                // Valida o formato do tipo de dado digitado
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja cadastrar: ");
                // Valida os limites e o tipo de dados recebido do input
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja cadastrar: ");
                // Passa ao controller o objeto que será criado com as chaves primárias definidas previamente
                consumoController.create(object.createConsumoObject(reqDate, reqLinha_producao));
                producaoController.create(object.createProducaoObject(reqDate, reqLinha_producao));
                objetivoConsumoMaxController.create(object.createObjetivoConsumoMaxObject(reqDate, reqLinha_producao));
                // Mostra o mesmo menu novamente
                this.showCreateMenu();
            }
            // Retorna ao menu principal
            case 5 -> this.showMainMenu();
        }
    }

    // Mostra o menu de buscas
    public void showReadMenu() {
        // Menu
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

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 7, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Realiza as buscas específicas ou gerais
            case 1 -> {
                // Realiza uma busca utilizando as chaves primárias da entidade e a retorna em seu específico objeto
                Consumo consumo = consumoController.read(scannerValidation.validateSqlDateScanner("Digite a Data: "), scannerValidation.validateByteScanner(0, 100, "Digite a Linha de Produção: "));
                System.out.println(consumo);
                // Mostra o mesmo menu novamente
                this.showReadMenu();
            }
            case 2 -> {
                // Cria uma lista e adiciona todos os resultados da busca
                List<Consumo> consumoList = consumoController.readAll();
                System.out.println(consumoList);
                // Mostra o mesmo menu novamente
                this.showReadMenu();
            }
            case 3 -> {
                // Realiza uma busca utilizando as chaves primárias da entidade e a retorna em seu específico objeto
                Producao producao = producaoController.read(scannerValidation.validateSqlDateScanner("Digite a Data: "), scannerValidation.validateByteScanner(0, 100, "Digite a Linha de Produção: "));
                System.out.println(producao);
                // Mostra o mesmo menu novamente
                this.showReadMenu();
            }
            case 4 -> {
                // Cria uma lista e adiciona todos os resultados da busca
                List<Producao> producaoList = producaoController.readAll();
                System.out.println(producaoList);
                // Mostra o mesmo menu novamente
                this.showReadMenu();
            }
            case 5 -> {
                // Realiza uma busca utilizando as chaves primárias da entidade e a retorna em seu específico objeto
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(scannerValidation.validateSqlDateScanner("Digite a Data: "), scannerValidation.validateByteScanner(0, 100, "Digite a Linha de Produção: "));
                System.out.println(objetivoConsumoMax);
                // Mostra o mesmo menu novamente
                this.showReadMenu();
            }
            case 6 -> {
                // Cria uma lista e adiciona todos os resultados da busca
                List<ObjetivoConsumoMax> objetivoConsumoMaxList = objetivoConsumoMaxController.readAll();
                System.out.println(objetivoConsumoMaxList);
                // Mostra o mesmo menu novamente
                this.showReadMenu();
            }
            // Retorna ao menu principal
            case 7 -> this.showMainMenu();
        }
    }


    // Mostra o menu preenchido com os resultados da busca
    public void showConsumo(Consumo consumo) {
        // Formata o texto para mostrar dado a dado da entidade preenchida com o que foi retornado da busca
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

        // Lista com os atributos da entidade a serem formatados
        Object[] args = {consumo.getConsumo_turno1(),
                consumo.getConsumo_turno2(),
                consumo.getConsumo_turno3(),
                consumo.getConsumo_un_turno1(),
                consumo.getConsumo_un_turno2(),
                consumo.getConsumo_un_turno3()};

        System.out.print(messageFormat.format(args));
    }

    // Mostra o menu de atualizações de consumo
    public void showUpdateConsumo(Consumo consumo) {
        // Passa o objeto a ser atualizado para o menu que o mostra
        this.showConsumo(consumo);

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 9, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Define as novas informações da entidade a ser alterada
            case 1 -> {
                // Valida o tipo de dado escrito e o define no objeto
                consumo.setConsumo_turno1(scannerValidation.validateDoubleScanner("O novo valor de consumo_turno1 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateConsumo(consumo);
            }
            case 2 -> {
                // Valida o tipo de dado escrito e o define no objeto
                consumo.setConsumo_turno2(scannerValidation.validateDoubleScanner("O novo valor de consumo_turno2 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateConsumo(consumo);
            }
            case 3 -> {
                // Valida o tipo de dado escrito e o define no objeto
                consumo.setConsumo_turno3(scannerValidation.validateDoubleScanner("O novo valor de consumo_turno3 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateConsumo(consumo);
            }
            case 4 -> {
                // Valida o tipo de dado escrito e o define no objeto
                consumo.setConsumo_un_turno1(scannerValidation.validateDoubleScanner("O novo valor de consumo_un_turno1 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateConsumo(consumo);
            }
            case 5 -> {
                // Valida o tipo de dado escrito e o define no objeto
                consumo.setConsumo_un_turno2(scannerValidation.validateDoubleScanner("O novo valor de consumo_un_turno2 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateConsumo(consumo);
            }
            case 6 -> {
                // Valida o tipo de dado escrito e o define no objeto
                consumo.setConsumo_un_turno3(scannerValidation.validateDoubleScanner("O novo valor de consumo_un_turno3 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateConsumo(consumo);
            }
            // Efetiva as alterações
            case 7 -> {
                consumoController.update(consumo);
                // Retorna ao mesmo menu novamente
                this.showUpdateMenu();
            }
            // Retorna ao menu principal
            case 8 -> this.showMainMenu();
        }
    }

    // Mostra o menu preenchido com os resultados da busca
    public void showProducao(Producao producao) {
        // Formata o texto para mostrar dado a dado da entidade preenchida com o que foi retornado da busca
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

        // Lista com os atributos da entidade a serem formatados
        Object[] args = {producao.getProducao_turno1(),
                producao.getProducao_turno2(),
                producao.getProducao_turno3()};
        System.out.print(messageFormat.format(args));
    }

    // Mostra o menu de atualizações de producao
    public void showUpdateProducao(Producao producao) {
        // Passa o objeto a ser atualizado para o menu que o mostra
        this.showProducao(producao);

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 5, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Define as novas informações da entidade a ser alterada
            case 1 -> {
                // Valida o tipo de dado escrito e o define no objeto
                producao.setProducao_turno1(scannerValidation.validateDoubleScanner("O novo valor de producao_turno1 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateProducao(producao);
            }
            case 2 -> {
                // Valida o tipo de dado escrito e o define no objeto
                producao.setProducao_turno2(scannerValidation.validateDoubleScanner("O novo valor de producao_turno2 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateProducao(producao);
            }
            case 3 -> {
                // Valida o tipo de dado escrito e o define no objeto
                producao.setProducao_turno3(scannerValidation.validateDoubleScanner("O novo valor de producao_turno3 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateProducao(producao);
            }
            // Realiza a alteração
            case 4 -> {
                producaoController.update(producao);
                // Retorna ao mesmo menu
                this.showUpdateMenu();
            }
            // Retorna ao menu principal
            case 8 -> this.showMainMenu();
        }
    }

    // Mostra o menu preenchido com os resultados da busca
    public void showObjetivoConsumoMax(ObjetivoConsumoMax objetivoConsumoMax) {
        // Formata o texto para mostrar dado a dado da entidade preenchida com o que foi retornado da busca
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

        // Lista com os atributos da entidade a serem formatados
        Object[] args = {objetivoConsumoMax.getObjetivo1(),
                objetivoConsumoMax.getObjetivo2(),
                objetivoConsumoMax.getObjetivo3(),
                objetivoConsumoMax.getDesperdicio_turno1(),
                objetivoConsumoMax.getDesperdicio_turno2(),
                objetivoConsumoMax.getDesperdicio_turno3()};
        System.out.print(messageFormat.format(args));
    }

    // Mostra o menu de atualizações de objetivoConsumoMax
    public void showUpdateObjetivoConsumoMax(ObjetivoConsumoMax objetivoConsumoMax) {
        // Passa o objeto a ser atualizado para o menu que o mostra
        this.showObjetivoConsumoMax(objetivoConsumoMax);

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 9, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Define as novas informações da entidade a ser alterada
            case 1 -> {
                // Valida o tipo de dado escrito e o define no objeto
                objetivoConsumoMax.setObjetivo1(scannerValidation.validateDoubleScanner("O novo valor de objetivo1 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 2 -> {
                // Valida o tipo de dado escrito e o define no objeto
                objetivoConsumoMax.setObjetivo2(scannerValidation.validateDoubleScanner("O novo valor de objetivo2 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 3 -> {
                // Valida o tipo de dado escrito e o define no objeto
                objetivoConsumoMax.setObjetivo3(scannerValidation.validateDoubleScanner("O novo valor de objetivo3 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 4 -> {
                // Valida o tipo de dado escrito e o define no objeto
                objetivoConsumoMax.setDesperdicio_turno1(scannerValidation.validateDoubleScanner("O novo valor de desperdicio_turno1 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 5 -> {
                // Valida o tipo de dado escrito e o define no objeto
                objetivoConsumoMax.setDesperdicio_turno2(scannerValidation.validateDoubleScanner("O novo valor de desperdicio_turno2 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            case 6 -> {
                // Valida o tipo de dado escrito e o define no objeto
                objetivoConsumoMax.setDesperdicio_turno3(scannerValidation.validateDoubleScanner("O novo valor de desperdicio_turno3 será: "));
                // Chama novamente o mesmo menu, porém com os dados pré-atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
            }
            // Realiza a alteração
            case 7 -> {
                objetivoConsumoMaxController.update(objetivoConsumoMax);
                // Retorna ao mesmo menu
                this.showUpdateMenu();
            }
            // Retorna ao menu principal
            case 8 -> this.showMainMenu();
        }
    }

    // Mostra o menu de alterações
    public void showUpdateMenu() {
        // Menu
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

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 4, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Escolhe qual entidade será atualizada
            case 1 -> {
                // Lê a entidade a ser atualizada a partir de suas chaves principais
                Consumo consumo = consumoController.read(scannerValidation.validateSqlDateScanner("Data do consumo que deseja alterar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja alterar: "));
                // Chama o menu com os atributos que podem ser atualizados
                this.showUpdateConsumo(consumo);
                // Retorna ao mesmo menu
                this.showUpdateMenu();
            }
            case 2 -> {
                // Lê a entidade a ser atualizada a partir de suas chaves principais
                Producao producao = producaoController.read(scannerValidation.validateSqlDateScanner("Data da producao que deseja alterar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja alterar: "));
                // Chama o menu com os atributos que podem ser atualizados
                this.showUpdateProducao(producao);
                // Retorna ao mesmo menu
                this.showUpdateMenu();
            }
            case 3 -> {
                // Lê a entidade a ser atualizada a partir de suas chaves principais
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(scannerValidation.validateSqlDateScanner("Data do objetivoConsumoMax que deseja alterar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja alterar: "));
                // Chama o menu com os atributos que podem ser atualizados
                this.showUpdateObjetivoConsumoMax(objetivoConsumoMax);
                // Retorna ao mesmo menu
                this.showUpdateMenu();
            }
            // Retorna ao menu principal
            case 4 -> this.showMainMenu();
        }
    }

    // Mostra o menu de deleções
    public void showDeleteMenu() {
        // Menu
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

        // Define o limite das opções, uma mensagem e qual o tipo de dado será recebido do input
        int input = scannerValidation.validateByteScanner(0, 5, "Sua Escolha: ");

        // Switch case para definir qual ação será tomada
        switch (input) {
            // Encerra a aplicação com código 0 (sem erros)
            case 0 -> {
                System.out.println("Encerrando...");
                System.exit(0);
            }
            // Seleciona qual(is) entidade(s) serão deletadas
            case 1 -> {
                // Busca a entidade a partir das chaves primárias para deletá-la
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja deletar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: ");
                Consumo consumo = consumoController.read(reqDate, reqLinha_producao);
                Producao producao = producaoController.read(reqDate, reqLinha_producao);
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(reqDate, reqLinha_producao);
                // Se houver um consumo, porém não houver produção e objetivoConsumoMax, é uma entidade que pode ser deletada sem problemas
                if (consumo != null && producao == null && objetivoConsumoMax == null)
                    this.consumoController.delete(consumo);
                // Retorna ao mesmo menu
                this.showDeleteMenu();
            }
            case 2 -> {
                // Busca a entidade a partir das chaves primárias para deletá-la
                Date reqDate = scannerValidation.validateSqlDateScanner("Data do consumo que deseja deletar: ");
                byte reqLinha_producao = scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: ");
                Consumo consumo = consumoController.read(reqDate, reqLinha_producao);
                // Se o objeto foi encontrado, deleta o mesmo
                if (consumo != null)
                    // Faz uma deleção como se fosse um "delete on cascade"
                    this.consumoController.unsafeCascadeDelete(reqDate, reqLinha_producao, producaoController, objetivoConsumoMaxController, consumoController);
                // Retorna ao mesmo menu
                this.showDeleteMenu();
            }
            case 3 -> {
                // Busca a entidade a partir das chaves primárias para deletá-la
                Producao producao = producaoController.read(scannerValidation.validateSqlDateScanner("Data da producao que deseja deletar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: "));
                // Se o objeto foi encontrado, deleta o mesmo
                if (producao != null)
                    producaoController.delete(producao);
                // Retorna ao mesmo menu
                this.showDeleteMenu();
            }
            case 4 -> {
                // Busca a entidade a partir das chaves primárias para deletá-la
                ObjetivoConsumoMax objetivoConsumoMax = objetivoConsumoMaxController.read(scannerValidation.validateSqlDateScanner("Data do objetivoConsumoMax que deseja deletar: "), scannerValidation.validateByteScanner(1, 100, "Linha de Produção do Consumo que deseja deletar: "));
                // Se o objeto foi encontrado, deleta o mesmo
                if (objetivoConsumoMax != null)
                    objetivoConsumoMaxController.delete(objetivoConsumoMax);
                // Retorna ao mesmo menu
                this.showDeleteMenu();
            }
            // Retorna ao menu principal
            case 5 -> this.showMainMenu();
        }
    }
}
