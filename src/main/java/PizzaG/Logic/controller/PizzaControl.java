package PizzaG.Logic.controller;


import PizzaG.Logic.model.CartPizza;
import PizzaG.Logic.model.Items;
import PizzaG.Logic.model.OrderPizza;
import PizzaG.Logic.model.Pizza;
import PizzaG.Logic.service.ServOrder;
import PizzaG.Logic.service.ServPizz;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zeit on 03.01.2017.
 */
@Controller
@Transactional
public class PizzaControl {
    private ServPizz servPizz;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    @Qualifier(value = "ServPizz")
    public void setServPizz(ServPizz servPizz) {
        this.servPizz = servPizz;
    }

    /*главная*/
    @RequestMapping(value = "PizzaTest", method = RequestMethod.GET)
    public String listPizza1(Model model, HttpSession session) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("listPizza", this.servPizz.listPizza());

        //сумма товаров в корзине
        List<CartPizza> cartSumm = null;
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT sum(cartpizza.order_summ) as total " +
                "FROM pizza.cartpizza " +
                "WHERE cartpizza.cart_id = :CartId ");
        query.setParameter("CartId", session.getId());
        cartSumm = query.list();

        session.setAttribute("cart", cartSumm);

        return "/PizzaTest";
    }

    /*добавление товара в корзину*/
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/ordernow/{id}", method = RequestMethod.GET)
    public String ordernow(@PathVariable(value = "id") int id, Model model, HttpSession session) {

        List<CartPizza> searchPizza = null;
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM pizza.cartpizza WHERE cart_id = :CartId AND pizza_id = :PizzaId LIMIT 1;");
        sqlQuery.setParameter("CartId", session.getId());
        sqlQuery.setParameter("PizzaId", id);
        searchPizza = sqlQuery.list();

        if (searchPizza != null && !searchPizza.isEmpty()) {


            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("update pizza.cartpizza " +
                    "SET order_summ = order_summ + (order_summ/pizza_qty)," +
                    "pizza_qty = pizza_qty +1 " +
                    " where cart_id = :CartId AND  pizza_id = :pizzaId");

            query.setParameter("pizzaId", id);
            query.setParameter("CartId", session.getId());
            query.executeUpdate();


        } else {


            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO pizza.cartpizza (cart_id, pizza_id, pizza_qty, order_summ ) " +
                    "VALUES ( :CartId , :PizzaId , 1 , (SELECT pizza.pzz.price FROM pizza.pzz WHERE pizza.pzz.id = :PizzaId ))");
            query.setParameter("CartId", session.getId());
            query.setParameter("PizzaId", id);

            query.executeUpdate();

        }


        return "redirect:/PizzaTest";
    }

    /* удаление из корзины*/
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id, HttpSession session) {

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM pizza.cartpizza WHERE cart_id = :CartId AND pizza_id = :PizzaId ");
        query.setParameter("CartId", session.getId());
        query.setParameter("PizzaId", id);
        query.executeUpdate();

        return "redirect:/cart";
    }
}

