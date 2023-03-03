package com.trxjster.urlshortener.repository;


import com.trxjster.urlshortener.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<URL, Long> {
    @Query(value = "select originalurl from Url where shorturl = ?1", nativeQuery = true)
    Optional<String> findByShortUrl(String id);
}
