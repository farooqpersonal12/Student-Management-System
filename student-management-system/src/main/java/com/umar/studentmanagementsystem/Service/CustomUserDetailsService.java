package com.umar.studentmanagementsystem.Service;

import com.umar.studentmanagementsystem.Models.User;
import com.umar.studentmanagementsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByuserName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities(authorities)
                .disabled(!user.isEnabled())
                .build();
    }
}