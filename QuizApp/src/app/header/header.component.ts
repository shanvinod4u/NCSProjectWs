import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../user-auth.service';
import { UserRequestDTOService } from '../user-request-dto.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username:any = sessionStorage.getItem('username');
  constructor(
    private userAuthService:UserAuthService,
    private router: Router,
    private userResquestDtoService:UserRequestDTOService
    ) { }

  ngOnInit(): void {
    this.username;
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(["/home"]).then(() => {
      window.location.reload();
    });

  }

  public roleMatch(userRole:string) {
    return this.userResquestDtoService.roleMatch(userRole);
  }

}
