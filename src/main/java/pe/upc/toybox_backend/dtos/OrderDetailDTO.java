package pe.upc.toybox_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.upc.toybox_backend.entities.Order;
import pe.upc.toybox_backend.entities.Product;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDTO {
    private Long id;
    private int quantity;
    private double amount;
    private Order order;
    private Product product;

}
