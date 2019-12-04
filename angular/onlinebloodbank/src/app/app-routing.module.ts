import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';
import { RequestComponent } from './request/request.component';
import { SlotComponent } from './slot/slot.component';
import { DonateComponent } from './donate/donate.component';
import { ResultComponent } from './result/result.component';


const routes: Routes = [
  {path:'',redirectTo: 'home', pathMatch: 'full' },
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'search',component:SearchComponent},
  {path:'request',component:RequestComponent},
  {path:'slot',component:SlotComponent},
  {path:'donor',component:DonateComponent},
  {path:'result',component:ResultComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
