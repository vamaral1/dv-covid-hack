import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainbodyComponent } from './mainbody/mainbody.component';
import { SuplyListComponent } from './suply-list/suply-list.component';
import { EnterSuppliesComponent } from './enter-supplies/enter-supplies.component';
import { EnterUsersComponent } from './enter-users/enter-users.component';
import { EnterFacilitiesComponent } from './enter-facilities/enter-facilities.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

const appRoutes: Routes = [
  {
    path: '',
    component: MainbodyComponent
  },
  {
    path: 'supply-list',
    component: SuplyListComponent
  },
  {
    path: 'enter-supplies',
    component: EnterSuppliesComponent
  },
  {
    path: 'enter-users',
    component: EnterUsersComponent
  },
  {
    path: 'enter-facilities',
    component: EnterFacilitiesComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MainbodyComponent,
    SuplyListComponent,
    EnterSuppliesComponent,
    EnterUsersComponent,
    EnterFacilitiesComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
