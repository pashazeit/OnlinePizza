package PizzaG.Logic.dao;

import PizzaG.Logic.model.OrderPizza;

import javax.persistence.criteria.Order;
import java.util.List;

/**
 * Created by Zeit on 13.01.2017.
 * 11:50
 */
public interface DaoOrderPizz {

    public void addOrderPizza(OrderPizza orderPizza);

    public void updPizza(OrderPizza orderPizza);

    public OrderPizza getOrderId(int id);

    public List<OrderPizza> listOrder();

}
