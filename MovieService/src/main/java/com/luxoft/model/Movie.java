package com.luxoft.model;

/**
 * Modal Class
 *
 * @author Jitender Kumar
 */
public class Movie {

	private Long id;
	private String title;
	private String description;
	private Comment comment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}	
	
	public Movie(Long id, String title, String description,Comment comment) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.comment = comment;
	}
	public Movie() {
		super();		
	}
	
	@Override
    public String toString() {
        return "Movie{" + "id=" + id.toString() +  ", title=" + title +"description="+description+"}";
    }
	
	public boolean equals(Object obj) {
	  if(obj instanceof Movie && id.equals(((Movie)obj).id))
		  return true;
	  else
		  return false;	
	}
}
