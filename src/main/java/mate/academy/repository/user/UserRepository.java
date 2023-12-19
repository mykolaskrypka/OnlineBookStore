package mate.academy.repository.user;

import java.util.Optional;
import mate.academy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT user FROM User user join fetch user.roles where user.email = :email")
    Optional<User> getByEmailFetchRoles(@Param("email") String email);

}
