package Controller;

import Dao.GenericDao;
import Model.Consumo;
import Model.Producao;

public class ProducaoController extends AbstractController<Producao> {
    private final ConsumoController consumoController;

    // Construtor para definir o DAO que está sendo utilizado e o controller relacionado a entidade de Consumo
    public ProducaoController(GenericDao<Producao> dao, ConsumoController consumoController) {
        super(dao);
        this.consumoController = consumoController;
    }

    // Personalizando o método padrão de create do controller abstrato para inserir os atributos calculados da entidade
    @Override
    public void create(Producao entity) {
        // Primeiramente cadastra a entidade de produção
        super.create(entity);
        // Cria um produto por uma busca de um produto já existente
        Consumo consumo = consumoController.read(entity.getData_registro(), entity.getLinha_producao());
        // Calcula os consumos unitários de cada turno
        consumo.setConsumo_un_turno1(consumo.getConsumo_turno1() / entity.getProducao_turno1());
        consumo.setConsumo_un_turno2(consumo.getConsumo_turno2() / entity.getProducao_turno2());
        consumo.setConsumo_un_turno3(consumo.getConsumo_turno3() / entity.getProducao_turno3());
        // Atualiza o consumo
        consumoController.update(consumo);
    }
}
