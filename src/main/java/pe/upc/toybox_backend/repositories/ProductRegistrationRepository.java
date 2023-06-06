package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.ProductRegistration;

public interface ProductRegistrationRepository extends JpaRepository<ProductRegistration, Long> {

}
