package mate.academy.service;

import mate.academy.dto.UserRegistrationRequestDto;
import mate.academy.dto.UserResponseDto;
import mate.academy.exception.RegistrationException;

public interface UserService {
    UserResponseDto findByEmail(String email);

    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;

}
