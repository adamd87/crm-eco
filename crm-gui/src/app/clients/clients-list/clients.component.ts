import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Addresses } from '../dto/addresses';
import { Client } from "../dto/client";
import { ClientDetailsDto } from '../dto/clientDetailsDto';
import { UpdateAddressReq } from '../dto/updateAddressReq';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html'
})
export class ClientsComponent implements OnInit {
  
 
  public clients!: Client[];
  public addresses!: Addresses[];
  public clientUpdate!: Client;
  public clientDetails!: ClientDetailsDto;
  public updatedAddress!: UpdateAddressReq;
  

  public clientId!: number;


  constructor(private clientService: ClientService) {}

  ngOnInit() {
    this.getClients();    
  }

  public getClients(): void {
    this.clientService.findAll().subscribe(
      (response: Client[]) => {
        this.clients = response;
        console.log(this.clients);      
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAddresses(): void {
    this.clientService.getAllAddresses().subscribe(
      (response: Addresses[]) => {
        this.addresses = response;
        console.log(this.addresses);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getClientDetails(clientId: number): void {
    this.clientService.clientDetails(clientId).subscribe(
      (response: ClientDetailsDto) => {
        this.clientDetails = response;
        console.log(this.clientDetails);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public addNewClient(addForm: NgForm): void {
    document.getElementById('add-client-form')?.click();
    this.clientService.save(addForm.value).subscribe(
      (response: Client) => {
        console.log(response);        
        this.getClients();
        addForm.reset();       
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    )
  }

  public updateClient(clientId: number, client: Client): void {
    this.clientService.updateClient(clientId, client).subscribe(
      (response: Client) => {
        console.log(response);
        this.getClients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public updateAddress(addForm: NgForm): void {
    document.getElementById('update-address-form')?.click();
    this.clientService.updateAddress(addForm.value).subscribe(
      (response: ClientDetailsDto) => {
        console.log(response);
        this.getClients();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    )
  }

  public searchClient(key: string): void {
    console.log(key);
    const results: Client[] = [];
    for (const client of this.clients!) {
      if (client.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || client.surname.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || client.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || client.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || client.traderName.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(client);
      }
    }
    this.clients = results;
    if (results.length === 0 || !key) {
      this.getClients();
    }
  }

  public onOpenModal(client: Client, mode: string, id: number): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');    
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addClientModal');
    }
    if (mode === 'edit') {
      this.clientUpdate = client;
      this.clientId = id;
      button.setAttribute('data-target', '#updateClientModal');
    }
    if (mode === 'details') {
      this.clientId = id;      
      button.setAttribute('data-target', '#detailsClientModal'); 
    }
    container!.appendChild(button);
    button.click();
  }
     

}

