package com.tinyurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tinyurl.dto.LoginResult;
import com.tinyurl.service.TokenService;

@RestController
public class AuthController {

  private final UserDetailsService userDetailsService;
  
  @Autowired
  private TokenService tokenService;
  
  public AuthController(UserDetailsService userDetailsService) {
      this.userDetailsService = userDetailsService;
  }
  
  @PostMapping(path = "login", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public LoginResult login(
          @RequestParam String username,
          @RequestParam String password) {
      
      UserDetails userDetails;
      try {
          userDetails = userDetailsService.loadUserByUsername(username);
      } catch (UsernameNotFoundException e) {
          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
      }
      
     return tokenService.generateToken(userDetails, username, password);
      
  }
  
  @GetMapping("/validate")
  public String validate() {
    
    return "Hi Shilpi";
  }
  
}
