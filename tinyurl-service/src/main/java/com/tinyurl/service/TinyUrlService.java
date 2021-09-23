package com.tinyurl.service;

import org.springframework.stereotype.Service;

import com.tinyurl.dto.TinyUrlDto;

@Service
public interface TinyUrlService {

  String createTinyUrl(TinyUrlDto tinyUrl);
  String getLongUrl(String shortUrl);
  
  
}
