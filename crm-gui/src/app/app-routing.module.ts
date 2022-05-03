import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientDetailsComponent } from './clients/client-details/client-details.component';
import { ClientsComponent } from './clients/clients-list/clients.component';
import { ClientFormComponent } from './clients/form/new-client/client-form.component';
import { UpdateClientFormComponent } from './clients/form/update-client/update-client-form.component';

const routes: Routes = [
  {path: 'clients',  component: ClientsComponent},
  {path: 'client-details',  component: ClientDetailsComponent},
  {path: 'create-client',  component: ClientFormComponent},
  {path: 'update-client',  component: UpdateClientFormComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
