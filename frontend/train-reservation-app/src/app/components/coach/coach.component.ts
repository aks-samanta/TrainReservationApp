import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BookingDto } from 'projects/train-reservation-app/src/booking-dto';
import { BookingService } from '../../services/booking.service';
import { Coach } from 'projects/train-reservation-app/src/coach';
import { CoachService } from '../../services/coach.service';
import { Ticket } from 'projects/train-reservation-app/src/ticket';

@Component({
	selector: 'app-coach',
	templateUrl: './coach.component.html',
	styleUrls: ['./coach.component.scss']
})
export class CoachComponent {

	constructor(private bookingService: BookingService, private coachService: CoachService) { }

	@Input() coach!: Coach;

	bookingMode = false;

	bookingDto?: BookingDto;

	showTicket = false;

	ticket!: Ticket;

	ngOnInit(): void {
		this.coachService.getCoach().subscribe({
			next: (res: any) => {
				this.coach = res;
				console.log(res);
			},
			error: (err: any) => {
				console.log(err);
			},
			complete: () => {
				console.log("complete");
			}
		})
	}


	onBook(bookingDto: BookingDto) {
		this.bookingService.bookTicket(bookingDto).subscribe({
			next: (res) => {
				if (res.status == 400) {
					console.log(res);
					alert(res.detail);
				} else {
					const ticket: Ticket = res;
					this.coach = ticket.coach;
					console.log(res);
					this.ticket = ticket;
					this.showTicket = true;
				}

			},
			error: (err) => {
				console.log(err);
			},
			complete: () => {
				console.log("complete");
			}
		})
	}
}
