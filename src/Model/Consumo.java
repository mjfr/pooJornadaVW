package Model;

import java.sql.Date;

public class Consumo {
    private Date data_registro;
    private byte linha_producao;
    private double consumo_turno1;
    private double consumo_turno2;
    private double consumo_turno3;
    private double consumo_un_turno1;
    private double consumo_un_turno2;
    private double consumo_un_turno3;

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    public byte getLinha_producao() {
        return linha_producao;
    }

    public void setLinha_producao(byte linha_producao) {
        this.linha_producao = linha_producao;
    }

    public double getConsumo_turno1() {
        return consumo_turno1;
    }

    public void setConsumo_turno1(double consumo_turno1) {
        this.consumo_turno1 = consumo_turno1;
    }

    public double getConsumo_turno2() {
        return consumo_turno2;
    }

    public void setConsumo_turno2(double consumo_turno2) {
        this.consumo_turno2 = consumo_turno2;
    }

    public double getConsumo_turno3() {
        return consumo_turno3;
    }

    public void setConsumo_turno3(double consumo_turno3) {
        this.consumo_turno3 = consumo_turno3;
    }

    public double getConsumo_un_turno1() {
        return consumo_un_turno1;
    }

    public void setConsumo_un_turno1(double consumo_un_turno1) {
        this.consumo_un_turno1 = consumo_un_turno1;
    }

    public double getConsumo_un_turno2() {
        return consumo_un_turno2;
    }

    public void setConsumo_un_turno2(double consumo_un_turno2) {
        this.consumo_un_turno2 = consumo_un_turno2;
    }

    public double getConsumo_un_turno3() {
        return consumo_un_turno3;
    }

    public void setConsumo_un_turno3(double consumo_un_turno3) {
        this.consumo_un_turno3 = consumo_un_turno3;
    }

    @Override
    public String toString() {
        return "Consumo{" +
                "data_registro=" + data_registro +
                ", linha_producao=" + linha_producao +
                ", consumo_turno1=" + consumo_turno1 +
                ", consumo_turno2=" + consumo_turno2 +
                ", consumo_turno3=" + consumo_turno3 +
                ", consumo_un_turno1=" + consumo_un_turno1 +
                ", consumo_un_turno2=" + consumo_un_turno2 +
                ", consumo_un_turno3=" + consumo_un_turno3 +
                '}';
    }
}
