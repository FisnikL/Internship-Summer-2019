import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShowSearchComponent } from './show-search/show-search.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ShowSearchResultComponent } from './show-search-result/show-search-result.component';
import { HttpClientModule } from '@angular/common/http';
import { ShowDetailsComponent } from './show-details/show-details.component';
import { ShowCastComponent } from './show-cast/show-cast.component';
import { ShowEpisodesComponent } from './show-episodes/show-episodes.component';

@NgModule({
  declarations: [
    AppComponent,
    ShowSearchComponent,
    ShowSearchResultComponent,
    ShowDetailsComponent,
    ShowCastComponent,
    ShowEpisodesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
