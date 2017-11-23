package com.luxoft;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.luxoft.App;
import com.luxoft.model.Movie;
import com.luxoft.util.AppUtility;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test Class
 *
 * @author Jitender Kumar
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class MovieControllerWebIntegrationTest {
	@Test
	public void testGetMovieById() throws IOException {
		RestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<Movie> response = restTemplate.exchange("http://localhost:8080/api/v1/movie/2", HttpMethod.GET,
				new HttpEntity<Movie>(AppUtility.createHeaders("user", "user@123")), Movie.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
}
