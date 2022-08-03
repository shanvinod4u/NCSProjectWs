import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id:number = 0;
  user: User = new User(0,"","","","");
  
  constructor(
    private userService:UserService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.getUserById(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
  }

  public updateUser(data:NgForm) {
    this.userService.updateUser(data.value).subscribe(
      (resp) => {
        this.userList();
      },error => console.log(error));
  }

  public userList(){
    this.router.navigate(['/allUsers']).then(() => {
      window.location.reload();
    });
  }

}
