package com.example.security.Service;

import com.example.security.Model.MyUser;
import com.example.security.Model.UserPrincipal;
import com.example.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    // this class is for spring security

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = userRepository.findByUsername(username);
        if (myUser == null) {
            // log user not found
            System.out.println(username + " not found");
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(myUser);
    }
}
