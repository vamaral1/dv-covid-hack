import { Component, OnInit } from '@angular/core';

interface Item {
  facilityName: string;
  name: string;
  type: string;
  size: string;
}

const ITEMS: Item[] = [
  {
    facilityName: 'University of Colorado Anschutz Medical Campus',
    name: 'Ventilator',
    type: 'Non-invasive',
    size: 'Pediatric'
  },
  {
    facilityName: 'National Jewish',
    name: 'Mask',
    type: 'Respirator',
    size: 'Large'
  },
  {
    facilityName: 'Denver Health',
    name: 'Mask',
    type: 'Surgical',
    size: 'Small'
  },
  {
    facilityName: 'Parker Adventist',
    name: 'Gloves',
    type: 'Nitrile',
    size: 'Medium'
  }
];

@Component({
  selector: 'app-suply-list',
  templateUrl: './suply-list.component.html',
  styleUrls: ['./suply-list.component.css']
})
export class SuplyListComponent implements OnInit {

  constructor() { }

  items = ITEMS;

  buttonModel = {
    ventilators: false,
    masks: false,
    gloves: false,
    beds: false
  };

  ngOnInit() {
  }

}
