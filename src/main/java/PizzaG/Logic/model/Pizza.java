package PizzaG.Logic.model;

/**
 * Created by Zeit on 03.01.2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "pzz")
public class Pizza implements java.io.Serializable{

  public Pizza() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String namePizza;

    @Column(name = "titl")
    private String titlPizza;

    @Column(name = "price")
    private int pricePizza;

    @Column(name = "url")
    private String urlPizza;


    @Column(name = "picpiz")
    private String picPizza;


    public String getPicPizza() {
        return picPizza;
    }

    public void setPicPizza(String picPizza) {
        this.picPizza = picPizza;
    }

    public String getUrlPizza() {
        return urlPizza;
    }

    public void setUrlPizza(String urlPizza) {
        this.urlPizza = urlPizza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public String getTitlPizza() {
        return titlPizza;
    }

    public void setTitlPizza(String titlPizza) {
        this.titlPizza = titlPizza;
    }

    public int getPricePizza() {
        return pricePizza;
    }

    public void setPricePizza(int pricePizza) {
        this.pricePizza = pricePizza;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", namePizza='" + namePizza + '\'' +
                ", titlPizza='" + titlPizza + '\'' +
                ", pricePizza=" + pricePizza +
                ", urlPizza='" + urlPizza + '\'' +
                ", picPizza='" + picPizza + '\'' +
                '}';
    }
}
