package com.example.market.model;

import java.util.Date;
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
	private String port;
	@ManyToOne
	private User user;
	@ManyToOne
	private Image image;
	private Date date;

	public Container() {
	}

	public Container(String name) {
		super();
		this.name = name;
	}

	public Container(String name, String port, User user, Image image) {
		super();
		this.date = new Date();
		this.name = name;
		this.port = port;
		this.user = user;
		this.image = image;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getId() {
		return (int) id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
