import { Injectable } from '@angular/core';
 import { User } from './user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

 constructor( private _http : HttpClient) { }
   public login(user :User):Observable<any>{

   return this._http.post<any>("http://localhost:8080/api/v1/candidate/auth",{userId: user.userid,password:user.password});

   }

   public register(user :User):Observable<any>{
  
    return this._http.post<any>("http://localhost:8080/api/v1/candidate",user);

   }

   public addCallDetails(companyName:string, candidateId: Number):Observable<any> {
     return this._http.post<any>(`http://localhost:8080/api/v1/candidate/${candidateId}/candidateCall`, {companyname: companyName});
   }

   public getCallDetails(candidateId:Number):Observable<any>{
    return this._http.get<any>(`http://localhost:8080/api/v1/candidateCallList/${candidateId}`);
   }
}
