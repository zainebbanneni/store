import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/services/project.service';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css']
})
export class AddProjectComponent implements OnInit {
  project: Project = {
    name: '',
    description: '',
    imageName: '',
    published: false
  };
  submitted = false;

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
  }
  saveProject(): void {
    const data = {
      name: this.project.name,
      description: this.project.description,
      imageName: this.project.imageName
    };
    this.projectService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }
  newProject(): void {
    this.submitted = false;
    this.project = {
      name: '',
      description: '',
      imageName:'',
      published: false
    };
  }

}
