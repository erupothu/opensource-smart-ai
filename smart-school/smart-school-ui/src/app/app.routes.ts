import { Routes } from '@angular/router';

export const routes: Routes = [
	{ path: '', pathMatch: 'full', redirectTo: 'schools' },
	{
		path: 'schools',
		loadComponent: () => import('./features/schools/school-list/school-list.component').then(m => m.SchoolListComponent)
	}
];
