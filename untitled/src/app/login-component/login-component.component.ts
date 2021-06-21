import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  userName: any ;
  password: any ;
  postData: any;
  // dataRecieved: any;
  url='http://localhost:8080/api/v1/candidate/auth'
  response: any;


  constructor(public http: HttpClient,public router: Router) { }

  ngOnInit(): void {
  }

  validateUser() {
   // @ts-ignore
    // @ts-ignore
    this.postData={
      userId: this.userName,
      password: this.password,
    };
    this.http.post(this.url,this.postData).toPromise().then((data:any)=>{
      console.log(data);
      // this.dataRecieved = data;


      if(data == 0){
        this.response = "Not A Valid User";
      }
      else if (data == 1)
      {
        this.router.navigate(['/candidatePage']);
      }
      else if (data == 2)
      {
        this.router.navigate(['/adminPage'])
      }
    });
    // console.log(this.dataRecieved);

  }

  registerUser() {
    this.router.navigate(['/registerPage'])
  }
}
