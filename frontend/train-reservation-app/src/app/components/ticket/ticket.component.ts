import { Component, Input } from '@angular/core';
import { Ticket } from 'projects/train-reservation-app/src/ticket';

@Component({
	selector: 'app-ticket',
	templateUrl: './ticket.component.html',
	styleUrls: ['./ticket.component.scss']
})
export class TicketComponent {

	@Input() ticket!: Ticket;


}
