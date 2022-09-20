package com.urlshortnerExample.Url_shortnerExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortnerExample.Url_shortnerExample.model.Url;
import com.urlshortnerExample.Url_shortnerExample.service.ServiceForUrlShortner;

@RestController
@RequestMapping("url/shortner")
public class MainController {
	@Autowired

	private ServiceForUrlShortner serviceForUrlShortner;

	@GetMapping("/{id}")
	public String getOriginalUrl(@PathVariable String id) {
		
		return serviceForUrlShortner.getOriginalUrl(id);
	}
	
	@PostMapping
	public Url getShortUrl(@RequestBody String url) {
		return serviceForUrlShortner.getShortUrl(url);
	}

}
