import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {
  Name: any ;
  userName: any ;
  password: any ;
  postData: any;
  // dataRecieved: any;
  url='http://localhost:8080/api/v1/candidate'
  constructor(public http: HttpClient,public router: Router) { }

  ngOnInit(): void {
  }

  registerUser() {
    this.postData={
      name: this.Name,
      userId: this.userName,
      password: this.password,
    };
    this.http.post(this.url,this.postData).toPromise().then((data:any)=>{
      console.log(data);

  });
    this.router.navigate(['/']);
}
}
