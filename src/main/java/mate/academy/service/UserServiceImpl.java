package mate.academy.service;

import lombok.RequiredArgsConstructor;
import mate.academy.dto.UserRegistrationRequestDto;
import mate.academy.dto.UserResponseDto;
import mate.academy.exception.RegistrationException;
import mate.academy.mapper.UserMapper;
import mate.academy.model.User;
import mate.academy.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserResponseDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Can’t register user");
        }
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
