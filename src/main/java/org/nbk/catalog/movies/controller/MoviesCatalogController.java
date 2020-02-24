package org.nbk.catalog.movies.controller;

import org.nbk.catalog.movies.domain.Movie;
import org.nbk.catalog.movies.domain.MovieCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MoviesCatalogController {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesCatalogController.class);

    @Autowired
    private RestTemplate restTemplate;

    
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping(value = "api/v1/movie-catalog/catalogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieCatalog> getMovieCatalog() {

	
	LOGGER.info("getting movie catalog");
	
	Movie movie = restTemplate.getForObject("http://movies-api/api/v1/movies", Movie.class);
	//Movie movie = new Movie();
	movie.setMovieName("3 idiots");
	MovieCatalog catalog = new MovieCatalog();
	catalog.setMovie(movie);
	return ResponseEntity.ok(catalog);
    }
    
    public ResponseEntity<MovieCatalog> fallback(Throwable hystrixCommand){
	return new ResponseEntity<>(new MovieCatalog(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
