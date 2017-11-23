package com.luxoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.luxoft.model.Movie;
import com.luxoft.stub.MovieStub;
import com.luxoft.util.AppUtility;

/**
 * Movie Controller
 *
 * @author Jitender Kumar
 */

@RestController
@RequestMapping("api/v1/")
public class MovieController {
	
	@Autowired
	Movie movie;
	
	@Cacheable("movies")	
	@RequestMapping(value = "movie/{id}", method = RequestMethod.GET)
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {			
		//AppUtility.delayExecution();	//this statement can be enabled to delay execution for certain time to test cache functionality.
		
		movie = MovieStub.movies.get(id);
		
		if(movie == null)		
		return new ResponseEntity<Movie>(movie,HttpStatus.NOT_FOUND);
		
		else
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
	}	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "movie/create", method = RequestMethod.POST)
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		
		if(MovieStub.movies.containsKey(movie.getId()))
			return new ResponseEntity<Movie>(movie,HttpStatus.CONFLICT);
		else
		{
			movie = MovieStub.movies.put(movie.getId(),movie);		
			return new ResponseEntity<Movie>(movie,HttpStatus.CREATED);
		}
	}
	
	
}
