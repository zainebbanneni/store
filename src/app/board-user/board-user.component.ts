import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { StoreRequest } from 'src/app/models/storeRequest.model';
import { ProjectService } from 'src/app/services/project.service';
import { ContainerService } from 'src/app/services/container.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  projects?: Project[];
  currentProject: Project = {};
  currentIndex = -1;
  name = '';
  storeRequest: StoreRequest = new StoreRequest();
  port?: number;
  response: any;
  postResponse: any;
  imageName?: string;
  

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

createCont(id: number) {
  this.storeRequest.userId = '1';
  this.storeRequest.imageName = 'httpd';
  this.containerService.createCont(this.storeRequest).subscribe(data => {
    this.response = data;
    this.port = this.response;
    console.log(data);
    this.router.navigate(['user/create-Cont', id], {state: {data: this.port}});
  });
}
  }


