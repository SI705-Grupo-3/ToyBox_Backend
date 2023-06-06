package pe.upc.toybox_backend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String shipping_address;
    private String state;
    private double total_amount;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Order() {
    }

    public Order(Long id, LocalDate date, String shipping_address, String state, double total_amount, User user) {
        this.id = id;
        this.date = date;
        this.shipping_address = shipping_address;
        this.state = state;
        this.total_amount = total_amount;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", shipping_address='" + shipping_address + '\'' +
                ", state='" + state + '\'' +
                ", total_amount=" + total_amount +
                ", user=" + user +
                '}';
    }
}
