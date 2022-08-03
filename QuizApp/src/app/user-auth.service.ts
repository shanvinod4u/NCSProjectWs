import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRole(role:string) {
    sessionStorage.setItem("role", role);
  }

  public setUsername(username:string) {
    sessionStorage.setItem("username", username);
  }

  public getUsername():any {
    return sessionStorage.getItem("username");
  }

  public getRole():any {
    return sessionStorage.getItem("role");
  }

  public setToken(token:string) {
    sessionStorage.setItem("jwtToken", token);
  }

  public getToken():string {
    return JSON.stringify(sessionStorage.getItem("jwtToken"));
  }

  public setUserId(id:any) {
    sessionStorage.setItem("id", id);
  }

  public getUserId():any {
    return sessionStorage.getItem("id");
  }

  public clear() {
    sessionStorage.clear();
  }

  public isLoggedIn() {
     return this.getRole() && this.getToken();
  }

}