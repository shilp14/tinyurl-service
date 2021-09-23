package com.tinyurl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tinyurl.dto.TinyUrlDto;
import com.tinyurl.entity.TinyUrl;
import com.tinyurl.repository.TinyUrlRepository;
import com.tinyurl.util.TinyUrlUtil;

@Service
public class TinyUrlServiceImpl implements TinyUrlService{

  @Autowired
  TinyUrlRepository tinyUrlRepo;
  @Autowired
  TinyUrlUtil util;
  
  @Override
  @Transactional
  public String createTinyUrl(TinyUrlDto tinyUrl) {
    String url=util.generateRandomShortUrl(tinyUrl.getLongUrl());
    TinyUrl tinyurlEntity=TinyUrl.builder().shortUrl(url).longUrl(tinyUrl.getLongUrl()).userId(tinyUrl.getUserId()).build();
    tinyUrlRepo.save(tinyurlEntity);
    return url;
  }

  @Override
  public String getLongUrl(String shortUrl) {
    return tinyUrlRepo.findById(shortUrl).get().getLongUrl();
  }

}
