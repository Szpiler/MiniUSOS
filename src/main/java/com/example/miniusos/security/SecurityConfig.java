package com.example.miniusos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("myUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/list").hasAnyRole("ADMIN", "USER")
                .antMatchers("/ocenyAll").hasRole("ADMIN")
                .antMatchers("/oceny").hasAnyRole("ADMIN", "STAFF")
                .antMatchers("/wyniks").hasAnyRole("ADMIN","USER", "STAFF")
                .antMatchers("/wystaw").hasAnyRole("ADMIN", "STAFF")
                .antMatchers("/przedmiotsAll").hasRole("ADMIN")
                .antMatchers("/studentsAll").hasAnyRole("ADMIN", "STAFF")
                .antMatchers("/").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login.html")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();
    }

}
