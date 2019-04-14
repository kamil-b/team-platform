import {UserEventType} from "./user.event.type.enum";

export class UserEvent {

  userId: string;
  type: UserEventType;
  date: Date;
  description: string;

  constructor(userId: string, type: UserEventType, date: Date, description: string) {
    this.userId = userId;
    this.type = type;
    this.date = date;
    this.description = description;
  }
}
