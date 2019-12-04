import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public router: Router,private authService:AuthserviceService) { }
  isLoggedIn:boolean = false;
  ngOnInit() {
    this.router.navigate(['home']);
  }
  loggedIn():boolean {
    if(!this.authService.loggedInUser.loggedOut){
      this.isLoggedIn = true;
      return true
    }
    else{
      this.isLoggedIn = false;
      return false;
    }
  }
  clicked(){
    // this.foodService.clickedOnAdd = false;
    // this.foodService.addedToCart = false;
  }
}
