package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.User;

public interface UserRepository  extends JpaRepository<User, Long> {

}
