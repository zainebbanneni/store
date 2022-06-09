package com.example.market.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

	Optional<Container> findContainerById(Long id);

	void deleteContainerById(Long id);
	
	Optional<Container> findContainerByName(String containerName);
	
	void deleteContainerByName(String containerName);

}
