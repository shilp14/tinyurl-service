package com.tinyurl.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.tinyurl.dto.LoginResult;
import com.tinyurl.security.JwtHelper;
import com.tinyurl.service.TokenService;

@Component
public class TokenServiceImpl implements TokenService {

  private final JwtHelper jwtHelper;
  private final PasswordEncoder passwordEncoder;
  
   public TokenServiceImpl(JwtHelper jwtHelper,PasswordEncoder passwordEncoder) {
    this.jwtHelper=jwtHelper;
    this.passwordEncoder=passwordEncoder;
  }
  
  @Override
  public LoginResult generateToken(UserDetails userDetails,String userName,String password) {
    
    if (passwordEncoder.matches(password, userDetails.getPassword())) {
      Map<String, String> claims = new HashMap<>();
      claims.put("username", userName);
      
      String authorities = userDetails.getAuthorities().stream()
              .map(GrantedAuthority::getAuthority)
              .collect(Collectors.joining(","));
      claims.put("authorities", authorities);
      claims.put("userId", String.valueOf(1));
      
      String jwt = jwtHelper.createJwtForClaims(userName, claims);
      return new LoginResult(jwt);
    
  }
    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
  
  }

  
}
