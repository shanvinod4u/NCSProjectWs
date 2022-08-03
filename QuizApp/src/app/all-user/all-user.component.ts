import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.css']
})
export class AllUserComponent implements OnInit {

  users: User[] = [];
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    this.allUsers();
  }

  public allUsers() {
    this.userService.getUsers().subscribe(
      (data) => {
        this.users = data;
      },
      (err) => {
        console.log(err);
      }
    )
  }

  public deleteUsers(id:number) {
    this.userService.deleteUser(id).subscribe(
      (data) => {
        console.log(data);
        this.userList();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  public userList(){
    this.router.navigate(['/allUsers']).then(() => {
      window.location.reload();
    });

  }


}
