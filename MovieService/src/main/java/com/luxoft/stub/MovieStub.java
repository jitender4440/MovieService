package com.luxoft.stub;

import java.util.HashMap;
import java.util.Map;
import com.luxoft.model.Comment;
import com.luxoft.model.Movie;

/**
 * Stub Class
 *
 * @author Jitender Kumar
 */

public class MovieStub {
	
	public static Map<Long, Movie> movies = new HashMap<Long, Movie>();
	
	//populate initial movies
		static {
			movies.put(1L, new Movie(1L, "Sholay","Sholay (1975) Crisis of the Indian state in the 1970s",new Comment(1L, "jitender","good")));
			movies.put(2L, new Movie(2L, "Mr India","Mr. India is a 1987 Indian Hindi science fiction superhero film directed by Shekhar Kapur",new Comment(2L, "ankit","average")));
			movies.put(3L, new Movie(3L, "Barfi","Barfi! is a 2012 Indian comedy-drama film co-produced, written and directed by Anurag Basu",new Comment(3L, "john","excellent")));			
		}
}
