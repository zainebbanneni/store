import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ScrollTopModule } from 'ng-boosted';
import { AddProjectComponent } from './components/add-project/add-project.component';
import { ProjectDetailsComponent } from './components/project-details/project-details.component';
import { ProjectsListComponent } from './components/projects-list/projects-list.component';
import { DemoComponent } from './components/demo/demo.component';
import { ContainerService } from 'src/app/services/container.service';
import { ProjectService } from 'src/app/services/project.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    AddProjectComponent,
    ProjectDetailsComponent,
    ProjectsListComponent,
    DemoComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ScrollTopModule
    ],

  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [ProjectService, ContainerService, authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
