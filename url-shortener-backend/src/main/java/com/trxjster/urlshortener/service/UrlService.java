package com.trxjster.urlshortener.service;

import com.trxjster.urlshortener.model.URL;
import com.trxjster.urlshortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.trxjster.urlshortener.common.GenerateShortUrl.getShortUrl;
import static com.trxjster.urlshortener.common.GenerateShortUrl.isUrlValid;

@Service @AllArgsConstructor
public class UrlService {
    private UrlRepository urlRepository;


    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id).orElseThrow(() -> new RuntimeException("Url with specified id: "+id + " does not exist."));
    }

    public URL generateShortUrl(String url) {
        if(! isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        URL urlObject = new URL();
        urlObject.setOriginalURL(url);
        urlObject.setShortURL(getShortUrl(url));

        return urlRepository.save(urlObject);
    }
}