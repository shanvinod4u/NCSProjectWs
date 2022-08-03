import {NgModule} from "@angular/core";
import { Routes, RouterModule} from "@angular/router";
import { AddQuestionComponent } from './add-question/add-question.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AdminComponent } from './admin/admin.component';
import { AllQuestionComponent } from './all-question/all-question.component';
import { AllUserComponent } from './all-user/all-user.component';
import { AuthGuard } from './auth.guard';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { QuizComponent } from './quiz/quiz.component';
import { StudentComponent } from './student/student.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ViewResultHistoryComponent } from './view-result-history/view-result-history.component';

const routes: Routes = [
    {path:'home', component: HomeComponent},
    {path:'admin', component: AdminComponent, canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'student', component: StudentComponent, canActivate:[AuthGuard], data:{role:['student']}},
    {path:'login', component: LoginComponent},
    {path:'forbidden', component: ForbiddenComponent},
    {path:'allUsers', component: AllUserComponent,canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'allQuestions', component: AllQuestionComponent,canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'addUser', component: AddUserComponent,canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'addQuestion', component: AddQuestionComponent,canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'updateUser/:id', component: UpdateUserComponent,canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'updateQuestion/:id', component: UpdateQuestionComponent,canActivate:[AuthGuard], data:{role:['admin']}},
    {path:'quiz/:category/:difficulty', component: QuizComponent, canActivate:[AuthGuard], data:{role:['student']}},
    {path:'resultHistory/:id', component: ViewResultHistoryComponent, canActivate:[AuthGuard], data:{role:['student']}}

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}