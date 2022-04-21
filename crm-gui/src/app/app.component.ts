import { Component, OnInit } from '@angular/core';
import {LoggedUser} from './logged-user';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {  
 
  username!: string;
  password!: string;
  loggedUser!: LoggedUser;


  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.login();
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
