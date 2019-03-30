import {Component, OnInit} from '@angular/core';
import {UserEvent} from "../shared/model/user.event.model";
import {EventsService} from "../service/events.service";
import {FormArray, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-events',
  templateUrl: './add-events.component.html',
  styleUrls: ['./add-events.component.css']
})
export class AddEventsComponent implements OnInit {

  endDate: Date;
  startDate: Date;
  events: UserEvent[];
  eventsForm: FormGroup;

  constructor(private eventsService: EventsService) {
    this.startDate = new Date();
    this.endDate = new Date();

    this.endDate.setDate(this.startDate.getDate() + 30);
  }

  ngOnInit() {

    this.eventsForm = new FormGroup({
      eventsForms: new FormArray([]),
    });

    this.events = [];

    this.loadMoreEvents();
  }

  loadMoreEvents() {
    this.loadEvents(this.startDate, this.endDate);

    this.startDate = new Date(this.startDate);
    this.startDate.setDate(this.startDate.getDate() + 30);

    this.endDate = new Date(this.endDate);
    this.endDate.setDate(this.endDate.getDate() + 30);

  }

  loadEvents(startDate , endDate) {
    this.eventsService.getEvents(startDate , endDate).subscribe(
      (data: UserEvent[]) => {
        this.events = this.events.concat(data);
        data.forEach((event:UserEvent) => this.addEvent(event));
        console.log(this.eventsForms);
      }
    )
  }

  addEvent(event: UserEvent) { this.eventsForms.push(new FormControl(event)); }

  get eventsForms(): FormArray { return this.eventsForm.get('eventsForms') as FormArray; }
}
