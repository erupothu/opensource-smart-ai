import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SchoolService } from '../../../services/school.service';
import { School } from '../../../models/school.model';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-school-list',
  standalone: true,
  imports: [CommonModule, MatListModule],
  templateUrl: './school-list.component.html',
  styleUrl: './school-list.component.scss'
})
export class SchoolListComponent implements OnInit {

  schools: School[] = [];

  constructor(private service: SchoolService) {}

  ngOnInit(): void {
    this.service.list().subscribe({
      next: s => this.schools = s,
      error: () => this.schools = []
    });
  }
}
