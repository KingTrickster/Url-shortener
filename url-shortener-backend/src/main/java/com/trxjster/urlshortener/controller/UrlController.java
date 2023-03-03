package com.trxjster.urlshortener.controller;

import com.trxjster.urlshortener.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @AllArgsConstructor @RequestMapping("url/shortener")
public class UrlController {

    private UrlService urlService;

    @GetMapping("/{id}")
    public String getOriginUrl(@PathVariable String id){
        return urlService.getOriginlUrl(id);
    }

    @PostMapping
    public String generateShortUrl(@PathVariable String id){
        return urlService.getOriginlUrl(id);
    }

}
