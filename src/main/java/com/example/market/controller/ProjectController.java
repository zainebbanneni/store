package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.model.Project;
import com.example.market.repo.ProjectRepository;
import com.example.market.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	  ProjectRepository projectRepository;
	
	private final ProjectService projectService;
	

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects () {
        List<Project> projects = projectService.findAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById (@PathVariable("id") Long id) {
        Project project = projectService.findProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project newProject = projectService.createProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        Project updateProject = projectService.updateProject(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {
      try {
        projectRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    @GetMapping("/projects/published")
    public ResponseEntity<List<Project>> findByPublished() {
      try {
        List<Project> projects = projectRepository.findByPublished(true);
        if (projects.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
	

}
