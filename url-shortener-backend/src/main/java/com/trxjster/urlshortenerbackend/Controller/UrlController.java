package com.trxjster.urlshortenerbackend.Controller;

import com.trxjster.urlshortenerbackend.Model.Url;
import com.trxjster.urlshortenerbackend.Service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @AllArgsConstructor @RequestMapping("api/v1/url/shortener")
public class UrlController {

    private UrlService urlService;

    @GetMapping("/{id}")
    public String getOriginUrl(@PathVariable String id){
        return urlService.getOriginlUrl(id);
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url){
        return urlService.generateShortUrl(url);
    }

}