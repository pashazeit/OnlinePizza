package PizzaG.Logic.model;

import javax.persistence.*;

/**
 * Created by Zeit on 02.02.2017.
 * 14:50
 */
@Entity
@Table(name = "cartpizza")
public class CartPizza {

    public CartPizza() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cart_id")
    private String cartId;

    @Column(name = "pizza_id")
    private int pizzaId;

    @Column(name = "pizza_qty")
    private int pizzaQty;

    @Column(name = "order_summ")
    private int orderSumm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getPizzaQty() {
        return pizzaQty;
    }

    public void setPizzaQty(int pizzaQty) {
        this.pizzaQty = pizzaQty;
    }

     public int getOrderSumm() {
        return orderSumm;
    }

    public void setOrderSumm(int orderSumm) {
        this.orderSumm = orderSumm;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartId=" + cartId +
                ", pizzaId=" + pizzaId +
                ", pizzaQty=" + pizzaQty +
                ", orderSumm=" + orderSumm +
                '}';
    }
}
