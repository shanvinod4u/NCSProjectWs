import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserRequestDTOService {

  base_url: string = "http://localhost:8090/abc/public";
  requestHeader = new HttpHeaders({
    "No-Auth": "True",
  });

  constructor(
    private httpClient: HttpClient,
    private userAuthService: UserAuthService
    ) {  }
  
  public login(loginData:any) {
    
    return this.httpClient.post(this.base_url +"/login", loginData, {headers: this.requestHeader});
    
  }

  public roleMatch(userRole:string): boolean {
    let isMatch = false;
    const role = this.userAuthService.getRole();
    if(role == userRole) {
      isMatch = true;
      return isMatch;
    }else {
      return isMatch;
    }
  }
}
