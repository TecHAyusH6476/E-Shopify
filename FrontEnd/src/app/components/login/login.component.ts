import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  matched:any
     constructor(private route:Router,private user:UserService){

     }
     Login=new FormGroup({    
     email : new FormControl('', [Validators.required, Validators.email]),
     password : new FormControl('', [Validators.required])
     });
    
  getErrorMessage() {
    if (this.Login.get('email')?.hasError('required')) {
      return 'You must enter a value';
    }

    return this.Login.get('email')?.hasError('email') ? 'Not a valid email' : '';
  }
  getPasswordErrorMessage() {
    return this.Login.get('password')?.hasError('required') ? 'You must enter a password' : '';
  }
  
  onSubmit() {
    if (this.Login.valid) {
      
      const email = this.Login.value.email;
      const password = this.Login.value.password;
      this.user.getuser(email).subscribe((result)=>{
        this.matched=result;
        if(result!==null&&this.matched.password === password){
          this.user.isAuthenticated = true;
          localStorage.setItem("logged","true");
          this.route.navigate(['home'])  
         
        }
        else{
          
          this.route.navigate([''])  
        }
      })
      
    } 
  }


}
