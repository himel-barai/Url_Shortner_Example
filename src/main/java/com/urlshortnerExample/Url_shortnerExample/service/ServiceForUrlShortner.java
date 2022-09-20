package com.urlshortnerExample.Url_shortnerExample.service;
import static  com.urlshortnerExample.Url_shortnerExample.logic.OriginalToShortUrl.isUrlValid;
import static  com.urlshortnerExample.Url_shortnerExample.logic.OriginalToShortUrl.generateShortUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshortnerExample.Url_shortnerExample.model.Url;
import com.urlshortnerExample.Url_shortnerExample.repository.UrlRepository;

@Service
public class ServiceForUrlShortner {

	@Autowired
	
	private UrlRepository urlRepository;
	
	public String getOriginalUrl(String id) {
		
		return urlRepository.findByShortUrl(id);
	}
	
	public Url getShortUrl(String url) {
		if(! isUrlValid(url)) {
			System.out.println("Url is not valid. Please enter a valid Url");
			return null;
		}
		 Url urlObject = new Url();
		 
		 urlObject.setOriginalUrl(url);
		 urlObject.setShortUrl(generateShortUrl(url));
		 
		 return urlRepository.save(urlObject);
		 
	}

	
}
