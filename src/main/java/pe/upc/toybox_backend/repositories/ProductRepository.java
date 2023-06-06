package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
