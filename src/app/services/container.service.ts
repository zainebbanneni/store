import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StoreRequest } from 'src/app/models/storeRequest.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';




@Injectable({
  providedIn: 'root'
})
export class ContainerService {
  private apiServerUrl = environment.apiBaseUrl;
  

  constructor(private http: HttpClient) { }

  public createCont(storeRequest: StoreRequest): Observable<StoreRequest> {
    return this.http.post(`${this.apiServerUrl}/container/req`, storeRequest);
  }
}


