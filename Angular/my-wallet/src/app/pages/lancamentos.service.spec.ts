import { TestBed } from '@angular/core/testing';

import { LancamentosService } from './lancamentos.service';

describe('LancamentosService', () => {
  let service: LancamentosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LancamentosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
