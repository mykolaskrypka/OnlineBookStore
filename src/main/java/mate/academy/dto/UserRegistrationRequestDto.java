package mate.academy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegistrationRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;

}
