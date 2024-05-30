package ViewHelper;

import Model.Consumo;
import Model.ObjetivoConsumoMax;
import Model.Producao;

import java.sql.Date;

public class ObjectViewHelper {

    private final ScannerValidation scannerValidation = new ScannerValidation();

    public Consumo createConsumoObject(Date reqDate, byte reqLinha_producao) {
        Consumo consumo = new Consumo();
        consumo.setData_registro(reqDate);
        consumo.setLinha_producao(reqLinha_producao);
        consumo.setConsumo_turno1(scannerValidation.validateDoubleScanner("Consumo do Turno 1 : "));
        consumo.setConsumo_turno2(scannerValidation.validateDoubleScanner("Consumo do Turno 2 : "));
        consumo.setConsumo_turno3(scannerValidation.validateDoubleScanner("Consumo do Turno 3 : "));
//        consumo.setConsumo_un_turno1(scannerValidation.validateDoubleScanner("Consumo Unitário do Turno 1 : "));
//        consumo.setConsumo_un_turno2(scannerValidation.validateDoubleScanner("Consumo Unitário do Turno 2 : "));
//        consumo.setConsumo_un_turno3(scannerValidation.validateDoubleScanner("Consumo Unitário do Turno 3 : "));
        return consumo;
    }

    public Producao createProducaoObject(Date reqDate, byte reqLinha_producao) {
        Producao producao = new Producao();
        producao.setData_registro(reqDate);
        producao.setLinha_producao(reqLinha_producao);
        producao.setProducao_turno1(scannerValidation.validateDoubleScanner("Produção do Turno 1: "));
        producao.setProducao_turno2(scannerValidation.validateDoubleScanner("Produção do Turno 2: "));
        producao.setProducao_turno3(scannerValidation.validateDoubleScanner("Produção do Turno 3: "));
        return producao;
    }

    public ObjetivoConsumoMax createObjetivoConsumoMaxObject(Date reqDate, byte reqLinha_producao) {
        ObjetivoConsumoMax objetivoConsumoMax = new ObjetivoConsumoMax();
        objetivoConsumoMax.setData_registro(reqDate);
        objetivoConsumoMax.setLinha_producao(reqLinha_producao);
        objetivoConsumoMax.setObjetivo1(scannerValidation.validateDoubleScanner("Objetivo Turno 1 : "));
        objetivoConsumoMax.setObjetivo2(scannerValidation.validateDoubleScanner("Objetivo Turno 2 : "));
        objetivoConsumoMax.setObjetivo3(scannerValidation.validateDoubleScanner("Objetivo Turno 3 : "));
//        objetivoConsumoMax.setDesperdicio_turno1(scannerValidation.validateDoubleScanner("Desperdício Turno 1 : "));
//        objetivoConsumoMax.setDesperdicio_turno2(scannerValidation.validateDoubleScanner("Desperdício Turno 2 : "));
//        objetivoConsumoMax.setDesperdicio_turno3(scannerValidation.validateDoubleScanner("Desperdício Turno 3 : "));
        return objetivoConsumoMax;
    }

}
