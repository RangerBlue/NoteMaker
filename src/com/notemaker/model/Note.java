package com.notemaker.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note {
	
	@Id @GeneratedValue
	private long id;
    private String title;
    private String content;
    private Date published;
    
    private String user_id;

    public Note() {
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPublished() {
		return published;
	}
	
	public String getPublishedString() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String newDate = df.format(getPublished());
		return newDate;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Note(String title, String content, Date published, String user_id) {
		super();
		this.title = title;
		this.content = content;
		this.published = published;
		this.user_id = user_id;
	}
	
	public Note(Long id, String title, String content, Date published, String user_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.published = published;
		this.user_id = user_id;
	}
	
	
    
    
}
