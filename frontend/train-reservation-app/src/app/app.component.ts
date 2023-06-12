import { Component } from '@angular/core';
import { Coach } from '../coach';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'TrainReservationApp';
	coach: Coach = {
		coachId: 0,
		totalSeats: 0,
		availableSeats: 0,
		seats: []
	};

}
