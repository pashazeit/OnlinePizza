package PizzaG.Logic.dao;

import PizzaG.Logic.model.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Zeit on 03.01.2017.
 */
@Repository
public class DaoPizzaI implements DaoPizza {

    private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(DaoPizzaI.class);
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addPizza(Pizza pizza) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(pizza);
        logger.info("pizza add " + pizza.toString());
    }

    @Override
    public void updPizza(Pizza pizza) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(pizza);
       logger.info("pizza upd " + pizza.toString());
    }

    @Override
    public void delPizza(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pizza pizza = (Pizza) session.load(Pizza.class, new Integer(id));

        if (pizza != null) {
            session.delete(pizza);
        }
        logger.info("pizza del " + pizza.toString());
    }

    @Override
    public Pizza getPizzaId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pizza pizza = (Pizza) session.load(Pizza.class, new Integer(id));

        logger.info("pizz getID " + pizza.toString());

        return pizza;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pizza> listPizza() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Pizza> pizList = session.createQuery("from Pizza").list();

        for(Pizza pizza: pizList){
            logger.info("pizz list " + pizza);
        }

        return pizList;
    }
}
