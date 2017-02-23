package PizzaG.Logic.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zeit on 13.01.2017.
 * 11:36
 */
@Entity
@Table(name = "ordertable")
public class OrderPizza implements java.io.Serializable {

    public OrderPizza() { }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_person")
    private String namePerson;

    @Column(name = "number_tel")
    private String numbertel;

    @Column(name = "address")
    private String address;

    @Column(name = "name_pizz")
    private String namePizz;

    @Column(name = "price")
    private int price;

    @Column(name = "date_pizz")
    private Date datePizz;

    @Column(name = "id_order")
    private String orderId;

    @Column(name = "pizza_qty")
    private int pizzaQty;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePerson() { return namePerson;  }

    public void setNamePerson(String namePerson) {  this.namePerson = namePerson; }

    public String getNumbertel() { return numbertel; }

    public void setNumbertel(String numbertel) { this.numbertel = numbertel; }

    public String getNamePizz() {return namePizz; }

    public void setNamePizz(String namePizz) { this.namePizz = namePizz; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDatePizz() { return datePizz; }

    public void setDatePizz(Date datePizz) {this.datePizz = datePizz;}

    public String getOrderId() { return orderId; }

    public void setOrderId(String orderId) { this.orderId = orderId; }

    public int getPizzaQty() {return pizzaQty; }

    @Override
    public String toString() {
        return "OrderPizza{" +
                "id=" + id +
                ", namePerson='" + namePerson + '\'' +
                ", numbertel='" + numbertel + '\'' +
                ", address='" + address + '\'' +
                ", namePizz='" + namePizz + '\'' +
                ", price=" + price +
                ", datePizz=" + datePizz +
                ", orderId='" + orderId + '\'' +
                ", pizzaQty=" + pizzaQty +
                '}';
    }
}

