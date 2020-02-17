package org.nbk.catalog.movies.controller;

import org.nbk.catalog.movies.domain.Movie;
import org.nbk.catalog.movies.domain.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoviesCatalogController {

	/*@Autowired
	private RestTemplate restTemplate;*/

	@GetMapping(value = "api/v1/movie-catalog/catalogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieCatalog> getMovieCatalog() {

		//Movie movie = restTemplate.getForObject("http://movies-api/api/v1/movies", Movie.class);
		Movie movie =new Movie();
		movie.setMovieName("3 idiots");
		MovieCatalog catalog = new MovieCatalog();
		catalog.setMovie(movie);
		return ResponseEntity.ok(catalog);

	}

}
