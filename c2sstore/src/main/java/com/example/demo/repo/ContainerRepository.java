package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
	
	Optional<Container> findContainerById(Long id);


}
