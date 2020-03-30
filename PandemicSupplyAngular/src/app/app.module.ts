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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MapComponent } from './map/map.component';
import { MapFilterComponent } from './map-filter/map-filter.component';
import { CommonModule } from '@angular/common';

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
    EnterFacilitiesComponent,
    MapComponent,
    MapFilterComponent,
    SuplyListComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  exports: [SuplyListComponent],
  providers: [],
  bootstrap: [AppComponent, SuplyListComponent]
})
export class AppModule { }
