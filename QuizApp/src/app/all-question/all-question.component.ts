import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterStateSnapshot } from '@angular/router';
import { Question } from '../question';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-all-question',
  templateUrl: './all-question.component.html',
  styleUrls: ['./all-question.component.css']
})
export class AllQuestionComponent implements OnInit {

  questions: Question[]=[];
  constructor(private questionService:QuestionService, private router:Router) { }

  ngOnInit(): void {
    this.getAllQuestions();
  }
  public getAllQuestions() {
    return this.questionService.getAllQuestions().subscribe(
      (data)=>{
        this.questions = data;
      },
      (err) => {
        console.log(err);
      }
    )
  }

  public deleteQuestions(id:number) {
    this.questionService.deleteQuestion(id).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/allQuestions']).then(() => {
          window.location.reload();
        });

      },
      (err) => {
        console.log(err);
      }
    );
  }
}
