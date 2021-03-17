import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmindashnavComponent } from './admindashnav.component';

describe('AdmindashnavComponent', () => {
  let component: AdmindashnavComponent;
  let fixture: ComponentFixture<AdmindashnavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmindashnavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmindashnavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
