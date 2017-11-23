package com.luxoft.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.model.Comment;
import com.luxoft.model.Movie;
import com.luxoft.stub.CommentStub;
import com.luxoft.stub.MovieStub;
import com.luxoft.util.AppUtility;

/**
 * Comment Controller
 *
 * @author Jitender Kumar
 */


@RestController
@RequestMapping("api/v1/")
public class CommentController {
	
	@Cacheable("comments")
	@RequestMapping(value = "comment/{id}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getCommentByMovieId(@PathVariable Long id) {		
		  
		//AppUtility.delayExecution();	 //this statement can be enabled to delay execution for certain time to test cache functionality. 
		  
		  Comment comment = CommentStub.comments.get(id);
		  
		  if(comment == null)
			  return new ResponseEntity<Comment>(comment,HttpStatus.NOT_FOUND);
		  else
		  return new ResponseEntity<Comment>(comment,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "comment/create", method = RequestMethod.POST)
	public ResponseEntity<Comment> create(@RequestBody Comment comment) {
	    if(CommentStub.comments.containsKey(comment.getMovieId()))
			return new ResponseEntity<Comment>(comment,HttpStatus.CONFLICT);
		else
		{
			comment = CommentStub.comments.put(comment.getMovieId(),comment);		
			return new ResponseEntity<Comment>(comment,HttpStatus.CREATED);
		}
	}
}
