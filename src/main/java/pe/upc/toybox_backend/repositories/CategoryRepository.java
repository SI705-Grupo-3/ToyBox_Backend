package pe.upc.toybox_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.toybox_backend.entities.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
