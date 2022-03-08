package com.example.market.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Container {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int port;
	@ManyToOne
	private User user;
	@ManyToOne
	private Image image;

	public Container() {
	}

	public Container(String name) {
		super();
		this.name = name;
	}
	
	
	



	public Container(int id, String name, int port, User user, Image image) {
		super();
		this.id = id;
		this.name = name;
		this.port = port;
		this.user = user;
		this.image = image;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}




	public int getId() {
		return(int)id;
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
	


	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	

	@Override
	public String toString() {
		return "Container [id=" + id + ", name=" + name + ", port=" + port + ", user=" + user + ", image=" + image
				+ "]";
	}

	public void setUser(Optional<User> user2) {
		// TODO Auto-generated method stub
		
	}



	

}
