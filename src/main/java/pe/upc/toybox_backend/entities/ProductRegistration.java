package pe.upc.toybox_backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Product_Registrations")
public class ProductRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public ProductRegistration() {
    }

    public ProductRegistration(Long id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductRegistration{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
