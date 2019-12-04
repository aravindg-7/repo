import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  loggedInUser={loggedOut:true};
  role: any;
  userId: any;
  validCredentials: boolean=true;
  isAdmin: boolean=false;
  loggedIn: boolean=false;
  accessToken: any;
  error: any;

  
  authenticate(user:string,password:string):Observable<any> {
    let credentials = btoa(user+':'+password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials)
    return this.httpClient.get(environment.baseUrl+"/auth-service/authenticate", {headers})
  }
  constructor(public router: Router,private httpClient:HttpClient) { }

  authenticateUser(user){

  this.authenticate(user.username,user.password).subscribe(
      (data)=>{
        console.log(data.role)
        this.role=data.role;
        this.loggedInUser =user.username;
        this.userId=user.username;
        this.validCredentials = true;
        if(data.role == 'ADMIN')
          this.isAdmin = true;
        this.loggedIn = true;
        // this.foodService.isLoggedIn = true;
        // this.setToken(data.token);
        this.accessToken=data.token;
        console.log(this.accessToken)
        // this.name = this.userService.getUser(user.username).lastname.concat(".").concat(this.userService.getUser(user.username).firstname);
        this.router.navigate(['home']);
      },
      (error)=>{
        this.validCredentials = false;
        this.error = error.error.message;
        if (error.error.errors != null) {
          this.error = error.error.errors[0];
        }
        console.log(error);
        console.log("ERROR");
      }
      )

    }
    logout() {
      // let cartservice:CartService
      this.loggedInUser = {loggedOut:true};
      this.isAdmin = false;
      this.loggedIn = false;
      this.userId=null;
      this.role=null;
      // this.router.navigate(['login']);
      // this.router.navigate(['home']);
    }
}
