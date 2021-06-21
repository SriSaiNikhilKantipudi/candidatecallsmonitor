import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageComponentComponent } from './admin-page-component.component';

describe('AdminPageComponentComponent', () => {
  let component: AdminPageComponentComponent;
  let fixture: ComponentFixture<AdminPageComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminPageComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
