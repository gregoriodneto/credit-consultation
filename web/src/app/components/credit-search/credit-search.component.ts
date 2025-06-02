import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-credit-search',
  templateUrl: './credit-search.component.html',
  styleUrls: ['./credit-search.component.css'],
  imports: [FormsModule]
})
export class CreditSearchComponent {
  numeroNfse: string = '';
  numeroCredito: string = '';

  @Output() searchByNfse = new EventEmitter<string>();
  @Output() searchByCredito = new EventEmitter<string>();

  searchNfse() {
    this.searchByNfse.emit(this.numeroNfse);
  }

  searchCredito() {
    this.searchByCredito.emit(this.numeroCredito);
  }
}