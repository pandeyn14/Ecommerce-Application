package com.nisha.books.model.entity;

import java.io.Serializable;
import java.util.Date;

//import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="books")
public class BooksEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_created;
	private Boolean finished;
	
	public BooksEntity(){}
	
	public BooksEntity(String name, String description, Date date_created, Boolean finished) {
		super();
		this.name = name;
		this.description = description;
		this.date_created = date_created;
		this.finished = finished;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}


	@Override
	public String toString() {
		return "BooksEntity [id=" + id + ", name=" + name + ", description=" + description + ", date_created="
				+ date_created + ", finished=" + finished + "]";
	}
	
	
	

}
