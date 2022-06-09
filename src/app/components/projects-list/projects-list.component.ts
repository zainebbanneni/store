import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/services/project.service';
import { StoreRequest } from 'src/app/models/storeRequest.model';
import { ContainerService } from 'src/app/services/container.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-projects-list',
  templateUrl: './projects-list.component.html',
  styleUrls: ['./projects-list.component.css']
})
export class ProjectsListComponent implements OnInit {
  projects?: Project[];
  currentProject: Project = {};
  currentIndex = -1;
  name = '';
  

  constructor(private projectService: ProjectService, private containerService: ContainerService, private router: Router) { }

  ngOnInit(): void {
    this.retrieveProjects();
  }
  retrieveProjects(): void {
    this.projectService.getAll()
    .subscribe({
      next: (data) => {
        this.projects = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
}
refreshList(): void {
  this.retrieveProjects();
  this.currentProject = {};
  this.currentIndex = -1;
}
setActiveProject(project: Project, index: number): void {
  this.currentProject = project;
  this.currentIndex = index;
}
removeAllProjects(): void {
  this.projectService.deleteAll()
    .subscribe({
      next: (res) => {
        console.log(res);
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
}
searchName(): void {
  this.currentProject = {};
  this.currentIndex = -1;
  this.projectService.findByName(this.name)
    .subscribe({
      next: (data) => {
        this.projects = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
}

  }


