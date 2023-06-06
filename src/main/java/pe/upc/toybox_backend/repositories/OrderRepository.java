package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
