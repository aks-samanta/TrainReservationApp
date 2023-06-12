import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class CoachService {

	constructor(private http: HttpClient) { }

	url = "https://trainreservationappbackend.up.railway.app/"


	getCoach(): Observable<any> {
		const headers = new HttpHeaders({
			'content-type': 'application/json'
		})
		return this.http.get(this.url + "coaches", { headers });
	}

	createNewCoach(): Observable<any> {
		const headers = new HttpHeaders({
			'content-type': 'application/json'
		})
		return this.http.post(this.url + "coaches", {}, { headers });
	}


}
