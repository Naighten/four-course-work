package org.example.courseWork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   private UserDetailsService userService;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf()
              .disable()
              .authorizeRequests()
//                .antMatchers("/drivers/**").hasRole("ADMIN")
              .antMatchers("/users/**").permitAll()
//                .anyRequest().authenticated()
              .anyRequest().permitAll()
              .and()
              .httpBasic()
              .and()
              .formLogin()
              .and()
              .logout();
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
              .userDetailsService(userService)
              .passwordEncoder(passwordEncoder());
   }
}
