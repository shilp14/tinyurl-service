package com.tinyurl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinyurl.entity.TinyUrl;
import com.tinyurl.repository.TinyUrlRepository;

@Component
public class TinyUrlUtilImpl implements TinyUrlUtil{

  @Autowired
  TinyUrlRepository tinyurlRepo;
  
  private static int SHORT_URL_CHAR_SIZE=7;
  public static String convert(String longURL) {
      try {
          // Create MD5 Hash
          MessageDigest digest = MessageDigest.getInstance("MD5");
          digest.update(longURL.getBytes());
          byte messageDigest[] = digest.digest();
          // Create Hex String
          StringBuilder hexString = new StringBuilder();
          for (byte b : messageDigest) {
              hexString.append(Integer.toHexString(0xFF & b));
          }
          return hexString.toString();
      } catch (NoSuchAlgorithmException e) {
          throw new RuntimeException(e);
      }
  }
  
  @Override
public  String generateRandomShortUrl(String longURL) {
      String hash=convert(longURL);
      int numberOfCharsInHash=hash.length();
      int counter=0;
      String shortUrl="";
      while(counter < numberOfCharsInHash-SHORT_URL_CHAR_SIZE){
        Optional<TinyUrl> url=tinyurlRepo.findById(hash.substring(counter, counter+SHORT_URL_CHAR_SIZE));
        if(!url.isPresent()){
              shortUrl=hash.substring(counter, counter+SHORT_URL_CHAR_SIZE);
              break;
          }
          counter++;
      }
      return shortUrl;
   }

}
