package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "image")
	private List<Container>  containers;

	public Image() {
	}

	public Image(String name) {
		super();
		this.name = name;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
