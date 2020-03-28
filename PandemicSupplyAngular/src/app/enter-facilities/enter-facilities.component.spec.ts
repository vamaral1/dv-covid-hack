import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterFacilitiesComponent } from './enter-facilities.component';

describe('EnterFacilitiesComponent', () => {
  let component: EnterFacilitiesComponent;
  let fixture: ComponentFixture<EnterFacilitiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnterFacilitiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnterFacilitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
