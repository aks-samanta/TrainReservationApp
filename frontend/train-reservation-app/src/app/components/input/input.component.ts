
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { BookingDto } from 'projects/train-reservation-app/src/booking-dto';
@Component({
	selector: 'app-input',
	templateUrl: './input.component.html',
	styleUrls: ['./input.component.scss']
})
export class InputComponent {
	noOfSeatsFormControl = new FormControl(1, [
		Validators.required,
		Validators.min(1),
		Validators.max(7)
	]);

	@Input() coachId!: number;
	noOfSeats = 1;
	@Output() onBookEmitter: EventEmitter<BookingDto> = new EventEmitter();

	onBook() {
		if (this.noOfSeatsFormControl.valid) {
			const bookingDto: BookingDto = {
				noOfSeats: this.noOfSeats,
				coachId: this.coachId
			};
			console.log(bookingDto);
			this.onBookEmitter.emit(bookingDto);
		}
	}
}