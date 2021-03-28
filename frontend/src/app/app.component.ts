import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  dynamicSlides = [
    {
      id: "1",
      src:'./assets/img/delu1.jpg',
      alt:'Pulsera',
      title:'Pulsera',
      url: "http://google.com.ar"
    },
    {
      id: "2",
      src:'./assets/img/delu2.jpg',
      alt:'Golosinas',
      title:'Golosinas'
    },
    {
      id: "3",
      src:'./assets/img/delu3.jpg',
      alt:'Cuadrito',
      title:'Cuadrito'
    },
    {
      id: "4",
      src:'./assets/img/delu4.jpg',
      alt:'Remera',
      title:'Remera'
    },
    {
      id: "5",
      src:'./assets/img/delu5.jpg',
      alt:'Cuadrito dibujado',
      title:'Cuadrito dibujado'
    },
    {
      id: "6",
      src:'./assets/img/delu6.jpg',
      alt:'Calendario',
      title:'Calendario'
    },
    {
      id: "7",
      src:'./assets/img/delu7.jpg',
      alt:'Navidad',
      title:'Navidad'
    },
    {
      id: "8",
      src:'./assets/img/delu8.jpg',
      alt:'Taza',
      title:'Taza'
    }
  ]

  constructor(private http: HttpClient){}

  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 900,
    autoplay: true,
    autoplayTimeout: 2000,
    navText: ['&#8249', '&#8250;'],
    responsive: {
      0: {
        items: 1 
      },
      400: {
        items: 2
      },
      760: {
        items: 3
      },
      1000: {
        items: 4
      }
    },
    nav: false
  }

}
