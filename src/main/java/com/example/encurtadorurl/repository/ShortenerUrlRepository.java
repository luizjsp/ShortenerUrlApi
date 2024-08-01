package com.example.encurtadorurl.repository;

import com.example.encurtadorurl.model.ShortenerUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenerUrlRepository extends JpaRepository<ShortenerUrl, Long> {
    ShortenerUrl findByShortUrl(String shortUrl);
}