package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Project;
import com.example.demo.repo.ProjectRepository;

@Service
@Transactional
public class ProjectService {
	
	 private final ProjectRepository projectRepo;

	    @Autowired
	    public ProjectService(ProjectRepository projectRepo) {
	        this.projectRepo = projectRepo;
	    }
	    
	    public Project addProject(Project project) {
	        project.setName(UUID.randomUUID().toString());
	        return projectRepo.save(project);
	    }
	    public List<Project> findAllProjects() {
	        return projectRepo.findAll();
	    }

	    public Project updateProject(Project project) {
	        return projectRepo.save(project);
	    }

	    public Project findProjectById(Long id) {
	        return projectRepo.findProjectById(id)
	                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	    }

	    public void deleteProject(Long id){
	        projectRepo.deleteProjectById(id);
	    }

}
