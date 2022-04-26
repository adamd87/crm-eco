import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { Client } from './client';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html'
})
export class ClientsComponent implements OnInit {

  private clientsUrl = 'http://localhost:8080/api/clients';

  clientList!: Client[];

  loading: boolean = true;

  newClient: Client = {
    name: '',
    surname: '',
    phone: '',
    email: '',
    info: '',
    agreement: false,
    installation: false,
    privatePerson: false,
    business: false,
    nip: '',
    regon: '',
    traderName: '',
  };
  

  constructor(private httpClient: HttpClient, private router: Router) { 
  }


  loadClients():void{
    this.httpClient.get<Client[]>(this.clientsUrl + '/list')
    .subscribe(clientList => this.clientList = clientList);
    
    this.newClient.name = '';
    this.newClient.surname = '';
    this.newClient.phone = '';
    this.newClient.email = '';
    this.newClient.info = '';
    this.newClient.agreement = false;
    this.newClient.installation = false;
    this.newClient.privatePerson = false;
    this.newClient.business = false;
    this.newClient.nip = '';
    this.newClient.regon = '';
    this.newClient.traderName = '';
   }

  ngOnInit(): void {
    this.loadClients();
    this.loading = false;
  }

  getClientById(clientId: number){
    return this.httpClient.get(this.clientsUrl + 'get-by-id/{clientId}');
  }


}

