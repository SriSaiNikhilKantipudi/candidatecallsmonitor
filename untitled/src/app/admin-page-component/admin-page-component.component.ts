import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-admin-page-component',
  templateUrl: './admin-page-component.component.html',
  styleUrls: ['./admin-page-component.component.css']
})
export class AdminPageComponentComponent implements OnInit {
  totalAngularPackages = [];

  constructor(public http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8080/api/v1/candidate").subscribe(data =>{
      console.log(data);
      for(let i in data)
      {
        // @ts-ignore
        this.totalAngularPackages.push(data[i]);
      }

    })
    console.log(this.totalAngularPackages);
  }


}
