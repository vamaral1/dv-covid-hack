import { AfterViewInit, Component } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit  {

  private map;
  private tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
  });
  private popup = L.popup();

  constructor() { }

  ngAfterViewInit(): void {
    this.initMap();
    this.tiles.addTo(this.map);
    this.addMarkers();
    this.addListners();
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: [ 39.8282, -98.5795 ],
      zoom: 5
    });
  }

  private addMarkers(): void {
    L.circle([39.72371,-104.894], {color: '#13b03d',  fillColor: '#86bd95', fillOpacity: 0.5, radius: 500}).addTo(this.map);
    L.circle([40.01632,-105.236], {color: '#e80c25',  fillColor: '#e86b79', fillOpacity: 0.5, radius: 500}).addTo(this.map);
    L.circle([39.40532,-104.887], {color: '#f2f20f',  fillColor: '#f7f7a8', fillOpacity: 0.5, radius: 500}).addTo(this.map);
    L.circle([40.57444,-105], {color: '#13b03d',  fillColor: '#86bd95', fillOpacity: 0.5, radius: 500}).addTo(this.map);
    L.circle([39.16138,-105.061], {color: '#13b03d',  fillColor: '#86bd95', fillOpacity: 0.5, radius: 500}).addTo(this.map);
  }

  private addListners(): void {
    this.map.on('contextmenu', function(e){

    });
  }

}
