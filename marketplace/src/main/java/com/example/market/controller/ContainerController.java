package com.example.market.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.exception.ContainerNotFoundException;
import com.example.market.model.Container;
import com.example.market.repo.ContainerRepository;
import com.example.market.repo.ImageRepository;
import com.example.market.repo.UserRepository;
import com.example.market.service.ContainerService;

@RestController
@RequestMapping("/container")
public class ContainerController {

	@Autowired
	private ContainerRepository containerRepository;
	private UserRepository userRepository;
	private ImageRepository imageRepository;
	@Autowired
	private ContainerService containerService;

	
	@GetMapping("/container/{imageId}")
	public String one(@PathVariable String imageId) {
		String port = null;
		String[] lines = { "docker run --name demo -d -P " + imageId };
		String[] lines2 = {
				"docker inspect --format '{{ (index (index .NetworkSettings.Ports \"80/tcp\") 0).HostPort }}' demo" };

		try {
			tt.executeCommands(lines);
			port = tt.executeCommands(lines2);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(port);
	}

	// create container
	@PostMapping("/add")
	public ResponseEntity<Container> addContainer(@RequestBody Container C) {

		containerService.addContainer(C);
		ResponseEntity<Container> cont = new ResponseEntity<Container>(C, HttpStatus.OK);
		return cont;

	}
	// get container

	@GetMapping("/all")
	public ResponseEntity<List<Container>> getAllContainers() {
		List<Container> containers = containerService.findAllContainers();
		return new ResponseEntity<>(containers, HttpStatus.OK);
	}

	@Autowired
	private TT tt;
	private int port;

	/*@GetMapping("/launch/{id}")
	public Container getContainerById(Long id) {

		String[] lines = { "docker run -d -P nginx" };
		String[] lines2 = {
				"docker inspect --format '{{ (index (index .NetworkSettings.Ports \"80/tcp\") 0).HostPort }}' bennani" };
		try {
			tt.executeCommands(lines);
			port = tt.executeCommand(lines2);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		Container container = containerRepository.findById(id).orElseThrow(() -> new ContainerNotFoundException(id));
		containerRepository.save(container);
		return container;

		// set container attributes
		/*
		 * Container container= new Container();
		 * 
		 * container.setPort(8080); Optional<User> user= userRepository.findById((long)
		 * 1); container.setUser(user); Image image =
		 * imageRepository.findByName("store"); container.setImage(image);
		 * containerRepository.save(container); return container;
		 */

	}

	/*
	 * public URL parseUrl(String s) throws Exception { URL u = new URL(s); return
	 * new URI( u.getProtocol(), u.getAuthority(), u.getPath(), u.getQuery(),
	 * u.getRef()). toURL(); }
	 */


