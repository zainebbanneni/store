package com.example.market.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.model.Container;
import com.example.market.model.Image;
import com.example.market.model.StoreRequest;
import com.example.market.model.User;
import com.example.market.repo.ContainerRepository;
import com.example.market.repo.ImageRepository;
import com.example.market.repo.UserRepository;
import com.example.market.service.ContainerService;
import com.example.market.service.UtilityService;

@Controller
@RestController
@RequestMapping("/container")
@CrossOrigin
public class ContainerController {

	@Autowired
	private UtilityService utilityService;
	private int port;

	@Autowired
	private ContainerRepository containerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ContainerService containerService;

	private String containerName;

	@PostMapping("/req")
	private String createContainer(@RequestBody StoreRequest storeRequest) {

		String port = null;
		String containerName = utilityService.generateRoandomNames();
		String[] lines = { "docker run --name " + containerName + " -d -P " + storeRequest.getImageName() };
		String[] lines3 = {
				"result=$( docker inspect --format \"{{ (index (index .NetworkSettings.Ports \\\"80/tcp\\\") 0).HostPort }}\" "
						+ containerName + " )\n" + "\n" + "echo  $result \n" + "" };

		try {
			utilityService.executeCommands(lines);
			port = utilityService.executeCommands(lines3);

		} catch (IOException e) {
			e.printStackTrace();
		}
		User val1 = new User();
		Image val2 = new Image();
		Container container = new Container(containerName, port, val1, val2);

		imageRepository.save(val2);
		userRepository.save(val1);
		containerRepository.save(container);
		
		return port;

		//return "http://localhost:" + port;
	}

	@DeleteMapping("/delete/{containerName}")
	public void stopContainer(@PathVariable String containerName) {
		String[] lines = { "docker stop " + containerName };
		String[] lines2 = { "docker rm " + containerName };

		try {
			utilityService.executeCommands(lines);
			utilityService.executeCommands(lines2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Container container = containerService.findContainerByName(containerName);
		containerService.delete(containerName);

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

}
