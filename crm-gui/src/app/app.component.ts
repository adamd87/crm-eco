import { Component, OnInit } from '@angular/core';
import {LoggedUser} from './logged-user';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import {MenuItem} from 'primeng/api';
import { Button } from 'primeng/button';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {

  username!: string;
  password!: string;
  loggedUser!: LoggedUser;

  items!: MenuItem[];


  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.login();
    this.items = [
      {label: 'Clients', routerLink: "/clients"},
      {label: 'Agreements', routerLink: "/agreements"},
      {label: 'Materials', routerLink: "/materials"},
      {label: 'Offer', routerLink: "/offers"},
      {label: 'Realizations', routerLink: "/realizations"},
      {label: 'Installations', routerLink: "/installations"}
    ];
  }

  onLoginFormSubmit(): void {
    this.storeAuthorizationHeaderInLocalStorage();
    this.login(() => {
      alert('Invalid username or password!');
      this.username = '';
      this.password = '';
    });
  }

  private storeAuthorizationHeaderInLocalStorage(): void {
    const authorizationHeader = 'Basic ' + btoa(this.username + ':' + this.password);
    localStorage.setItem('authorizationHeader', authorizationHeader);
  }

  private login(errorCallback?: () => void): void {
    this.httpClient.post<LoggedUser>('http://localhost:8080/login', {})
      .subscribe(loggedUser => {
          this.router.navigate(['']);
          this.loggedUser = loggedUser;
        },
        () => {
          if (errorCallback) {
            errorCallback();
          }
        });
  }
  logout(): void {
    localStorage.removeItem('authorizationHeader');
    this.router.navigate([''])
      .then(() => location.reload());
  }


}
