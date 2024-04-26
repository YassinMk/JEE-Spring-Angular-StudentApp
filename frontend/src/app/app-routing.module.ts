import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {DashbordComponent} from "./dashbord/dashbord.component";
import {PayementsComponent} from "./payements/payements.component";
import {LoadPayementsComponent} from "./load-payements/load-payements.component";
import {ProfilComponent} from "./profil/profil.component";
import {LoadStudentsComponent} from "./load-students/load-students.component";
import {StudentsComponent} from "./students/students.component";
import {LoginComponent} from "./login/login.component";
import {AdmineTemplateComponent} from "./admine-template/admine-template.component";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";

const routes: Routes = [
  {path: '' , component:LoginComponent},
  { path: 'admin',component: AdmineTemplateComponent ,
    canActivate: [AuthGuard] ,
    children:[
      { path: 'profil',component: ProfilComponent },
      { path: 'dashbord',component: DashbordComponent },
      { path: 'payements',component: PayementsComponent },
      { path: 'loadStudents',component: LoadStudentsComponent ,canActivate:[AuthorizationGuard],data:{roles: ["ADMIN"]}},
      { path: 'loadPayements',component: LoadPayementsComponent},
      { path: 'Payements',component: PayementsComponent},
      { path: 'students',component: StudentsComponent},
      { path: 'home',component: HomeComponent },
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
