import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuplyListComponent } from './suply-list.component';

describe('SuplyListComponent', () => {
  let component: SuplyListComponent;
  let fixture: ComponentFixture<SuplyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuplyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuplyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
