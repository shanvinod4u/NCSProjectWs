import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../user-auth.service';
import { UserRequestDTOService } from '../user-request-dto.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

   message:any;

  constructor(
    private userRequestDTO: UserRequestDTOService, 
    private userAuthService: UserAuthService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }
  login(loginForm:NgForm) {
    this.userRequestDTO.login(loginForm.value).subscribe(
      (response: any) => {
        
        this.userAuthService.setToken(response.token);
        this.userAuthService.setRole(response.role);
        this.userAuthService.setUsername(response.username);
        this.userAuthService.setUserId(response.userId);

        const role = response.role;

        if(role === 'admin'){
          this.router.navigate(["/admin"]).then(() => {
            window.location.reload();
          });  
        }else {
          this.router.navigate(["/student"]).then(() => {
            window.location.reload();
          });
  
        }
      },
      (error: any) => {
        
        return this.message = error.error.message;
        
      }
    );   
  }
}
