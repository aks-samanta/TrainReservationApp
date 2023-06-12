import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { HttpClientModule } from '@angular/common/http';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatChipsModule } from '@angular/material/chips';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSnackBarModule } from '@angular/material/snack-bar';


import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { CoachComponent } from './components/coach/coach.component';
import { SeatComponent } from './components/seat/seat.component';
import { TicketComponent } from './components/ticket/ticket.component';
import { InputComponent } from './components/input/input.component';
import { ErdDialogComponent } from './components/navbar/erd-dialog/erd-dialog.component';

@NgModule({
	declarations: [
		AppComponent,
		NavbarComponent,
		FooterComponent,
		CoachComponent,
		SeatComponent,
		TicketComponent,
		InputComponent,
		ErdDialogComponent
	],
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		FormsModule,
		ReactiveFormsModule,
		MatInputModule,
		MatToolbarModule,
		MatIconModule,
		HttpClientModule,
		MatGridListModule,
		MatCardModule,
		MatDialogModule,
		MatButtonModule,
		MatProgressSpinnerModule,
		MatChipsModule,
		MatTooltipModule,
		MatSnackBarModule
	],
	providers: [
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
