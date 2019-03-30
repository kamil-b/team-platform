import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserEvent} from "../../../shared/model/user.event.model";
import {UserEventType} from "../../../shared/model/user.event.type.enum";

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.scss']
})
export class AddEventComponent implements OnInit {

  @Input()
  public userEvent: UserEvent;
  public eventTypes;
  public eventSelected: UserEventType;

  @Output() public eventChanged: EventEmitter<UserEvent> = new EventEmitter();

  constructor() { }

  ngOnInit() {
    this.eventTypes = [];
    this.eventSelected = UserEventType[this.userEvent.type];

    for (let item in UserEventType) {
      if (isNaN(Number(item))) {
       this.eventTypes.push(item);
      }
    }
  }

  setEventType($event: UserEventType) {
    this.eventSelected = $event;
  }
}
