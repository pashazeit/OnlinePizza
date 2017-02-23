package PizzaG.Logic.model;

/**
 * Created by Zeit on 07.01.2017.
 */
public class Items {

    private Pizza pizza=new  Pizza();

    private int quantity;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Items(Pizza pizza, int quantity) {
        super();
        this.pizza = pizza;
        this.quantity = quantity;
    }
}

