import { Component, OnInit } from '@angular/core';
import { bloodrequest } from '../bloodrequest';
import { RequestService } from '../request.service';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  reqlist:bloodrequest[]
  constructor(private reqservice:RequestService,private authservice:AuthserviceService) { }
  
  ngOnInit() {
    this.reqservice.getrequest().subscribe(data =>this.reqlist=data)
  }

}
