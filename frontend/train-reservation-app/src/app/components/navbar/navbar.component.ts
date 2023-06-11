import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ErdDialogComponent } from './erd-dialog/erd-dialog.component';

@Component({
	selector: 'app-navbar',
	templateUrl: './navbar.component.html',
	styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
	constructor(public dialog: MatDialog) { }

	openERD() {
		const dialogRef = this.dialog.open(ErdDialogComponent);

		dialogRef.afterClosed().subscribe(result => {
			console.log(`Dialog result: ${result}`);
		});
	}
}
