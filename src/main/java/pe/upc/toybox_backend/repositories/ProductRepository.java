package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.Product;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThanEqualAndPriceLessThanEqual(double minPrice, double maxPrice);
    List<Product> findByCategory_Id(Long id);
}
