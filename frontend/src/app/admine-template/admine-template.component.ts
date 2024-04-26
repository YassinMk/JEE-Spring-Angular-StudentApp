import { Component } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-admine-template',
  templateUrl: './admine-template.component.html',
  styleUrls: ['./admine-template.component.css']
})
export class AdmineTemplateComponent {
  constructor(public authService:AuthService) {
  }
  isMenuOpen:boolean = false;
  toggleMenu(){
    this.isMenuOpen = !this.isMenuOpen;
  }

  protected readonly AuthService = AuthService;

  logout() {
    this.authService.logout();
  }
}
