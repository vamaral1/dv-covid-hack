import { Component, OnInit } from '@angular/core';

interface Item {
  name: string;
  type: string;
  size: string;
}

const ITEMS: Item[] = [
  {
    name: 'Ventilator',
    type: 'Non-invasive',
    size: 'Pediatric'
  },
  {
    name: 'Mask',
    type: 'Respirator',
    size: 'Large'
  },
  {
    name: 'Mask',
    type: 'Surgical',
    size: 'Small'
  },
  {
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

  ngOnInit() {
  }

}
