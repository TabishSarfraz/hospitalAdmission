import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmissionsCreateComponent } from './admissions-create.component';

describe('AdmissionsCreateComponent', () => {
  let component: AdmissionsCreateComponent;
  let fixture: ComponentFixture<AdmissionsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmissionsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmissionsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
