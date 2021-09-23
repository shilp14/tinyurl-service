package com.tinyurl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tinyurl.entity.TinyUrl;

@Repository
public interface TinyUrlRepository extends JpaRepository<TinyUrl,String> {

}
