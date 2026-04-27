import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { School } from '../models/school.model';

@Injectable({
  providedIn: 'root'
})
export class SchoolService {

  private readonly base = `${environment.apiBaseUrl}/schools`;

  constructor(private http: HttpClient) { }

  list(): Observable<School[]> {
    return this.http.get<School[]>(this.base);
  }

  get(id: number): Observable<School> {
    return this.http.get<School>(`${this.base}/${id}`);
  }

  create(payload: Partial<School>): Observable<School> {
    return this.http.post<School>(this.base, payload);
  }

  update(id: number, payload: Partial<School>): Observable<School> {
    return this.http.put<School>(`${this.base}/${id}`, payload);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.base}/${id}`);
  }
}
