import { Component, OnInit } from '@angular/core';
import { Client } from "../dto/client";
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html'
})
export class ClientsComponent implements OnInit {
  
  clientList: Client[] = [];

  loading: boolean = true;  


  constructor(private clientService: ClientService) {  }

  ngOnInit() {
    this.clientService.findAll().subscribe(data =>{
      this.clientList = data;
    });    
  }



}

