package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.ProductRegistration;
import pe.upc.toybox_backend.repositories.ProductRegistrationRepository;

import java.util.List;

@Service
public class ProductRegistrationBusiness {
    @Autowired
    private ProductRegistrationRepository productRegistrationRepository;
    @Transactional //register
    public ProductRegistration registerProductRegistration(ProductRegistration productRegistration) {
        return productRegistrationRepository.save(productRegistration);
    }
    //list
    public List<ProductRegistration> listProductRegistration() {
        return productRegistrationRepository.findAll();
    }
    //list Category By ID
    public ProductRegistration listIdProductRegistration(Long id) throws Exception{
        ProductRegistration productRegistration = productRegistrationRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return productRegistration;
    }
}
