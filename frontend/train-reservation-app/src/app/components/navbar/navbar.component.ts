import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ErdDialogComponent } from './erd-dialog/erd-dialog.component';
import { HttpClient } from '@angular/common/http';
import { Coach } from 'projects/train-reservation-app/src/coach';
import { CoachService } from '../../services/coach.service';

@Component({
	selector: 'app-navbar',
	templateUrl: './navbar.component.html',
	styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
	constructor(public dialog: MatDialog, private coachService: CoachService) { }
	@Input() coach!: Coach;

	@Output() newCoachEmitter: EventEmitter<Coach> = new EventEmitter<Coach>();

	openERD() {
		const dialogRef = this.dialog.open(ErdDialogComponent);

		dialogRef.afterClosed().subscribe(result => {
			console.log(`Dialog result: ${result}`);
		});
	}

	createNewCoach() {
		this.coachService.createNewCoach().subscribe({
			next: (res: any) => {
				this.coach = res;
				this.newCoachEmitter.emit(this.coach);
				alert("new coach has been created in the database with new empty seats, please refresh to view the new coach...")
			},
			error: (err: any) => {
				console.log(err);
			},
			complete: () => {
				console.log("create new coach completed");
			}
		})
	}
}
