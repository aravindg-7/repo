import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { HospitalSlot } from '../HospitalSlot';
import { RequestService } from '../request.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private reqservice:RequestService,private router:Router) { }

  slotForm:FormGroup;
  status:boolean=false;
  error:string;
  ngOnInit() {
  
    this.slotForm = this.formBuilder.group({
      hospital: ['',[
        Validators.required
      ]],
      city: ['',[
        Validators.required
      ]],
      date:['',[Validators.required]],
      time:['',[Validators.required]]
    })
  }
get hospital()
{
  return this.slotForm.get('hospital');
}
get city()
{
  return this.slotForm.get('city');
}
get date()
{
  return this.slotForm.get('date');
}
get time()
{
  return this.slotForm.get('time');
}

onsubmit(){
  let slot:HospitalSlot={hospitalname:this.slotForm.value['hospital'],
                        city:this.slotForm.value['city'],
                        timeslot:this.slotForm.value['time'],
                        slotdate:this.slotForm.value['date']}
                        console.log(slot)           
  this.reqservice.requestslot(slot).subscribe(data=>{
    this.status=data
    window.alert("Your slot has been booked")
    // console.log(this.status)
    // console.log(slot)
    this.router.navigate(['home'])
  },
  (error)=>{
    this.status=true;
    this.error = error.error.message;
      if (error.error.errors != null) {
        this.error = error.error.errors[0];
      }
  }
  )
  // this.slotForm.reset();
}

}
