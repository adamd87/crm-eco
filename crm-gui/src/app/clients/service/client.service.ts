import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addresses } from '../dto/addresses';
import { Client } from "../dto/client";
import { ClientDetailsDto } from '../dto/clientDetailsDto';
import { UpdateAddressReq } from '../dto/updateAddressReq';

@Injectable()

export class ClientService {

  private clientUrl: string;

  constructor(private http: HttpClient) {
    this.clientUrl = 'http://localhost:8080/api/clients';
   }

   public findAll(): Observable<Client[]>{
     return this.http.get<Client[]>(this.clientUrl + '/list');
   }

   public getAllAddresses(): Observable<Addresses[]>{
    return this.http.get<Addresses[]>(this.clientUrl + '/addresses/list');
  }

   public clientDetails(id: number){
    return this.http.get<ClientDetailsDto>(this.clientUrl + '/get-by-id/' + id);
   }

   public save(client: Client){
     return this.http.post<Client>(this.clientUrl + '/create', client);
   }

   public updateClient(id: number, client: Client){
     return this.http.patch<Client>(this.clientUrl + '/update/' + id, client)
   }
   
   public updateAddress(address: UpdateAddressReq){
     return this.http.patch<ClientDetailsDto>(this.clientUrl + '/addresses/update', address)
   }

}