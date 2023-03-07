package com.trxjster.urlshortenerbackend.Service;

import com.trxjster.urlshortenerbackend.Model.Url;
import com.trxjster.urlshortenerbackend.Repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.trxjster.urlshortenerbackend.Common.GenerateShortUrl.getShortUrl;
import static com.trxjster.urlshortenerbackend.Common.GenerateShortUrl.isUrlValid;

@Service @AllArgsConstructor
public class UrlService {

    private UrlRepository urlRepository;

    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id).orElseThrow(() -> new RuntimeException("Url with specified id: "+id + " does not exist."));
    }

    public Url generateShortUrl(String url) {
        if(! isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalURL(url);
        urlObject.setShortURL(getShortUrl(url));

        return urlRepository.save(urlObject);
    }
}
