import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from '../../dto/address';
import { Client } from '../../dto/client';
import { ClientService } from '../../service/client.service';


@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.scss']
})
export class ClientFormComponent {

  client: Client;
  address: Address;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private clientService: ClientService) { 
      this.client = new Client();
      this.address = new Address();
    }

    onSubmit(){
      this.client.addressesList?.push(this.address);
      this.clientService.save(this.client).subscribe(result => {
        this.gotoClientList()}
        );      
    }

    gotoClientList() {
    this.router.navigate(['/clients'])
    }
}
