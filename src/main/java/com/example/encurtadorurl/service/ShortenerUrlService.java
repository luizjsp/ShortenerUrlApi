package com.example.encurtadorurl.service;

import com.example.encurtadorurl.exception.ResourceNotFoundException;
import com.example.encurtadorurl.model.ShortenerUrl;
import com.example.encurtadorurl.repository.ShortenerUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShortenerUrlService {

    @Autowired
    private ShortenerUrlRepository shortenerUrlRepository;

    public ShortenerUrl saveUrl(String originalUrl, String shortUrl) {
        ShortenerUrl url = new ShortenerUrl();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setCreationDate(LocalDateTime.now());
        url.setAccessCount(0);
        return shortenerUrlRepository.save(url);
    }
    public ShortenerUrl getUrlByShortUrl(String shortUrl) {
        ShortenerUrl url = shortenerUrlRepository.findByShortUrl(shortUrl);

        if (url == null) {
            throw new ResourceNotFoundException("URL with shortUrl " + shortUrl + " not found");
        }
        return shortenerUrlRepository.findByShortUrl(shortUrl);
    }
    public void incrementAccessCount(ShortenerUrl url) {
        url.setAccessCount(url.getAccessCount() + 1);
        shortenerUrlRepository.save(url);
    }
    public List<ShortenerUrl> findAllUrls() {
        return shortenerUrlRepository.findAll();
    }
}