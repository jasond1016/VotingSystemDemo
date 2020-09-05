package vsd.repository;

import org.springframework.data.repository.CrudRepository;
import vsd.entity.User;

import java.util.Optional;

/**
 * @author JasonW
 * @date 2020/8/15
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
