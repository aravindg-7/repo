import { Component, OnInit } from '@angular/core';
import { bloodrequest } from '../bloodrequest';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
  request:bloodrequest={bloodGroup:"",state:"",area:""}
  constructor(private formBuild:FormBuilder,private router:Router,private reqservice:RequestService ) { }
requestForm:FormGroup;
  ngOnInit() {
    this.request=this.reqservice.request
    this.requestForm = this.formBuild.group({
      bloodgroup: [this.request.bloodGroup,[
        Validators.required
      ]],
      state: [this.request.state,[
        Validators.required
      ]],
      area:[this.request.area,[Validators.required]],
      pincode:[this.request.pincode,[Validators.required,Validators.minLength(6),Validators.maxLength(6)]],
      contactnumber:[this.request.contactNumber,[Validators.required,Validators.minLength(10),Validators.maxLength(10)]]
    })
  }
get bloodgroup()
{
  return this.requestForm.get('bloodgroup');
}
get state()
{
  return this.requestForm.get('state');
}
get area()
{
  return this.requestForm.get('area');
}
get pincode()
{
  return this.requestForm.get('pincode');
}
get contactnumber()
{
  return this.requestForm.get('contactnumber');
}
requestBlood()
{
  let Request:bloodrequest={bloodGroup:this.requestForm.value["bloodgroup"],
  state:this.requestForm.value["state"],
  pincode:this.requestForm.value["pincode"],
  area:this.requestForm.value["area"],
  contactNumber:this.requestForm.value["contactnumber"]};
   this.reqservice.postrequest(Request).subscribe(data=>{
    window.alert("Your request has been posted") 
    this.router.navigate(['home'])})
}
}

