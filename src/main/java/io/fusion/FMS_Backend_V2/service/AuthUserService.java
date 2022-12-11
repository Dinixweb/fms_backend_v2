package io.fusion.FMS_Backend_V2.service;

import io.fusion.FMS_Backend_V2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthUserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    public AuthUserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userModel =  userRepository.findByEmail(email);
        return new User(userModel.getUsername(), userModel.getPassword(), new ArrayList<>());
    }
}
