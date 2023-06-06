package pe.upc.toybox_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String type;
    private String name;
    private String last_name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String image;
}
