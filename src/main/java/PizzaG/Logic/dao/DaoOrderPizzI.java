package PizzaG.Logic.dao;

import PizzaG.Logic.model.OrderPizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Created by Zeit on 13.01.2017.
 * 11:51
 */
public class DaoOrderPizzI implements DaoOrderPizz {

    private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(DaoOrderPizzI.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrderPizza(OrderPizza orderPizza) {

        Session session = this.sessionFactory.getCurrentSession();

        session.persist(orderPizza);
        logger.info("order add" + orderPizza.toString());
    }

    @Override
    public void updPizza (OrderPizza orderPizza) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(orderPizza);
        logger.info("orderPizza upd " + orderPizza.toString());
    }

    @Override
    public OrderPizza getOrderId(int id) {

        Session session = this.sessionFactory.getCurrentSession();

        OrderPizza orderPizza = (OrderPizza) session.load(OrderPizza.class, new Integer(id));
        logger.info("get order ID" + orderPizza.toString());

        return orderPizza;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderPizza> listOrder() {
        Session session = this.sessionFactory.getCurrentSession();
        List<OrderPizza> ordrPzz = session.createQuery("from OrderPizza").list();

        for (OrderPizza orderPizza : ordrPzz) {
            logger.info(" list Order " + ordrPzz.toString());
        }
        return ordrPzz;
    }
}
