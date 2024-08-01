package com.example.encurtadorurl.dto;

import jakarta.validation.constraints.NotBlank;

public class URLRequestDTO {
    @NotBlank
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}