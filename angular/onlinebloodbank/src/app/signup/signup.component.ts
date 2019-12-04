import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { UserserviceService } from '../userservice.service';
import { user } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm: FormGroup;
  formSubmitted: boolean;
  error:string;
  status:boolean=false;
  constructor(private formBuilder:FormBuilder,private userService:UserserviceService,private route:Router) { }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      username : ['',[
        Validators.required,
        this.isUsernameTaken
      ]],
      firstname:['',[
        Validators.required
      ]],
      lastname:['',[
        Validators.required
      ]],
      password:['',[
        Validators.required,Validators.minLength(8)
      ]],
      confirmPassword:['',[
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]],
     age:['',[Validators.required,Validators.min(21),Validators.max(60)]],
     gender:['',[Validators.required]],
    contactnumber:['',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]],
    weight:['',[Validators.required]],
    bloodgroup:['',[Validators.required]],
    area:['',[Validators.required]],
    state:['',[Validators.required]],
    pincode:['',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]],
email:['',[Validators.required]],
    })

  }

  get f() { return this.signUpForm.controls; }
  get username() {
    return this.signUpForm.get('username');
  }
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }
  get age() {
    return this.signUpForm.get('age');
  }
  get gender() {
    return this.signUpForm.get('gender');
  }
  get contactnumber() {
    return this.signUpForm.get('contactnumber');
  }
  get weight() {
    return this.signUpForm.get('weight');
  }
  get bloodgroup()
  {
    return this.signUpForm.get('bloodgroup');
  }
  get area()
  {
    return this.signUpForm.get('area');
  }
  get state()
{
  return this.signUpForm.get('state');
}
get pincode()
{
  return this.signUpForm.get('pincode');
}
get email()
{
  return this,this.signUpForm.get('email');
}
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
      if (formControl.value === 'admin') {
          return { 'userNameTaken': true };
        } else {
          return null;
        }
      }
   onsubmit(){
    this.formSubmitted = true;

    const newUser:user = { username: this.signUpForm.value['username'], 
                      firstName: this.signUpForm.value['firstname'], 
                      lastName: this.signUpForm.value['lastname'], 
                      password: this.signUpForm.value['password'],
                      age: this.signUpForm.value['age'],
                      gender: this.signUpForm.value['gender'],
                      email:this.signUpForm.value['email'],
                      state:this.signUpForm.value['state'],
                      area:this.signUpForm.value['area'],
                      pincode:this.signUpForm.value['pincode'],
                      contactno:this.signUpForm.value['contactnumber'],
                      weight:this.signUpForm.value['weight'],
                      bloodgroup:this.signUpForm.value['bloodgroup']

                     };
                     console.log(newUser)
    this.userService.addUser(newUser).subscribe(data => {
        // console.log("new user added: "+data);
        // this.userService.userList.push(newUser);
        // console.log(this.userService.userList);
        this.status=false;
        this.route.navigate(['login'])
    },
    (error)=>{
      this.status=true;
      this.error = error.error.message;
        if (error.error.errors != null) {
          this.error = error.error.errors[0];
        }
    },
    );
    
    this.signUpForm.reset();

  }

  }


