import { Component, OnInit, PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

interface Item {
  facilityName: string;
  ventilators: number;
  gloves: number;
  masks: number;
  beds: number;
}

const ITEMS: Item[] = [
  {
    facilityName: 'University of Colorado Anschutz Medical Campus',
    ventilators: 7,
    gloves: 600,
    masks: 800,
    beds: 12
  },
  {
    facilityName: 'National Jewish',
    ventilators: 0,
    gloves: 200,
    masks: 1100,
    beds: 3
  },
  {
    facilityName: 'Denver Health',
    ventilators: 14,
    gloves: 2000,
    masks: 2400,
    beds: 0
  },
  {
    facilityName: 'Parker Adventist',
    ventilators: 4,
    gloves: 3300,
    masks: 100,
    beds: 9
  },
  {
    facilityName: 'Swedish Medical Center',
    ventilators: 18,
    gloves: 700,
    masks: 1500,
    beds: 10
  }
];

function search(text: string, pipe: PipeTransform): Item[] {
  return ITEMS.filter(item => {
    const term = text.toLowerCase();
    return item.facilityName.toLowerCase().includes(term)
        || pipe.transform(item.ventilators).includes(term)
        || pipe.transform(item.gloves).includes(term)
        || pipe.transform(item.masks).includes(term)
        || pipe.transform(item.beds).includes(term);
  });
}

@Component({
  selector: 'app-suply-list',
  templateUrl: './suply-list.component.html',
  styleUrls: ['./suply-list.component.css'],
  providers: [DecimalPipe]
})
export class SuplyListComponent implements OnInit {

  items$: Observable<Item[]>;
  filter = new FormControl('');

  constructor(pipe: DecimalPipe) {
    this.items$ = this.filter.valueChanges.pipe(
      startWith(''),
      map(text => search(text, pipe))
    );
   }

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
