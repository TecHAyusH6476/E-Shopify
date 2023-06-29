import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
   isAuthenticated = false;
  constructor(private http: HttpClient) { }
  private url = "http://localhost:8081/";
   
  getuser(email:any){
    const user= this.http.get(this.url+"user/"+email);
    
    return user;
}
addUser(User:any){
  return this.http.post(this.url+"user",User)
}
isAuthenticate(): boolean {
      return this.isAuthenticated;
}

}
