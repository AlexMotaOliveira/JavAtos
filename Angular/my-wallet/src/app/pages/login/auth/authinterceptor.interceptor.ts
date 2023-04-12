import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class AuthinterceptorInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (!request.url.includes('/oauth/token')) {
      const token = localStorage.getItem('token');
      const requestClone = request.clone(
        {
          setHeaders: {
            Authorization: `Bearer ${token}`
          }
        }
      )
      return next.handle(requestClone);
    }
    return next.handle(request)
  }
}
