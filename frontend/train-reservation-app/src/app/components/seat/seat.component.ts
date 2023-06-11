import { Component, Input } from '@angular/core';
import { Seat } from 'projects/train-reservation-app/src/seat';

@Component({
	selector: 'app-seat',
	templateUrl: './seat.component.html',
	styleUrls: ['./seat.component.scss']
})
export class SeatComponent {
	@Input() seat!: Seat;
}
