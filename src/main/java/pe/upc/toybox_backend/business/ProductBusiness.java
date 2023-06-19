package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.Product;
import pe.upc.toybox_backend.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductBusiness {
    @Autowired
    private ProductRepository productRepository;
    @Transactional //register
    public Product registerProduct(Product product) {
        return productRepository.save(product);
    }
    //list
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

}
