import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BookingDto } from 'projects/train-reservation-app/src/booking-dto';
import { BookingService } from '../../services/booking.service';
import { Coach } from 'projects/train-reservation-app/src/coach';
import { CoachService } from '../../services/coach.service';
import { Ticket } from 'projects/train-reservation-app/src/ticket';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
	selector: 'app-coach',
	templateUrl: './coach.component.html',
	styleUrls: ['./coach.component.scss']
})
export class CoachComponent {

	constructor(private _snackBar: MatSnackBar, private bookingService: BookingService, private coachService: CoachService) { }

	@Input() coach!: Coach;
	@Output() coachChange: EventEmitter<Coach> = new EventEmitter<Coach>();

	bookingMode = false;
	isBooking = false;
	isReseting = false;
	bookingDto?: BookingDto;

	showTicket = false;

	ticket?: Ticket;

	ngOnInit(): void {
		this.coachService.getCoach().subscribe({
			next: (res: any) => {
				this.coach = res;
				this.coachChange.emit(this.coach);
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
		this.isBooking = true;
		this.bookingService.bookTicket(bookingDto).subscribe({
			next: (res) => {
				if (res.status == 400) {
					console.log(res);
					this.openSnackBar(res.detail, "OK");
				} else {
					const ticket: Ticket = res;
					this.coach = ticket.coach;
					this.coachChange.emit(this.coach);
					console.log(res);
					this.ticket = ticket;
					this.showTicket = true;
				}

			},
			error: (err) => {
				console.log(err);
				this.isBooking = false;
				this.openSnackBar(err.message, "OK");
			},
			complete: () => {
				console.log("complete");
				this.isBooking = false;
			}
		})
	}


	resetCoach() {
		this.isReseting = true;
		this.coachService.resetCoach(this.coach.coachId).subscribe({
			next: (res) => {
				if (res.status == 400) {
					console.log(res);
					this.isReseting = false;
					this.openSnackBar(res.detail, "OK");
				} else {
					this.coach = res;
					this.coachChange.emit(this.coach);
					console.log(res);
					this.isReseting = false;
					this.ticket = undefined;
					this.showTicket = false;
				}

			},
			error: (err) => {
				console.log(err);
				this.isReseting = false;
				this.openSnackBar(err.message, "OK");
			},
			complete: () => {
				console.log("complete");
				this.isReseting = false;
			}
		})
	}


	openSnackBar(message: string, action: string) {
		this._snackBar.open(message, action, {
			horizontalPosition: 'center',
			verticalPosition: 'top',
			duration: 2000,
		});
	}
}
