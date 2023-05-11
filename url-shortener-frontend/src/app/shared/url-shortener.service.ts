import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlShortnerService {
  serviceUrl : string = '';
  constructor(private http : HttpClient) {
    this.serviceUrl = "http://localhost:8079/api/v1/url-shortener";
  }

  getShortUrl(url : string) {
    return this.http.post<any>(this.serviceUrl,url);
  }

}
