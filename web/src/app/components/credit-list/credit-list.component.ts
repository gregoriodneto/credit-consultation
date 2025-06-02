import { Component, Input } from '@angular/core';
import { Credito } from '../../models/Credito';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-credit-list',
  templateUrl: './credit-list.component.html',
  styleUrls: ['./credit-list.component.css'],
  imports: [CommonModule]
})
export class CreditListComponent {
  @Input() creditos: Credito[] = [];
}