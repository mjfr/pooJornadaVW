package Model;

import java.sql.Date;

public class Producao {
    private Date data_registro;
    private byte linha_producao;
    private double producao_turno1;
    private double producao_turno2;
    private double producao_turno3;

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

    public double getProducao_turno1() {
        return producao_turno1;
    }

    public void setProducao_turno1(double producao_turno1) {
        this.producao_turno1 = producao_turno1;
    }

    public double getProducao_turno2() {
        return producao_turno2;
    }

    public void setProducao_turno2(double producao_turno2) {
        this.producao_turno2 = producao_turno2;
    }

    public double getProducao_turno3() {
        return producao_turno3;
    }

    public void setProducao_turno3(double producao_turno3) {
        this.producao_turno3 = producao_turno3;
    }

    @Override
    public String toString() {
        return "Producao{" +
                "data_registro=" + data_registro +
                ", linha_producao=" + linha_producao +
                ", producao_turno1=" + producao_turno1 +
                ", producao_turno2=" + producao_turno2 +
                ", producao_turno3=" + producao_turno3 +
                '}';
    }
}
