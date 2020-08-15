package vsd.repository;

import org.springframework.data.repository.CrudRepository;
import vsd.entity.User;

/**
 * @author JasonW
 * @date 2020/8/15
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
}
