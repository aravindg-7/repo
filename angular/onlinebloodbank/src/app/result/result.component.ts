import { Component, OnInit, Input } from '@angular/core';
import { donor } from '../donor';
import { RequestService } from '../request.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  @Input()
  donorlist:donor[]
  constructor(private reqservice:RequestService,private router:Router) { }

  ngOnInit() {
    this.donorlist=this.reqservice.donorlist
    if(this.donorlist.length<1){
      window.alert("No results found post your request")
      this.router.navigate(['request'])
    }
  }

}
