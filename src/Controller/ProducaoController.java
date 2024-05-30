package Controller;

import Dao.GenericDao;
import Model.Consumo;
import Model.Producao;

public class ProducaoController extends AbstractController<Producao> {
    private final ConsumoController consumoController;

    public ProducaoController(GenericDao<Producao> dao, ConsumoController consumoController) {
        super(dao);
        this.consumoController = consumoController;
    }

    @Override
    public void create(Producao entity) {
        super.create(entity);
        Consumo consumo = consumoController.read(entity.getData_registro(), entity.getLinha_producao());
        consumo.setConsumo_un_turno1(consumo.getConsumo_turno1() / entity.getProducao_turno1());
        consumo.setConsumo_un_turno2(consumo.getConsumo_turno2() / entity.getProducao_turno2());
        consumo.setConsumo_un_turno3(consumo.getConsumo_turno3() / entity.getProducao_turno3());
        consumoController.update(consumo);
    }
}
