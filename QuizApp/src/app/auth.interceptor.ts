import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/Operators' 
import { UserAuthService } from './user-auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    
    constructor(private userAuthService: UserAuthService, private router:Router) {}
    
    intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
       
        if(req.headers.get('No-Auth') === 'True'){
            return next.handle(req.clone());
        }

        const token = this.userAuthService.getToken();

        this.addToken(req, token);
        return next.handle(req).pipe(
            catchError(
                (err:HttpErrorResponse) => {
                    if(err.status === 401) {
                        this.router.navigate(['/login']);
                    }else if(err.status === 403) {
                        this.router.navigate(['/forbidden']);
                    }
                      return throwError("something went wrong");
                }
            )
        );
    }

    private addToken(request:HttpRequest<any>, token:string){
        return request.clone({
            setHeaders: {
                Authorization : `ncs-${token}`
                
            }
        })
    }
   
    
}