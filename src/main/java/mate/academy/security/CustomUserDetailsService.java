package mate.academy.security;

import lombok.RequiredArgsConstructor;
import mate.academy.model.User;
import mate.academy.repository.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmailFetchRoles(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user by email"));
        return (UserDetails) user;
    }
}
