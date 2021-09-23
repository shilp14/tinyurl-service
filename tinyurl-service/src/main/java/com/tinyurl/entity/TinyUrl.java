package com.tinyurl.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tiny_url",indexes = {@Index(name="longurl_index",columnList ="longUrl")})
public class TinyUrl {
  @Id
  private String shortUrl;
  private String longUrl;
  private long userId;
  private Date createdAt;
  private Date modifiedAt;
}
