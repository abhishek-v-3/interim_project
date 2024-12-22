package com.cts.ClinicManagement.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.entity.User;
import com.cts.ClinicManagement.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String emailOrPhoneNumber) throws UsernameNotFoundException {
    
        // loading user from database
        User user= userRepository.findByEmailOrPhoneNumber(emailOrPhoneNumber,emailOrPhoneNumber)
        .orElseThrow(()->
         new UsernameNotFoundException("User not found with email / phone number : "+emailOrPhoneNumber));
        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

}
