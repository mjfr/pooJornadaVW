package Controller;

import Dao.GenericDao;
import Model.Consumo;
import Model.ObjetivoConsumoMax;

public class ObjetivoConsumoMaxController extends AbstractController<ObjetivoConsumoMax>{
    private final ConsumoController consumoController;

    // Construtor para definir o DAO que está sendo utilizado e o controller relacionado a entidade de Consumo
    public ObjetivoConsumoMaxController(GenericDao<ObjetivoConsumoMax> dao, ConsumoController consumoController) {
        super(dao);
        this.consumoController = consumoController;
    }

    // Personalizando o método padrão de create do controller abstrato para inserir os atributos calculados da entidade
    @Override
    public void create(ObjetivoConsumoMax entity) {
        Consumo consumo = consumoController.read(entity.getData_registro(), entity.getLinha_producao());
        // Calcula o desperdício de cada turno
        double calc1 = consumo.getConsumo_un_turno1() - entity.getObjetivo1();
        double calc2 = consumo.getConsumo_un_turno2() - entity.getObjetivo2();
        double calc3 = consumo.getConsumo_un_turno3() - entity.getObjetivo3();
        // Se não houver desperdício significa que o consumo foi menor que o objetivo, logo, o valor padrão é zero, caso contrário, define o valor do desperdício
        entity.setDesperdicio_turno1(calc1 < 0 ? 0 : calc1);
        entity.setDesperdicio_turno2(calc2 < 0 ? 0 : calc2);
        entity.setDesperdicio_turno3(calc3 < 0 ? 0 : calc3);
        // Cria a entidade
        super.create(entity);

    }
}
