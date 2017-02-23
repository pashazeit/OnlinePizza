package PizzaG.Logic.service;

import PizzaG.Logic.dao.DaoPizza;
import PizzaG.Logic.model.Pizza;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Zeit on 03.01.2017.
 */
@Service
public class ServPizzI implements ServPizz {

    private DaoPizza daoPizza;

    public void setDaoPizza(DaoPizza daoPizza) {
        this.daoPizza = daoPizza;
    }

    @Override
    @Transactional
    public void addPizza(Pizza pizza) { this.daoPizza.addPizza(pizza); }

    @Override
    @Transactional
    public void updPizza(Pizza pizza) {
        this.daoPizza.updPizza(pizza);
    }

    @Override
    @Transactional
    public void delPizza(int id) {
        this.daoPizza.delPizza(id);
    }

    @Override
    @Transactional
    public Pizza getPizzaId(int id) {
        return this.daoPizza.getPizzaId(id);
    }

    @Override
    @Transactional
    public List<Pizza> listPizza() {
        return this.daoPizza.listPizza();
    }
}
