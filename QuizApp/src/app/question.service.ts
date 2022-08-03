import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  baseURL = "http://localhost:8090/abc/admin";
  allQuestion_url:string = this.baseURL + "/question/allQuestions";
  deleteQuestion_url:string = this.baseURL + "/question/delete/";
  addQuestion_url:string = this.baseURL + "/question/addQuestion";
  updateQuestion_url:string = this.baseURL + "/question/updateQuestion";
  getQuestion_url:string = this.baseURL + "/question/";

  constructor(private httpClient:HttpClient) { }

  public getAllQuestions():Observable<Question[]> {
    return this.httpClient.get<Question[]>(`${this.allQuestion_url}`);
  }

  public deleteQuestion(id:number) {
    return this.httpClient.delete(`${this.deleteQuestion_url}${id}`);
 }

 public addQuestion(data:any){
  return this.httpClient.post(`${this.addQuestion_url}`, data);

  }

  public getQuestionById(id:number):Observable<Question> {
    return this.httpClient.get<Question>(`${this.getQuestion_url}${id}`)
  }

  public updateQuestion(data:any){
    return this.httpClient.put(`${this.updateQuestion_url}`, data);
  }

}
