import { TestBed } from '@angular/core/testing';

import { AdmissionsListService } from './admissions-list.service';

describe('AdmissionsListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdmissionsListService = TestBed.get(AdmissionsListService);
    expect(service).toBeTruthy();
  });
});
