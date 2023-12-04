package mate.academy.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mate.academy.dto.UserRegistrationRequestDto;
import mate.academy.dto.UserResponseDto;
import mate.academy.exception.RegistrationException;
import mate.academy.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication management", description = "Endpoints for managing users")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    private UserService userService;

    @PostMapping("/registration")
    public UserResponseDto register(@RequestBody UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }
}
