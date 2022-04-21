import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import {PasswordModule} from 'primeng/password';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {SplitterModule} from 'primeng/splitter';
import {FormsModule} from '@angular/forms';
import {TableModule} from 'primeng/table';
import {TabViewModule} from 'primeng/tabview';
import {ToolbarModule} from 'primeng/toolbar';

import { AppComponent } from './app.component';
import { ClientsComponent } from './clients/clients.component';
import { MaterialsComponent } from './materials/materials.component';
import { OffersComponent } from './offers/offers.component';
import { RealizationsComponent } from './realizations/realizations.component';
import { RouterModule, Routes } from '@angular/router';
import { AgreementsComponent } from './agreements/agreements.component';
import { InstallationsComponent } from './installations/installations.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS, ɵHttpInterceptingHandler } from '@angular/common/http';
import { AuthorizationInterceptor } from './authotization.interceptor';

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
    BrowserAnimationsModule,
    BrowserModule,
    ToolbarModule,
    TabViewModule,
    AppRoutingModule,
    SplitterModule,
    ButtonModule,
    InputTextModule,
    PasswordModule,
    TableModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [{
    useClass: AuthorizationInterceptor,
    multi: true,
    provide: HTTP_INTERCEPTORS
  },],
  bootstrap: [AppComponent]
})
export class AppModule { }
