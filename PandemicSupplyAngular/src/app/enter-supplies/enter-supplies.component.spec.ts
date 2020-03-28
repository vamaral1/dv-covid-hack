import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterSuppliesComponent } from './enter-supplies.component';

describe('EnterSuppliesComponent', () => {
  let component: EnterSuppliesComponent;
  let fixture: ComponentFixture<EnterSuppliesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnterSuppliesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnterSuppliesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
