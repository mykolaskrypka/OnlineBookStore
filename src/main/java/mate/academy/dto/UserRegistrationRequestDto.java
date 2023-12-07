package mate.academy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import mate.academy.validation.FieldMatch;

@Data
@FieldMatch(first = "password", second = "repeatPassword",
        message = "The password fields must match")
public class UserRegistrationRequestDto {
    @NotNull
    private String email;
    @NotNull
    @Size(min = 6, max = 20)
    private String password;
    @NotNull
    private String repeatPassword;

}
