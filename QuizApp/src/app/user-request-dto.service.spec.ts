import { TestBed } from '@angular/core/testing';

import { UserRequestDTOService } from './user-request-dto.service';

describe('UserRequestDTOService', () => {
  let service: UserRequestDTOService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserRequestDTOService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
