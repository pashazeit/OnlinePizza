package PizzaG.Logic.controller;

import PizzaG.Logic.model.CartPizza;
import PizzaG.Logic.service.ServOrder;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Zeit on 13.01.2017.
 * 13:07
 */
@Controller
@Transactional
public class OrderControl {

    private ServOrder servOrder;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    @Qualifier(value = "ServOrder")
    public void setServOrder(ServOrder servOrder) {
        this.servOrder = servOrder;
    }

    @RequestMapping(value = "CheckOut", method = RequestMethod.GET)
    public String CheckOut(HttpSession session) {

        //сумма товаров в корзине
        List<CartPizza> cartSumm = null;
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT sum(cartpizza.order_summ) as total " +
                        "FROM pizza.cartpizza " +
                        "WHERE cartpizza.cart_id = :CartId ");
        query.setParameter("CartId", session.getId());
        cartSumm = query.list();

        session.setAttribute("cart", cartSumm);

        return "WEB-INF/pages/cart/CheckOut";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(HttpServletRequest request, HttpSession session) {

        List<CartPizza> searchCart = sessionFactory.getCurrentSession().createQuery("From CartPizza WHERE cartId = :CartId ").setParameter("CartId", session.getId()).list();

        if (searchCart != null && !searchCart.isEmpty()) {

            Date date = new Date();
            int result = 0;

            for (CartPizza cart : searchCart) {
                SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
                        "INSERT INTO pizza.ordertable " +
                                "(id_order, name_person, number_tel, address, date_pizz, name_pizz, pizza_qty, price) " +
                                "VALUES " +
                                "( :cartId , :nameP , :numberP , :addressP , :orderDate , " +
                                "(SELECT name FROM pizza.pzz WHERE id = :pizzaId), " +
                                "(SELECT pizza_qty FROM pizza.cartpizza WHERE pizza.cartpizza.cart_id = :cartId AND pizza.cartpizza.pizza_id = :pizzaId ), " +
                                "(SELECT order_summ FROM pizza.cartpizza WHERE pizza.cartpizza.cart_id = :cartId AND pizza.cartpizza.pizza_id = :pizzaId ));");
                query.setParameter("nameP", request.getParameter("nameP"));
                query.setParameter("numberP", request.getParameter("numberP"));
                query.setParameter("addressP", request.getParameter("addressP"));
                query.setParameter("orderDate", date);
                query.setParameter("cartId", session.getId());
                query.setParameter("pizzaId", cart.getPizzaId());
                result = query.executeUpdate();
            }

           /*очистить корзину*/
            if (result > 0) {

                Query clearCart = sessionFactory.getCurrentSession()
                        .createQuery("DELETE FROM CartPizza " +
                                "WHERE cartId = :cartId ");
                clearCart.setParameter("cartId", session.getId());
                clearCart.executeUpdate();


                session.invalidate();
                HttpSession newSession = request.getSession(true);
            }

            return "WEB-INF/pages/cart/end";

        } else

        {
            request.setAttribute("warning", "<h1>В корзине нет товара, вернитесь на главную страницу</h1>");
        }
        return "WEB-INF/pages/cart/CheckOut";
    }

    /*корзина*/
    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public ModelAndView cart(HttpSession session) {

        List<CartPizza> searchCart = null;
        System.out.println(session.getId());
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT cartpizza.cart_id," +
                " cartpizza.pizza_id," +
                " cartpizza.pizza_qty," +
                " cartpizza.order_summ," +
                " pzz.id," +
                " pzz.name," +
                " pzz.url," +
                " pzz.titl " +
                "FROM pizza.pzz " +
                "inner join pizza.cartpizza " +
                "where cartpizza.pizza_id = pzz.id and cartpizza.cart_id = :CartId ");

        query.setParameter("CartId", session.getId());
        searchCart = query.list();

        return new ModelAndView("cart", "result", searchCart);

    }

}