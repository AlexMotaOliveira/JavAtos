import { TestBed } from '@angular/core/testing';

import { AuthinterceptorInterceptor } from './authinterceptor.interceptor';

describe('AuthinterceptorInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      AuthinterceptorInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: AuthinterceptorInterceptor = TestBed.inject(AuthinterceptorInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
