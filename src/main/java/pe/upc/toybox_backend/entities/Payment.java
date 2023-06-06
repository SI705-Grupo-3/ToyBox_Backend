package pe.upc.toybox_backend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double total;
    private LocalDate date;
    @OneToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @OneToOne(targetEntity = PaymentMethod.class)
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    private PaymentMethod paymentMethod;

    public Payment() {
    }

    public Payment(Long id, double total, LocalDate date, Order order, PaymentMethod paymentMethod) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", total=" + total +
                ", date=" + date +
                ", order=" + order +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
