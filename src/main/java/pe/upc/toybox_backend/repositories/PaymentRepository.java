package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
