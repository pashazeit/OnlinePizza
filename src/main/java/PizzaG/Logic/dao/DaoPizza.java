package PizzaG.Logic.dao;

import PizzaG.Logic.model.Pizza;
import java.util.List;

/**
 * Created by Zeit on 03.01.2017.
 */
public interface DaoPizza {

    public void addPizza(Pizza pizza);

    public void updPizza(Pizza pizza);

    public void delPizza(int id);

    public Pizza getPizzaId(int id);

    public List<Pizza> listPizza();
}
