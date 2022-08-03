import { Component, HostListener, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { LocationStrategy } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserAuthService } from '../user-auth.service';
import { TestScoreService } from '../test-score.service';
import { UserService } from '../user.service';


@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  category:any;
  difficulty:any;
  marks:any;
  totalScore:any;
  questions: any = [{questionId:'',questionString:'',category:'',difficulty:'',option1:'',option2:'',option3:'',option4:'',correctAnswer:'',givenAnswer:''}];
  isSubmit=false;
  result:any;
  warningCount=0;
  timer=0;
  id:any;
  user:any;

  constructor(
    private locationStrategy: LocationStrategy,
    private route: Router,
    private router:ActivatedRoute,
    private snakebar:MatSnackBar,
    private userAuthService:UserAuthService,
    private testScoreService:TestScoreService,
    private userService:UserService   
  ) { }

  ngOnInit(): void {

    this.preventbackbutton();
    this.category= this.router.snapshot.params['category'];
    console.log(this.category);
    this.difficulty= this.router.snapshot.params['difficulty'];
    console.log(this.difficulty);
    this.testScoreService.getQuestions(this.category, this.difficulty).subscribe(
      (data)=>{
        this.questions=data;
        console.log(this.questions);
        this.timer=this.questions.length*60;
        this.startTimer();
      },
      (error)=>{
        Swal.fire("error","quiz questions can't be loaded try again!!","error");
      }
    )
    this.id = this.userAuthService.getUserId();
    this.user = this.userService.getUserById(this.id);
  }

  public preventbackbutton(){
    this.warningCount++;
    history.pushState(null,location.href);
    this.locationStrategy.onPopState(()=>{
      history.pushState(null,location.href);
      Swal.fire("warning","you can't navigate back","warning");
      if(this.warningCount>5){
        //this.submitQuiz();
        Swal.fire("warning","This is your last warning now your exam gets automatically submitted!!","warning");
        this.logout();
      }
      
    })
  }

  public logout() {
    this.userAuthService.clear();
    this.route.navigate(["/home"]).then(() => {
      window.location.reload();
    });

  }


submitQuiz(){
  Swal.fire({
    title: 'Do you want to submit the quiz?',
   
    showCancelButton: true,
    confirmButtonText: `Submit`,
   
  }).then((result)=>{
    this.isSubmit=true;
     this.evaluateQuiz(this.questions, this.id);
  })
}

  public evaluateQuiz(questions:any, id:any){
    console.log(this.questions);
    this.testScoreService.submitTestScore(questions,id).subscribe(
      (data) => {
        Swal.fire("Success","Quiz is successfully submitted you can now download your result with response!!","success");
        this.result=data;
        this.marks=this.result.marks;
        this.totalScore=this.result.totalScore;
      },
      (error)=>{
        Swal.fire("error","Quiz can't be evaluated try again to submit","error");
      })
  }

  startTimer(){
    let t= window.setInterval(()=>{
       if(this.timer<=0){
         this.submitQuiz();
         clearInterval(t);
       }
       else{
         this.timer--;
       }
     },1000);
   }

}
