import { Component,Input, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/services/project.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {
  @Input() viewMode = false;
  @Input() currentProject: Project = {
    name: '',
    description: '',
    imageName:'',
    published: false
  };
  
  message = '';

  constructor(private projectService: ProjectService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getProject(this.route.snapshot.params["id"]);
    }
  }
  getProject(id: string): void {
    this.projectService.get(id)
      .subscribe({
        next: (data) => {
          this.currentProject = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  updatePublished(status: boolean): void {
    const data = {
      name: this.currentProject.name,
      description: this.currentProject.description,
      imageName: this.currentProject.imageName,
      published: status
    };
    this.message = '';
    this.projectService.update(this.currentProject.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentProject.published = status;
          this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }
  updateProject(): void {
    this.message = '';
    this.projectService.update(this.currentProject.id, this.currentProject)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This project was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }
  deleteProject(): void {
    this.projectService.delete(this.currentProject.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/admin/projects']);
        },
        error: (e) => console.error(e)
      });
  }

}
