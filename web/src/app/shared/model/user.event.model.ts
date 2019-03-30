export class UserEvent {

  userId: string;
  type: string;
  date: Date;
  description: string;

  constructor(userId: string, type: string, date: Date, description: string) {
    this.userId = userId;
    this.type = type;
    this.date = date;
    this.description = description;
  }
}
