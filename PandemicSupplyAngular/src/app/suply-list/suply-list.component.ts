import { Component, OnInit, PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

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

function search(text: string, pipe: PipeTransform): Item[] {
  return ITEMS.filter(item => {
    const term = text.toLowerCase();
    return item.facilityName.toLowerCase().includes(term)
        || pipe.transform(item.name).includes(term)
        || pipe.transform(item.type).includes(term)
        || pipe.transform(item.size).includes(term);
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
