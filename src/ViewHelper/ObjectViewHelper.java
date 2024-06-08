package ViewHelper;

import Model.Consumo;
import Model.ObjetivoConsumoMax;
import Model.Producao;

import java.sql.Date;

public class ObjectViewHelper {

    private final ScannerValidation scannerValidation = new ScannerValidation();

    // Define em uma entidade, os dados necessários para sua criação. Recebe as chaves primárias da entidade
    public Consumo createConsumoObject(Date reqDate, byte reqLinha_producao) {
        // Instancia a entidade
        Consumo consumo = new Consumo();
        // Define os dados da entidade
        consumo.setData_registro(reqDate);
        consumo.setLinha_producao(reqLinha_producao);
        // Valida os tipos de dados retornados do usuário
        consumo.setConsumo_turno1(scannerValidation.validateDoubleScanner("Consumo do Turno 1 : "));
        consumo.setConsumo_turno2(scannerValidation.validateDoubleScanner("Consumo do Turno 2 : "));
        consumo.setConsumo_turno3(scannerValidation.validateDoubleScanner("Consumo do Turno 3 : "));
        // Retorna a entidade
        return consumo;
    }

    // Define em uma entidade, os dados necessários para sua criação. Recebe as chaves primárias da entidade
    public Producao createProducaoObject(Date reqDate, byte reqLinha_producao) {
        // Instancia a entidade
        Producao producao = new Producao();
        // Define os dados da entidade
        producao.setData_registro(reqDate);
        producao.setLinha_producao(reqLinha_producao);
        // Valida os tipos de dados retornados do usuário
        producao.setProducao_turno1(scannerValidation.validateDoubleScanner("Produção do Turno 1: "));
        producao.setProducao_turno2(scannerValidation.validateDoubleScanner("Produção do Turno 2: "));
        producao.setProducao_turno3(scannerValidation.validateDoubleScanner("Produção do Turno 3: "));
        // Retorna a entidade
        return producao;
    }

    // Define em uma entidade, os dados necessários para sua criação. Recebe as chaves primárias da entidade
    public ObjetivoConsumoMax createObjetivoConsumoMaxObject(Date reqDate, byte reqLinha_producao) {
        // Instancia a entidade
        ObjetivoConsumoMax objetivoConsumoMax = new ObjetivoConsumoMax();
        // Define os dados da entidade
        objetivoConsumoMax.setData_registro(reqDate);
        objetivoConsumoMax.setLinha_producao(reqLinha_producao);
        // Valida os tipos de dados retornados do usuário
        objetivoConsumoMax.setObjetivo1(scannerValidation.validateDoubleScanner("Objetivo Turno 1 : "));
        objetivoConsumoMax.setObjetivo2(scannerValidation.validateDoubleScanner("Objetivo Turno 2 : "));
        objetivoConsumoMax.setObjetivo3(scannerValidation.validateDoubleScanner("Objetivo Turno 3 : "));
        // Retorna a entidade
        return objetivoConsumoMax;
    }

}
