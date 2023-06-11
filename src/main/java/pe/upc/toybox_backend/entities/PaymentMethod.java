package pe.upc.toybox_backend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Payment_Methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String card_holder;
    private int card_number;
    private int security_code;
    private LocalDate expiration_day;
    private String address;

    public PaymentMethod() {
    }
    public PaymentMethod(Long id, String card_holder, int card_number, int security_code, LocalDate expiration_day, String address) {
        this.id = id;
        this.card_holder = card_holder;
        this.card_number = card_number;
        this.security_code = security_code;
        this.expiration_day = expiration_day;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public int getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(int security_code) {
        this.security_code = security_code;
    }

    public LocalDate getExpiration_day() {
        return expiration_day;
    }

    public void setExpiration_day(LocalDate expiration_day) {
        this.expiration_day = expiration_day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", card_holder='" + card_holder + '\'' +
                ", card_number=" + card_number +
                ", security_code=" + security_code +
                ", expiration_day=" + expiration_day +
                ", address='" + address + '\'' +
                '}';
    }
}
