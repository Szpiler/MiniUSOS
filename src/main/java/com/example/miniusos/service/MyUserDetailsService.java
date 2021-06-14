package com.example.miniusos.service;

import com.example.miniusos.model.MyUserDetails;
import com.example.miniusos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.miniusos.model.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUserName(userName);

       user.orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono: " + userName));

       return user.map(MyUserDetails::new).get();
    }
}
