import { Component } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private roles: string[] = [];
  public active = false;
  public isAppCollapsed = true;
  public languages = [
    {name: 'EN', label: 'English version', lang: 'en', current: this.active},
    {name: 'FR', label: 'Version française', lang: 'fr', current: this.active},
    {name: 'SP', label: 'Versión en español', lang: 'sp', current: this.active}
  ];
  public selectLanguage = {name: 'Languages', label: '', lang: ''};
  
    ChangeLanuage(l) {
      this.selectLanguage = l;
      this.languages.forEach(lang => { lang.current = this.active; });
      l.current = !l.current;
    }
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  constructor(private tokenStorageService: TokenStorageService) { }
  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      this.username = user.username;
    }
  }
  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}