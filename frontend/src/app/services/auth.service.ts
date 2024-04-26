import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public users:any = {
    admin: {password:1234 , roles:["ADMIN","USER"]},
    user: {password:1234 , roles:["USER"]}
  }
  public username : any;
  public isAuth:boolean = false;
  public roles:string[] = [];
  constructor(private router:Router) { }
  public login(username:string , password:string):boolean{
    if(this.users[username] && this.users[username].password == password){
      this.isAuth = true;
      this.username = username;
      this.roles = this.users[username]["roles"];
      return true;
    }else{
      return false;
    }
  }

  logout() {
    this.username = undefined;
    this.isAuth=false;
    this.roles=[];
    this.router.navigateByUrl("/")
  }
}
