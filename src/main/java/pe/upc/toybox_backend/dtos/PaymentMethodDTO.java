package pe.upc.toybox_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentMethodDTO {
    private Long id;
    private String card_holder;
    private int card_number;
    private int security_code;
    private LocalDate expiration_day;
    private String address;
}
