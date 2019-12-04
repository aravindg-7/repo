import { Injectable } from '@angular/core';
import { user } from './user';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http: HttpClient) { }

  addUser(newUser:user):Observable<boolean>{
    // this.userList.push(newUser);
    return this.http.post<boolean>(environment.baseUrl+"/auth-service/users",newUser);
  }
}
