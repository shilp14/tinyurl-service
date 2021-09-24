package com.tinyurl.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.tinyurl.dto.LoginResult;

public interface TokenService {
  LoginResult generateToken(UserDetails userDetails,String userName,String password);
}
