 package com.example.market.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Project implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (nullable=false, updatable=false)
	private long id;
	private String name;
	private String description;
	private String imageUrl;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Project(long id, String name, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Project(String name, String description, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	public Project() {
		
	}
 
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl + "]";
	}

	

}
