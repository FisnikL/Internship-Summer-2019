import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowSearchComponent } from './show-search/show-search.component';
import { ShowDetailsComponent } from './show-details/show-details.component';


const routes: Routes = [
  {
    path: 'search',
    component: ShowSearchComponent
  },
  {
    path: 'shows/:id',
    component: ShowDetailsComponent
  },
  {
    path: '',
    redirectTo: 'search',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
