package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Container;
import com.example.demo.repo.ContainerRepository;

@Service
@Transactional
public class ContainerService {
	private final ContainerRepository containerRepository;

    @Autowired
    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }
    
    public void addContainer(Container container) {
		containerRepository.save(container);
		
	}
    
    
    
    public List<Container> findAllContainers() {
        return containerRepository.findAll();
    }
    
    public Container findContainerById(Long id) {
        return containerRepository.findContainerById(id)
                .orElseThrow(() -> new UserNotFoundException("Container by id " + id + " was not found"));
    }



	

	

}
