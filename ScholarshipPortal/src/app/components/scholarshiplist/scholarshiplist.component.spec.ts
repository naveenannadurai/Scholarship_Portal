import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScholarshiplistComponent } from './scholarshiplist.component';

describe('ScholarshiplistComponent', () => {
  let component: ScholarshiplistComponent;
  let fixture: ComponentFixture<ScholarshiplistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScholarshiplistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScholarshiplistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
