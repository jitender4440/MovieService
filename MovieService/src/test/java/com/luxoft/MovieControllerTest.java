package com.luxoft;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.luxoft.controller.MovieController;
import com.luxoft.model.Movie;
import com.luxoft.stub.MovieStub;

/**
 * Test Class
 *
 * @author Jitender Kumar
 */

public class MovieControllerTest {
	
	@InjectMocks
	private MovieController mc;

	@Mock
	private Movie movie;
	
	@Mock
	private MovieStub stub;

    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}	
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setId(5L);
		movie.setTitle("Chak De! India");
		movie.setDescription("Chak De! India is a 2007 Indian sports film, directed by Shimit Amin and Rob Miller");	
     }	

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetMovieById() {		
		assertEquals("status code is not as expected",HttpStatus.OK, mc.getMovieById(1L).getStatusCode());
		assertEquals("status code is not as expected",HttpStatus.NOT_FOUND, mc.getMovieById(9L).getStatusCode());
		assertEquals("title did not match","Sholay", mc.getMovieById(1L).getBody().getTitle());    
	}
	
	@Test
	public void testCreate() {
		assertEquals("status code is not as expected",HttpStatus.CREATED,  mc.create(movie).getStatusCode());		
		assertEquals("title did not match","Chak De! India", mc.create(movie).getBody().getTitle());    
		
		//Already existing movie case
		Movie movie_1 = new Movie();		
		movie_1.setId(1L);
		movie_1.setTitle("Sholay");
		movie_1.setDescription("Sholay (1975) Crisis of the Indian state in the 1970s");	
		assertEquals("status code is not as expected",HttpStatus.CONFLICT, mc.create(movie_1).getStatusCode());
	}

}
