import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
     
  error=false;
  message=""
  Registration = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.pattern(/^[a-zA-Z]+$/)
    ]),
   
    password: new FormControl('', [ Validators.required,
      Validators.minLength(6),
      Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>])[A-Za-z\d!@#$%^&*(),.?":{}|<>]{6,}$/)]),
    
  });
  
  

constructor(private router:Router,private userservice:UserService){}
getEmailError() {
  if (this.Registration.get('email')?.hasError('required')) {
    return 'You must enter a value';
  }

  return this.Registration.get('email')?.hasError('email') ? 'Not a valid email' : '';
}
getPasswordError(){
  if (this.Registration.get('password')?.hasError('required')) {
    return 'You must enter a value';
  }
  else if(this.Registration.get('password')?.hasError('minlength')){
   
    return 'Password should be at least 6 characters long';
  }
  else if(this.Registration.get('password')?.hasError('pattern')){
    return 'Not Valid Password';
  }
 
  return '';
}

getNameError(){
     
  if (this.Registration.get('name')?.hasError('required')) {
    return 'You must enter a value';
  }
  else if(this.Registration.get('name')?.hasError('minlength')){
   
    return 'Name should be at least 6 characters long';
  }
  else if(this.Registration.get('name')?.hasError('pattern')){
    return 'Not a valid name';
  }
 
  return '';

 
}
  register(){
          
    
       
       this.userservice.getuser(this.Registration.value.email).subscribe((result)=>{
              if(result==null){

                const user = {
                  email: this.Registration.value.email,
                  name: this.Registration.value.name,
                  password: this.Registration.value.password
                };
                   this.userservice.addUser(user).subscribe(()=>{
                       this.router.navigate(['']);
                   })
              }
              else{
                this.error=true
                this.message="UsearAlreadyExist"
              }

       })
 
  }

}
