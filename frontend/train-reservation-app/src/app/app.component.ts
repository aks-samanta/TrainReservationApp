import { Component, Input } from '@angular/core';
import { Coach } from '../coach';
import { NgModel } from '@angular/forms';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'TrainReservationApp';
	@Input() coach!: Coach;
}
