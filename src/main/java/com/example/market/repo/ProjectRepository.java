package com.example.market.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	void deleteProjectById(Long id);

	Optional<Project> findProjectById(Long id);
	List<Project> findByPublished(boolean published);
	List<Project> findByName(String name);



}
