package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.upc.toybox_backend.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    public User findUserByUsername(String username);
}
