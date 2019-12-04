import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { bloodrequest } from './bloodrequest';
import { environment } from 'src/environments/environment';
import { Search } from './Search';
import { AuthserviceService } from './authservice.service';
import { donor } from './donor';
import { HospitalSlot } from './HospitalSlot';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  donorlist:donor[]
  request:bloodrequest;
  constructor(private httpClient:HttpClient,private authservice:AuthserviceService) { }

  getrequest():Observable<any>{
    return this.httpClient.get<bloodrequest[]>(environment.baseUrl+"/auth-service/home")
  }
  search(search:Search):Observable<any>{
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.httpClient.post<donor[]>(environment.baseUrl+"/bloodbank-service/search",search,{headers})
  }
  postrequest(request:bloodrequest):Observable<any>{
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.httpClient.post<donor[]>(environment.baseUrl+"/bloodbank-service/bloodrequest/"+this.authservice.userId,request,{headers})
  }
  requestslot(slot:HospitalSlot):Observable<any>{
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.httpClient.post<boolean>(environment.baseUrl+"/bloodbank-service/hospitalslot/"+this.authservice.userId,slot,{headers})
  }

  donorpost(donor:donor):Observable<any>{
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.httpClient.post<void>(environment.baseUrl+"/bloodbank-service/donate/"+this.authservice.userId,donor,{headers})
  }

}
