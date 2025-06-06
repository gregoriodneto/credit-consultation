import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credito } from '../models/Credito';

@Injectable({
  providedIn: 'root',
})
export class CreditoService {
  private apiUrl = 'http://localhost:8080/api/creditos';

  constructor(private http: HttpClient) { }

  getAllCreditos(): Observable<Credito[]> {
    return this.http.get<Credito[]>(this.apiUrl);
  }

  getCreditosByNumeroNfse(numeroNfse: string): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.apiUrl}/${numeroNfse}`);
  }

  getCreditoByNumeroCredito(numeroCredito: string): Observable<Credito> {
    return this.http.get<Credito>(`${this.apiUrl}/credito/${numeroCredito}`);
  }
}