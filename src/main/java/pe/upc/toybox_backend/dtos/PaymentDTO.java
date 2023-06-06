package pe.upc.toybox_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.upc.toybox_backend.entities.Order;
import pe.upc.toybox_backend.entities.PaymentMethod;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private Long id;
    private double total;
    private LocalDate date;
    private Order order;
    private PaymentMethod paymentMethod;
}
