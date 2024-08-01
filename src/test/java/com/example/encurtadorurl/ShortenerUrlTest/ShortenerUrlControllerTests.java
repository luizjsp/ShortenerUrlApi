package com.example.encurtadorurl.ShortenerUrlTest;

import com.example.encurtadorurl.controller.ShortenerUrlController;
import com.example.encurtadorurl.model.ShortenerUrl;
import com.example.encurtadorurl.service.ShortenerUrlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShortenerUrlController.class)
public class ShortenerUrlControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ShortenerUrlService shortenerUrlService;

    @InjectMocks
    private ShortenerUrlController shortenerUrlController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCreateShortUrl() throws Exception {
        String originalUrl = "http://www.uol.com.br";
        String shortUrl = "abc123";
        ShortenerUrl url = new ShortenerUrl();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setAccessCount(0);

        when(shortenerUrlService.saveUrl(originalUrl, shortUrl)).thenReturn(url);

        mockMvc.perform(post("/api/v1/urls")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"originalUrl\": \"" + originalUrl + "\"}"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.shortUrl").value(shortUrl));
    }
    @Test
    public void testRedirectToOriginalUrl() throws Exception {
        String shortUrl = "abc123";
        String originalUrl = "http://www.uol.com.br";
        ShortenerUrl url = new ShortenerUrl();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setAccessCount(0);

        when(shortenerUrlService.getUrlByShortUrl(shortUrl)).thenReturn(url);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/urls/{shortUrl}", shortUrl))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.header().string("Location", originalUrl));
    }

}