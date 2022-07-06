import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Addresses } from '../dto/addresses';
import { Client } from '../dto/client';

import { ClientDetailsDto } from '../dto/clientDetailsDto';
import { UpdateAddressReq } from '../dto/updateAddressReq';

@Injectable({providedIn: 'root'})
export class ClientService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

   public findAll(): Observable<Client[]>{
     return this.http.get<Client[]>(`${this.apiServerUrl}/clients/list`);
   }

   public getAllAddresses(): Observable<Addresses[]>{
    return this.http.get<Addresses[]>(`${this.apiServerUrl}/clients/addresses/list`);
  }

   public clientDetails(id: number): Observable<ClientDetailsDto>{
    return this.http.get<ClientDetailsDto>(`${this.apiServerUrl}/clients/get-by-id/${id}`);
   }

   public save(client: Client): Observable<Client>{
     return this.http.post<Client>(`${this.apiServerUrl}/clients/create`, client);
   }

   public updateClient(id: number, client: Client): Observable<Client>{
     return this.http.patch<Client>(`${this.apiServerUrl}/clients/update/${id}`, client)
   }
   
   public updateAddress(address: UpdateAddressReq): Observable<ClientDetailsDto>{
     return this.http.patch<ClientDetailsDto>(`${this.apiServerUrl}/clients/addresses/update`, address)
   }

}