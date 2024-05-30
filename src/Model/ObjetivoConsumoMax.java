package Model;

import java.sql.Date;

public class ObjetivoConsumoMax {
    private Date data_registro;
    private byte linha_producao;
    private double objetivo1;
    private double objetivo2;
    private double objetivo3;
    private double desperdicio_turno1;
    private double desperdicio_turno2;
    private double desperdicio_turno3;

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

    public double getObjetivo1() {
        return objetivo1;
    }

    public void setObjetivo1(double objetivo1) {
        this.objetivo1 = objetivo1;
    }

    public double getObjetivo2() {
        return objetivo2;
    }

    public void setObjetivo2(double objetivo2) {
        this.objetivo2 = objetivo2;
    }

    public double getObjetivo3() {
        return objetivo3;
    }

    public void setObjetivo3(double objetivo3) {
        this.objetivo3 = objetivo3;
    }

    public double getDesperdicio_turno1() {
        return desperdicio_turno1;
    }

    public void setDesperdicio_turno1(double desperdicio_turno1) {
        this.desperdicio_turno1 = desperdicio_turno1;
    }

    public double getDesperdicio_turno2() {
        return desperdicio_turno2;
    }

    public void setDesperdicio_turno2(double desperdicio_turno2) {
        this.desperdicio_turno2 = desperdicio_turno2;
    }

    public double getDesperdicio_turno3() {
        return desperdicio_turno3;
    }

    public void setDesperdicio_turno3(double desperdicio_turno3) {
        this.desperdicio_turno3 = desperdicio_turno3;
    }

    @Override
    public String toString() {
        return "ObjeticoConsumoMax{" +
                "data_registro=" + data_registro +
                ", linha_producao=" + linha_producao +
                ", objetivo1=" + objetivo1 +
                ", objetivo2=" + objetivo2 +
                ", objetivo3=" + objetivo3 +
                ", desperdicio_turno1=" + desperdicio_turno1 +
                ", desperdicio_turno2=" + desperdicio_turno2 +
                ", desperdicio_turno3=" + desperdicio_turno3 +
                '}';
    }
}
