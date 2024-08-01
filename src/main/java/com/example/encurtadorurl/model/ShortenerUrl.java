package com.example.encurtadorurl.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ShortenerUrl")
public class ShortenerUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime creationDate;
    private int accessCount;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getShortUrl() {
        return shortUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public int getAccessCount() {
        return accessCount;
    }
    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }
}