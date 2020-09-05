package vsd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vsd.entity.User;
import vsd.repository.UserRepository;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public void login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        log.debug("logger /api/login");
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(new User());
    }

}
