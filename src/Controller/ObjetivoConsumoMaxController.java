package Controller;

import Dao.GenericDao;
import Model.Consumo;
import Model.ObjetivoConsumoMax;

public class ObjetivoConsumoMaxController extends AbstractController<ObjetivoConsumoMax>{
    private final ConsumoController consumoController;

    public ObjetivoConsumoMaxController(GenericDao<ObjetivoConsumoMax> dao, ConsumoController consumoController) {
        super(dao);
        this.consumoController = consumoController;
    }

    @Override
    public void create(ObjetivoConsumoMax entity) {
        Consumo consumo = consumoController.read(entity.getData_registro(), entity.getLinha_producao());
        double calc1 = consumo.getConsumo_un_turno1() - entity.getObjetivo1();
        double calc2 = consumo.getConsumo_un_turno2() - entity.getObjetivo2();
        double calc3 = consumo.getConsumo_un_turno3() - entity.getObjetivo3();
        entity.setDesperdicio_turno1(calc1 < 0 ? 0 : calc1);
        entity.setDesperdicio_turno2(calc2 < 0 ? 0 : calc2);
        entity.setDesperdicio_turno3(calc3 < 0 ? 0 : calc3);
        super.create(entity);

    }
}
