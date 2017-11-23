package com.luxoft.stub;

import java.util.HashMap;
import java.util.Map;
import com.luxoft.model.Comment;

/**
 * Stub Class
 *
 * @author Jitender Kumar
 */
public class CommentStub {
	
	public static Map<Long, Comment> comments = new HashMap<Long, Comment>();
	
	//populate initial movies
		static {
			comments.put(1L, new Comment(1L, "jitender","good"));
			comments.put(2L, new Comment(2L, "ankit","average"));
			comments.put(3L, new Comment(3L, "john","excellent"));			
		}
}
