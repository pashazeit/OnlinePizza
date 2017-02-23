package PizzaG.Logic.service;

import PizzaG.Logic.dao.DaoOrderPizz;
import PizzaG.Logic.model.OrderPizza;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Zeit on 13.01.2017.
 * 12:51
 */
public class ServOrderI implements ServOrder{

private DaoOrderPizz daoOrderPizz;

    public void setDaoOrderPizz(DaoOrderPizz daoOrderPizz) {
        this.daoOrderPizz = daoOrderPizz;
    }

    @Override
    @Transactional
    public void addOrderPizza(OrderPizza orderPizza) { this.daoOrderPizz.addOrderPizza(orderPizza); }

    @Override
    @Transactional
    public void updPizza(OrderPizza orderPizza) {
        this.daoOrderPizz.updPizza(orderPizza);
    }

    @Override
    @Transactional
    public OrderPizza getOrderId(int id) { return this.daoOrderPizz.getOrderId(id); }

    @Override
    @Transactional
    public List<OrderPizza> listOrder() {
        return this.daoOrderPizz.listOrder();
    }
}
