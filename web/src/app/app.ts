import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CreditoService } from './services/CreditoService';
import { Credito } from './models/Credito';
import { CreditListComponent } from './components/credit-list/credit-list.component';
import { CreditSearchComponent } from './components/credit-search/credit-search.component';
import { HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  selector: 'app-root',
  imports: [
    HttpClientModule,
    CreditListComponent, 
    CreditSearchComponent
  ],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  creditos: Credito[] = [];

  constructor(private creditoService: CreditoService) {}

  ngOnInit(): void {
    this.buscarTodos();
  }

  buscarTodos() {
    this.creditoService.getAllCreditos().subscribe(data => {
      this.creditos = data
    });
  }

  buscarPorNfse(numeroNfse: string) {
    this.creditoService.getCreditosByNumeroNfse(numeroNfse).subscribe(data => this.creditos = data);
  }

  buscarPorCredito(numeroCredito: string) {
    this.creditoService.getCreditoByNumeroCredito(numeroCredito).subscribe(data => this.creditos = [data]);
  }
}
