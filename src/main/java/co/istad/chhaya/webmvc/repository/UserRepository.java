package co.istad.chhaya.webmvc.repository;

import co.istad.chhaya.webmvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // SELECT * FROM users WHERE username = username;
    Optional<User> findByUsername(String username);

}
