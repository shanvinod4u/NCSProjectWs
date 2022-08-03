import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseURL = "http://localhost:8090/abc/admin";
  allUser_url:string = this.baseURL + "/user/allUsers";
  deleteUser_url:string = this.baseURL + "/user/delete/";
  addUser_url:string = this.baseURL + "/user/addUser";
  getUser_url:string = this.baseURL + "/user/";
  updateUser_url:string = this.baseURL + "/user/updateUser";

  constructor(private httpClient:HttpClient) { }

  public getUsers():Observable<User[]> {
     return this.httpClient.get<User[]>(`${this.allUser_url}`);
  }

  public deleteUser(id:number) {
     return this.httpClient.delete(`${this.deleteUser_url}${id}`);
  }

  public addUser(data:any){
    return this.httpClient.post(`${this.addUser_url}`, data);
  }

  public getUserById(id:number):Observable<User> {
    return this.httpClient.get<User>(`${this.getUser_url}${id}`)
  }

  public updateUser(data:any){
    return this.httpClient.put(`${this.updateUser_url}`, data);
  }
  
}
