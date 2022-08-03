import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TestScoreService } from '../test-score.service';

@Component({
  selector: 'app-view-result-history',
  templateUrl: './view-result-history.component.html',
  styleUrls: ['./view-result-history.component.css']
})
export class ViewResultHistoryComponent implements OnInit {

  testScore: any;
  id:any;

  constructor(private testScoreService:TestScoreService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getResultHistory(this.id);
  }

  public getResultHistory(id:any){
    this.testScoreService.getResultHistory(id).subscribe(
      (data) => {
        this.testScore = data;
      },
      (error) => {
        console.log(error);
      }
      )
  }

}
