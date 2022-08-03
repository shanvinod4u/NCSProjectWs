import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../user-auth.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  id:any;
  constructor(private userAuthService:UserAuthService) { }

  ngOnInit(  ): void {
    this.id = this.userAuthService.getUserId();
  }

}
