package com.trxjster.urlshortenerbackend.Repository;

import com.trxjster.urlshortenerbackend.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query(value = "select originalurl from Url where shorturl = ?1", nativeQuery = true)
    Optional<String> findByShortUrl(String id);
}
