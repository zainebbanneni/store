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
	private String imageName;
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
	
	public String getImageName() {
		return imageName;
	}
	public void setImageUrl(String imageName) {
		this.imageName = imageName;
	}
	
	public Project(long id, String name, String description, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageName = imageName;
	}

	public Project(String name, String description, String imageName) {
		super();
		this.name = name;
		this.description = description;
		this.imageName = imageName;
	}
	public Project() {
		
	}
 
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", imageName=" + imageName + "]";
	}

	

}
