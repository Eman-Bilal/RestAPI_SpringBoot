package com.example.RESTAPI_Application.Config;

import com.example.RESTAPI_Application.Entities.User;
import com.example.RESTAPI_Application.Repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
    User user = userRepository.findByUserDetail_Email(email)
        .orElseThrow(() -> new UsernameNotFoundException("No user with email: " + email));

    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUserDetail().getEmail())
        .password(user.getUserDetail().getPassword()) // must already be a BCrypt hash
        .roles(user.getRole().name())
        .build();
  }
}