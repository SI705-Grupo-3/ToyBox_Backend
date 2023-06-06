package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
