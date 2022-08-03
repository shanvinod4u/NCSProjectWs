import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserAuthService } from './user-auth.service';
import { UserRequestDTOService } from './user-request-dto.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private userAuthservice:UserAuthService, 
    private router:Router,
    private userRequestDtoService:UserRequestDTOService
    ) {  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      if(this.userAuthservice.getToken() !== null) {
        const role = route.data['role'] as string;

        if(role) {
          const match = this.userRequestDtoService.roleMatch(role);
          if(match){
            return true;
          }else {
            this.router.navigate(['/forbidden']);
            return false;
          }
        }
      }
      this.router.navigate(['login']);
      return false;
  }
  
}
