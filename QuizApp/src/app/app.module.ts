import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AdminComponent } from './admin/admin.component';
import { StudentComponent } from './student/student.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing-module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { AuthInterceptor } from './auth.interceptor';
import { UserRequestDTOService } from './user-request-dto.service';
import { AllUserComponent } from './all-user/all-user.component';
import { AllQuestionComponent } from './all-question/all-question.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { QuizComponent } from './quiz/quiz.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import { ViewResultHistoryComponent } from './view-result-history/view-result-history.component';
 
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdminComponent,
    StudentComponent,
    LoginComponent,
    ForbiddenComponent,
    HomeComponent,
    AllUserComponent,
    AllQuestionComponent,
    AddUserComponent,
    AddQuestionComponent,
    UpdateQuestionComponent,
    UpdateUserComponent,
    QuizComponent,
    ViewResultHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    MatCardModule, 
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatProgressSpinnerModule,
    MatRadioModule,
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    UserRequestDTOService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
