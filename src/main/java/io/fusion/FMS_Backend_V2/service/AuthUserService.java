package io.fusion.FMS_Backend_V2.service;

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
    private final StudentRepository studentRepository;

    public AuthUserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails students =  studentRepository.findByUsername(username);
        return new User(students.getUsername(), students.getPassword(), new ArrayList<>());
    }
}
