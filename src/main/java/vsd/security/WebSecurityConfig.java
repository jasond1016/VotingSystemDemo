package vsd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vsd.security.jwt.CustomAuthenticationProvider;
import vsd.security.jwt.JwtAuthenticationFilter;
import vsd.security.jwt.JwtLoginFilter;

/**
 * @author JasonW
 * @date 2020/8/15
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                // 指定路径下的资源需要验证了的用户才能访问
//                .antMatchers("/api/**").authenticated()
//                .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
                // 其他都放行了
                .anyRequest().authenticated()
                .and()
                //添加自定义Filter
                .addFilter(new JwtLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                // 不需要session（不创建会话）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
        // 授权异常处理
//                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
//                .accessDeniedHandler(new JwtAccessDeniedHandler());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(customUserDetailsServiceImpl, passwordEncoder()));
    }


}
