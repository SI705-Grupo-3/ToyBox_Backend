package pe.upc.toybox_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.upc.toybox_backend.entities.Product;
import pe.upc.toybox_backend.entities.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegistrationDTO {
    private Long id;
    private User user;
    private Product product;

}
