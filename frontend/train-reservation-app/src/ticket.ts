import { Coach } from "./coach"
import { Seat } from "./seat"

export interface Ticket {
	ticketId: number
	reservedSeats: Array<Seat>
	bookingDate: Date
	coach: Coach
}
