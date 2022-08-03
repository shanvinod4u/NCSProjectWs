import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  message:string = "";

  constructor(private questionService:QuestionService, private router:Router) { }

  ngOnInit(): void {
  }

  public addQuestions(questionForm:NgForm){
    this.questionService.addQuestion(questionForm.value).subscribe(
      (data) => {
        this.message = "User Data Added Successfully";
        this.questionList();
    },
    (error) => {
      console.log(error);
      
    })
  }

  public questionList(){
    this.router.navigate(['/allQuestions']).then(() => {
      window.location.reload();
    });
  }

}
