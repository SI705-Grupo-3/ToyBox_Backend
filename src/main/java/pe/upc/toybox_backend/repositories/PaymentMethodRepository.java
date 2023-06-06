package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

}
