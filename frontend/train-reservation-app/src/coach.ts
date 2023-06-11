import { Seat } from "./seat";

export interface Coach {
	coachId:number;
	totalSeats:number;
	availableSeats:number;
	seats:Array<Seat>;
}
