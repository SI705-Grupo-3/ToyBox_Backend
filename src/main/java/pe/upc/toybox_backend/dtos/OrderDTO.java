package pe.upc.toybox_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.upc.toybox_backend.entities.User;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
    private Long id;
    private LocalDate date;
    private String shipping_address;
    private String state;
    private double total_amount;
    private User user;
}
