package com.tinyurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tinyurl.dto.TinyUrlDto;
import com.tinyurl.service.TinyUrlService;

@RestController
public class TinyUrlController {
  
  @Autowired
  private TinyUrlService tinyUrlService;
  @PostMapping("/create")
  public String createShortUrl(@RequestBody TinyUrlDto urlDto) {
    
    return tinyUrlService.createTinyUrl(urlDto);
  }
  
  @GetMapping("/url")
  public String getLongUrl(@RequestBody String shortUrl) {
   
    return tinyUrlService.getLongUrl(shortUrl);
  }
  
  
  

}
