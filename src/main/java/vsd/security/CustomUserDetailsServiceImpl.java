package vsd.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import vsd.repository.UserRepository;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.debug("loadUserByUsername: " + s);
        if (StringUtils.isEmpty(s)) {
            log.debug("username is empty");
            throw new UsernameNotFoundException("username is empty");
        }
        vsd.entity.User user = userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("No such user"));
        return new User(user.getUsername(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
    }

}
