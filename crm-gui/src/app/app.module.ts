import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {SplitterModule} from 'primeng/splitter';
import { FormsModule } from '@angular/forms';
import { ClientsComponent } from './clients/clients.component';
import { MaterialsComponent } from './materials/materials.component';
import { OffersComponent } from './offers/offers.component';
import { RealizationsComponent } from './realizations/realizations.component';
import { RouterModule, Routes } from '@angular/router';
import { AgreementsComponent } from './agreements/agreements.component';
import { InstallationsComponent } from './installations/installations.component';
import {TableModule} from 'primeng/table';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS, ɵHttpInterceptingHandler } from '@angular/common/http';

const routes: Routes = [{
  path: 'clients',
  component: ClientsComponent
}, {
  path: 'materials',
  component: MaterialsComponent
}, {
  path: 'offers',
  component: OffersComponent
}, {
  path: 'realizations',
  component: RealizationsComponent
}, {
  path: 'agreements',
  component: AgreementsComponent
}, {
  path: 'installations',
  component: InstallationsComponent
}];

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent,
    AgreementsComponent,
    MaterialsComponent,
    OffersComponent,
    RealizationsComponent,
    InstallationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SplitterModule,
    ButtonModule,
    InputTextModule,
    TableModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [
    {    
      provide: HTTP_INTERCEPTORS, useClass: ɵHttpInterceptingHandler, multi: true 
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
