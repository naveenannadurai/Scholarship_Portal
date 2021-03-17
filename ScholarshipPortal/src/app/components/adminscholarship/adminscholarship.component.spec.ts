import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminscholarshipComponent } from './adminscholarship.component';

describe('AdminscholarshipComponent', () => {
  let component: AdminscholarshipComponent;
  let fixture: ComponentFixture<AdminscholarshipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminscholarshipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminscholarshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
