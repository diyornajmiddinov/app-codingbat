package uz.pdp.codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String email;

    private String password;
}
