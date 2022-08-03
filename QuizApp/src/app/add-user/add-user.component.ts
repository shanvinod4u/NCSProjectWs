import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  message:string = "";
  
  constructor(private userService:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  public addUser(userForm:NgForm){
    this.userService.addUser(userForm.value).subscribe(
      (data) => {
        this.message = "User Data Added Successfully";
        this.userList();
    },
    (error) => {
      console.log(error.response);
      
    })
  }

  public userList(){
    this.router.navigate(['/allUsers']).then(() => {
      window.location.reload();
    });
  }
}
