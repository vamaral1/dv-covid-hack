import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterUsersComponent } from './enter-users.component';

describe('EnterUsersComponent', () => {
  let component: EnterUsersComponent;
  let fixture: ComponentFixture<EnterUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnterUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnterUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
