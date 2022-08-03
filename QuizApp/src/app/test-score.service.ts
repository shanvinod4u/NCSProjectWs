import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TestScore } from './test-score';

@Injectable({
  providedIn: 'root'
})
export class TestScoreService {

  baseURL:string= "http://localhost:8090/abc/student";
  getQuestions_url:string = this.baseURL + "/exam/";
  submitExam_url:string = this.baseURL+"/submit/exam/";
  getResultHistory_url = this.baseURL+ "/result/history/";

  constructor(private httpClient:HttpClient) { }

  public getQuestions(category:string, difficulty:number) {
    return this.httpClient.get(`${this.getQuestions_url}${category}/${difficulty}`)
  }

  public submitTestScore(questions:any,id:any) {
    return this.httpClient.post(`${this.submitExam_url}${id}`, questions);
  }

  public getResultHistory(id:any):Observable<TestScore[]> {
    return this.httpClient.get<TestScore[]>(`${this.getResultHistory_url}${id}`);
  }

}
