package PizzaG.Logic.service;

import PizzaG.Logic.model.OrderPizza;
import java.util.List;

/**
 * Created by Zeit on 13.01.2017.
 * 12:51
 */
public interface ServOrder {

    public void addOrderPizza(OrderPizza orderPizza);

    public void updPizza (OrderPizza orderPizza);

    public OrderPizza getOrderId(int id);

    public List<OrderPizza> listOrder();

}
