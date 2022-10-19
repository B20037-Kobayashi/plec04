package personallec04.plec04.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Sample3AuthConfiguration {

  // user1, admin hoge
  @Bean
  public InMemoryUserDetailsManager userDetailsSercice() {

    UserBuilder users = User.builder();

    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$c4342PcRqsfdh9.DoVAgVufygQC42iunAE9/991pnJRWYKrHwv0nW")
        .roles("USER")
        .build();

    UserDetails admin = users
        .username("admin")
        .password("$2y$10$qTBYyew5.6dgIYrnivfdn.cbzBOGrMM2XrEf6lKTmWsALah7ZK0Wy")
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user1, admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();

    http.authorizeHttpRequests()

        .mvcMatchers("/sample4/**").authenticated();


    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
