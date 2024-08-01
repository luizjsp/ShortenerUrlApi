package com.example.encurtadorurl.controller;

import com.example.encurtadorurl.dto.URLRequestDTO;
import com.example.encurtadorurl.dto.URLResponseDTO;
import com.example.encurtadorurl.model.ShortenerUrl;
import com.example.encurtadorurl.service.ShortenerUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/urls")
public class ShortenerUrlController {

    @Autowired
    private ShortenerUrlService shortenerUrlService;

//    @PostMapping
//    public ResponseEntity<Map<String, String>> createShortUrl(@RequestBody Map<String, String> request) {
//        String originalUrl = request.get("originalUrl");
//        String shortUrl = UUID.randomUUID().toString().substring(0, 6);
//        shortenerUrlService.saveUrl(originalUrl, shortUrl);
//        Map<String, String> response = new HashMap<>();
//        response.put("originalUrl", originalUrl);
//        response.put("shortUrl", shortUrl);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<URLResponseDTO> createShortUrl(@RequestBody URLRequestDTO request) {
        String originalUrl = request.getOriginalUrl();
        String shortUrl = UUID.randomUUID().toString().substring(0, 6);
        ShortenerUrl savedUrl = shortenerUrlService.saveUrl(originalUrl, shortUrl);

        URLResponseDTO response = new URLResponseDTO();
        response.setOriginalUrl(savedUrl.getOriginalUrl());
        response.setShortUrl(savedUrl.getShortUrl());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl) {
        ShortenerUrl url = shortenerUrlService.getUrlByShortUrl(shortUrl);
        if (url != null) {
            shortenerUrlService.incrementAccessCount(url);
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", url.getOriginalUrl()).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/stats")
    public ResponseEntity<List<ShortenerUrl>> getUrlStatistics() {
        List<ShortenerUrl> urls = shortenerUrlService.findAllUrls();
        return ResponseEntity.ok(urls);
    }
}
