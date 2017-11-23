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

import com.luxoft.controller.CommentController;
import com.luxoft.model.Comment;
import com.luxoft.stub.CommentStub;

/**
 * Test Class
 *
 * @author Jitender Kumar
 */

public class CommentControllerTest {
	
	@InjectMocks
	private CommentController cc;

	@Mock
	private Comment comment;
	
	@Mock
	private CommentStub stub;

    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}	
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        comment = new Comment();
        comment.setMovieId(9L);
		comment.setMessage("average");
		comment.setUserName("mohan");
     }	

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCommentById() {
		assertEquals("status code is not as expected",HttpStatus.NOT_FOUND, cc.getCommentByMovieId(4L).getStatusCode());   
		assertEquals("status code is not as expected",HttpStatus.OK, cc.getCommentByMovieId(1L).getStatusCode());   
		assertEquals("comment message not match","good", cc.getCommentByMovieId(1L).getBody().getMessage());   
	}
	
	@Test
	public void testCreate() {		
		assertEquals("status code is not as expected",HttpStatus.CREATED,  cc.create(comment).getStatusCode());
		assertEquals("comment message did not match","average", cc.create(comment).getBody().getMessage());    
		
		
		 //Already existing comment case
		 Comment comment1 = new Comment();
		 comment1.setMovieId(1L);
		 comment1.setMessage("good");
		 comment1.setUserName("jitender");
		 assertEquals("status code is not as expected",HttpStatus.CONFLICT,  cc.create(comment1).getStatusCode());
	}

}
