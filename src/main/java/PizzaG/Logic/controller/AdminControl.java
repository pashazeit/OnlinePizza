package PizzaG.Logic.controller;

import PizzaG.Logic.model.OrderPizza;

import PizzaG.Logic.model.Pizza;
import PizzaG.Logic.service.ServPizz;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Zeit on 31.01.2017.
 * 15:51
 */
@Controller
@Transactional
public class AdminControl {

    private ServPizz servPizz;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    @Qualifier(value = "ServPizz")
    public void setServPizz(ServPizz servPizz) {
        this.servPizz = servPizz;
    }

    /*вход в админку*/
    @RequestMapping(value = "pizzaAdmin", method = RequestMethod.GET)
    public String listPizza(Model model, HttpSession session) {
        String check = "okay";

        if (check.equals(session.getAttribute("admin"))) {
            model.addAttribute("pizza", new Pizza());
            model.addAttribute("listPizza", this.servPizz.listPizza());

            return "WEB-INF/pages/adminka/pizzaAdmin";
        }

        return "redirect:/login";
    }

    /*добавить*/
    @RequestMapping(value = "/pizzaAdmin/add", method = RequestMethod.POST)
    public String addPizza(@ModelAttribute("pizza") Pizza pizza) {
        if (pizza.getId() == 0) {
            this.servPizz.addPizza(pizza);
        } else {
            this.servPizz.updPizza(pizza);
        }

        return "redirect:/pizzaAdmin";
    }

    /*удалить*/
    @RequestMapping("/remove/{id}")
    public String delPizza(@PathVariable("id") int id) {
        this.servPizz.delPizza(id);

        return "redirect:/pizzaAdmin";
    }

    /*редактирование*/
    @RequestMapping("edit/{id}")
    public String editPizza(@PathVariable("id") int id, Model model) {
        model.addAttribute("pizza", this.servPizz.getPizzaId(id));
        model.addAttribute("listPizza", this.servPizz.listPizza());

        return "WEB-INF/pages/adminka/pizzaAdmin";
    }

    /*инфо*/
    @RequestMapping("PizInfo/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("pizza", this.servPizz.getPizzaId(id));

        return "PizInfo";
    }

    /*страница OrderDate*/
    @RequestMapping(value = "orderDate", method = RequestMethod.GET)
    public String orderDate() {
        return "WEB-INF/pages/adminka/orderDate";
    }


    /*поиск по датам*/
    @RequestMapping("searchD")
    public ModelAndView getDetails(
            @RequestParam(value = "startD", required = false, defaultValue = "2017-01-17") String firstDate,
            @RequestParam(value = "endD", required = false, defaultValue = "2017-01-17") String lastDate) {

            List<OrderPizza> searchDate = null;
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT " +
                        "    ordertable.id_order," +
                        "    ordertable.date_pizz," +
                        "    ordertable.name_person," +
                        "    ordertable.number_tel," +
                        "    ordertable.address," +
                        "    sum(ordertable.price) as total " +
                        "FROM pizza.ordertable " +
                        "WHERE DATE_FORMAT(date_pizz, '%Y-%m-%d') BETWEEN :dateA AND :dateB " +
                        "group by ordertable.id_order " +
                        "order by ordertable.date_pizz desc ;");

        query.setParameter("dateA", firstDate);
        query.setParameter("dateB", lastDate);
        searchDate = query.list();

        return new ModelAndView("WEB-INF/pages/adminka/orderDate", "result", searchDate);
    }

    /*поиск по словам*/
    @RequestMapping("searchAll")
    public ModelAndView getAll(
            @RequestParam(value = "searchString", required = false, defaultValue = "") String param1) {


        List<OrderPizza> searchAll = null;
        param1 = "%" + param1.trim() + "%";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT " +
                        "    ordertable.id_order," +
                        "    ordertable.date_pizz," +
                        "    ordertable.name_person," +
                        "    ordertable.number_tel," +
                        "    ordertable.address," +
                        "    sum(ordertable.price) as total " +
                        "FROM pizza.ordertable " +
                        "WHERE " +
                        "ordertable.id_order like :searchQuery OR " +
                        "ordertable.date_pizz like :searchQuery OR " +
                        "ordertable.name_person like :searchQuery OR " +
                        "ordertable.number_tel like :searchQuery OR " +
                        "ordertable.address like :searchQuery " +
                        "group by ordertable.id_order " +
                        "order by ordertable.date_pizz desc ;");

        query.setParameter("searchQuery", param1);
        searchAll = query.list();

        return new ModelAndView("WEB-INF/pages/adminka/orderDate", "result", searchAll);
    }

    /*вывод информации по id заказа*/
    @RequestMapping(value = "orderInfo/{id}", method = RequestMethod.GET)
    public ModelAndView orderInfo(@PathVariable(value = "id") String id, HttpSession session) {
        List<OrderPizza> order = null;
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT * " +
                "FROM pizza.ordertable " +
                "where ordertable.id_order = :orderId ;");
        query.setParameter("orderId", id);
        order = query.list();

        return new ModelAndView("WEB-INF/pages/adminka/orderInfo", "result", order);
    }
}
