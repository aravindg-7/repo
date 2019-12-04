import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestService } from '../request.service';
import { donor } from '../donor';

@Component({
  selector: 'app-donate',
  templateUrl: './donate.component.html',
  styleUrls: ['./donate.component.css']
})
export class DonateComponent implements OnInit {

  constructor(private formBuild:FormBuilder,private router:Router,private reqservice:RequestService ) { }
requestForm:FormGroup;
  ngOnInit() {
  
    this.requestForm = this.formBuild.group({
      bloodgroup: ['',[
        Validators.required
      ]],
      state: ['',[
        Validators.required
      ]],
      area:['',[Validators.required]],
      pincode:['',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]],
      contactnumber:['',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]]
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

donationform(){
  let donor:donor={bloodGroup:this.requestForm.value["bloodgroup"],
  state:this.requestForm.value["state"],
  pincode:this.requestForm.value["pincode"],
  area:this.requestForm.value["area"],
  contactNumber:this.requestForm.value["contactnumber"]};
   this.reqservice.donorpost(donor).subscribe(data=>{
    this.router.navigate(['slot'])})
}
}
