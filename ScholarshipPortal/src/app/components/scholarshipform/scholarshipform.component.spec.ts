import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScholarshipformComponent } from './scholarshipform.component';

describe('ScholarshipformComponent', () => {
  let component: ScholarshipformComponent;
  let fixture: ComponentFixture<ScholarshipformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScholarshipformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScholarshipformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
