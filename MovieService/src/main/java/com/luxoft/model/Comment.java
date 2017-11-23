package com.luxoft.model;

/**
 * Modal Class
 *
 * @author Jitender Kumar
 */

public class Comment {
	
	private Long movieId;
	private String userName;
	private String message;
	
	public Comment(long movieId, String userName, String message) {
		this.movieId = movieId;
		this.userName = userName;
		this.message = message;
	}
	
	public Comment() {
		super();
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
    public String toString() {
        return "Comment{" + "movieId=" + movieId.toString() +  ", userName=" + userName +"message="+message+"}";
    }
	

}
