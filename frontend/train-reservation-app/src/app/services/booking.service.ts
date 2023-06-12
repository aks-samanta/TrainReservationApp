import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookingDto } from '../../booking-dto';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class BookingService {

	constructor(private http: HttpClient) { }

	url = "https://trainreservationappbackend.up.railway.app/";


	bookTicket(bookingDto: BookingDto): Observable<any> {
		const headers = new HttpHeaders({
			'content-type': 'application/json',
		});
		console.log(bookingDto);
		return this.http.post(this.url + "tickets/book", bookingDto, { headers });
	}
}
