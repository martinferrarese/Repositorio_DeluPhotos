import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'landing';
  result = "";

  constructor(private http: HttpClient){}

  public holaMundo(): void {
    this.result = 'loading...';
    this.http.get('api/saludar-a-maca', {responseType: 'text'}).subscribe(result => {
      this.result = result.toString();
    });
  }
}
