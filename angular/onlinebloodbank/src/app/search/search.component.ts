import { Component, OnInit, ɵclearResolutionOfComponentResourcesQueue, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestService } from '../request.service';
import { donor } from '../donor';
import { Search } from '../Search';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router,private reqservice:RequestService) { }
  loginSearchForm :FormGroup;
  searched:boolean=false;
  donorlist:donor[]
  ngOnInit() {
    this.loginSearchForm = this.formBuild.group({
      state: ['',[
        Validators.required
      ]],
      area: ['',[
        Validators.required
      ]],
      pincode:['',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]],
      bloodgroup:['',[Validators.required]]
    })
  }
get state()
{
  return this.loginSearchForm.get('state')
}
get area()
{
  return this.loginSearchForm.get('area');
}
get pincode()
{
  return this.loginSearchForm.get('pincode');
}
get bloodgroup()
{
  return this.loginSearchForm.get('bloodgroup');}

onreq(){
  this.router.navigate(['request'])
}
ondon(){
  this.router.navigate(['donor'])
}
onsubmit(){
  let search:Search={bloodGroup:this.loginSearchForm.value['bloodgroup'],area:this.loginSearchForm.value['area'],
state:this.loginSearchForm.value['state'],pincode:this.loginSearchForm.value['pincode']}
this.searched=true
console.log(search)
this.reqservice.search(search).subscribe(data=>{this.reqservice.donorlist=data
  this.reqservice.request=search
this.router.navigate(['result'])
})
}
}