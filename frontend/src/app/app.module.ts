import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdmineTemplateComponent } from './admine-template/admine-template.component';
import { MatToolbarModule, } from '@angular/material/toolbar';
import {MatButtonModule} from "@angular/material/button";
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { HomeComponent } from './home/home.component';
import { LoadStudentsComponent } from './load-students/load-students.component';
import { LoginComponent } from './login/login.component';
import { StudentsComponent } from './students/students.component';
import { PayementsComponent } from './payements/payements.component';
import { DashbordComponent } from './dashbord/dashbord.component';
import { LoadPayementsComponent } from './load-payements/load-payements.component';
import { ProfilComponent } from './profil/profil.component';
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";

@NgModule({
  declarations: [
    AppComponent,
    AdmineTemplateComponent,
    HomeComponent,
    LoadStudentsComponent,
    LoginComponent,
    StudentsComponent,
    PayementsComponent,
    DashbordComponent,
    LoadPayementsComponent,
    ProfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule

  ],
  providers: [
    AuthGuard, AuthorizationGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
