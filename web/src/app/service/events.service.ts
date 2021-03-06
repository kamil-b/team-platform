
import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {LoginService} from "./login.service";
import {formatDate} from "@angular/common";
import {UserEvent} from "../shared/model/user.event.model";

@Injectable()
export class EventsService {

  constructor(private http: HttpClient,
              private loginService: LoginService) {
  }

  baseUrl: string = 'http://localhost:8080/api';


  getEvents(startDate: Date, endDate: Date) {
    console.log('getting user events for username: ', this.loginService.getUsername());
    let params = new HttpParams().set("endDate", formatDate(endDate, "yyyy-MM-dd", 'en-gb'));
    params = params.append("startDate", formatDate(startDate, "yyyy-MM-dd", 'en-gb'));

    return this.http.get(this.baseUrl + '/events/batch/' + this.loginService.getUsername(), {params});
  }

  createEvents(events: UserEvent[]) {
    console.log("sending events: ", events);
    return this.http.post(this.baseUrl + '/events',
      {
        username: this.loginService.getUsername(),
        events: events
      }
    );
  }
}

