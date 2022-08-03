import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from '../question';
import { QuestionService } from '../question.service';



@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.css']
})
export class UpdateQuestionComponent implements OnInit {

  id:number = 0;
  question: Question = new Question(0,"","",0,"","","","","","");

  constructor(
    private questionService:QuestionService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.questionService.getQuestionById(this.id).subscribe(data => {
      this.question = data;
    }, error => console.log(error));
  }

  public updateQuestion(data:NgForm) {
    this.questionService.updateQuestion(data.value).subscribe(
      (resp) => {
        this.questionList();
      },error => console.log(error));
  }

  public questionList(){
    this.router.navigate(['/allQuestions']).then(() => {
      window.location.reload();
    });
  }


}
