import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {AddEventsComponent} from './add-events/add-events.component';
import {MainWindowComponent} from './main-window/main-window.component';
import {HeaderComponent} from './header/main-header/main-header.component';
import {LoginComponent} from './login/login.component';
import {LoginService} from "./service/login.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {SignUpComponent} from './sign-up/sign-up.component';
import {HomeComponent} from './home/home.component';
import {UserService} from "./service/user.service";
import {AddEventComponent} from './add-events/components/add-event/add-event.component';
import {EventsService} from "./service/events.service";
import { BoardComponent } from './board/board.component';
import { BottomHeaderComponent } from './header/bottom-header/bottom-header.component';
import { CreateBoardComponent } from './board/create-board/create-board.component';
import {BoardService} from "./service/board.service";

const appRoutes: Routes = [
  {path: 'sign-up', component: SignUpComponent},
  {path: 'add-events', component: AddEventsComponent},
  {path: 'board-list', component: BoardComponent},
  {path: 'login', component: LoginComponent},
  {path: 'create-board', component: CreateBoardComponent},
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {path: 'home', component: HomeComponent},
  {path: '**', component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AddEventsComponent,
    MainWindowComponent,
    HeaderComponent,
    LoginComponent,
    SignUpComponent,
    HomeComponent,
    AddEventComponent,
    BoardComponent,
    BottomHeaderComponent,
    CreateBoardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [
    LoginService,
    UserService,
    EventsService,
    BoardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
